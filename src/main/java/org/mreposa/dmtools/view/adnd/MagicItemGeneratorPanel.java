package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.MagicItemGenerator;
import org.mreposa.dmtools.model.adnd.magic.MagicItem;
import org.mreposa.dmtools.model.adnd.magic.MagicItemTable;
import org.mreposa.dmtools.model.adnd.magic.unusual.UnusualWeapon;
import org.mreposa.dmtools.model.adnd.magic.unusual.extraordinary.ExtraordinaryPower;
import org.mreposa.dmtools.model.adnd.magic.unusual.primary.PrimaryAbility;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;
import java.util.List;
import java.util.Set;

public class MagicItemGeneratorPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final MagicItemGenerator magicItemGenerator;
    private final JTextField itemCount;
    private final JComboBox<String> itemType;
    private final JEditorPane display;

    public MagicItemGeneratorPanel(DiceRollGenerator rollGenerator) {
        super();

        this.magicItemGenerator = new MagicItemGenerator(rollGenerator);

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        String labelText = "Number (" + DiceRollGenerator.MIN_DICE_COUNT + " - " + DiceRollGenerator.MAX_DICE_COUNT + "):";
        JLabel label1 = new JLabel(labelText);
        selectionPanel.add(label1);

        this.itemCount = new JTextField("1");
        this.itemCount.setColumns(3);
        selectionPanel.add(this.itemCount);

        JLabel label2 = new JLabel("Magic Item Type:");
        selectionPanel.add(label2);

        this.itemType = new JComboBox<>(MagicItemTable.MAGIC_ITEM_TYPES);
        this.itemType.setSelectedIndex(0);
        selectionPanel.add(this.itemType);

        JButton generateButton = new JButton("Generate");
        Dimension bd = new Dimension(90, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> displayRoll());
        selectionPanel.add(generateButton);

        JButton generateUnusualButton = new JButton("Generate Unusual Weapon");
        Dimension bd2 = new Dimension(210, 20);
        generateUnusualButton.setSize(bd2);
        generateUnusualButton.setPreferredSize(bd2);
        generateUnusualButton.setMaximumSize(bd2);
        generateUnusualButton.addActionListener(_ -> displayUnusualWeapon());
        selectionPanel.add(generateUnusualButton);

        JButton clearButton = new JButton("Clear");
        Dimension bd3 = new Dimension(90, 20);
        clearButton.setSize(bd3);
        clearButton.setPreferredSize(bd3);
        clearButton.setMaximumSize(bd3);
        clearButton.addActionListener(_ -> clearDisplay());
        selectionPanel.add(clearButton);

        this.display = new JEditorPane();
        this.display.setEditable(false);

        add(selectionPanel, BorderLayout.NORTH);
        add(this.display, BorderLayout.CENTER);
    }

    private void displayRoll() {
        int itemCount = Integer.parseInt(this.itemCount.getText());
        String itemType = MagicItemTable.MAGIC_ITEM_TYPES[this.itemType.getSelectedIndex()];

        List<MagicItem> magicItems = this.magicItemGenerator.generate(itemCount, itemType);

        String output = getOutput(magicItems);

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), output, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private String getOutput(List<MagicItem> magicItems) {
        StringBuilder output = new StringBuilder();
        int a = 0;
        for (MagicItem magicItem : magicItems) {
            output.append(magicItem.getName());

            if (a < magicItems.size() - 1) {
                output.append(", ");
            }

            a++;
        }
        output.append("\n\n");

        return output.toString();
    }

    private void displayUnusualWeapon() {
        UnusualWeapon weapon = this.magicItemGenerator.generateUnusualWeapon();
        StringBuilder output = new StringBuilder();
        int a = 0;

        if (!weapon.isUnusual()) {
            output.append("Weapon has no unusual properties\n");
        }
        else {
            output.append("Intelligence: ");
            output.append(weapon.getIntelligenceScore());
            output.append("\n");
            output.append("Communication: ");
            output.append(weapon.getCommunication());
            output.append("\n");
            output.append("Alignment: ");
            output.append(weapon.getAlignment());
            output.append("\n");
            output.append("Languages: ");
            output.append(weapon.getLanguages());
            output.append(" + alignment");
            output.append("\n");

            Set<PrimaryAbility> primaryAbilities = weapon.getPrimaryAbilities();
            if (!primaryAbilities.isEmpty()) {
                output.append("Primary Abilities: ");
                for (PrimaryAbility ability : primaryAbilities) {
                    output.append(ability.getText());
                    output.append(" ");
                    output.append(ability.getRange());
                    output.append("' r");

                    if (a < primaryAbilities.size() - 1) {
                        output.append("; ");
                    }

                    a++;
                }
                output.append("\n");
            }

            Set<ExtraordinaryPower> extraordinaryPowers = weapon.getExtraordinaryPowers();
            a = 0;
            if (!extraordinaryPowers.isEmpty()) {
                output.append("Extraordinary Powers: ");
                for (ExtraordinaryPower power : extraordinaryPowers) {
                    output.append(power.getText());
                    output.append(" - ");
                    output.append(power.getUses());
                    output.append(power.getFrequency());

                    if (!power.getDuration().isBlank()) {
                        output.append(", ");
                        output.append(power.getDuration());
                    }

                    if (a < extraordinaryPowers.size() - 1) {
                        output.append("; ");
                    }

                    a++;
                }
                output.append("\n");
            }

            if (weapon.isSpecialPurpose()) {
                output.append("Special Purpose: ");
                output.append(weapon.getSpecialPurpose());
                output.append(" (");
                output.append(weapon.getSpecialPurposePower());
                output.append(")");
                output.append("\n");
            }
        }

        output.append("\n");

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), output.toString(), null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private void clearDisplay() {
        this.display.setText("");
    }
}
