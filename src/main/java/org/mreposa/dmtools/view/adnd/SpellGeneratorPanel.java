package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.SpellGenerator;
import org.mreposa.dmtools.model.adnd.spells.SpellTable;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.util.Set;

public class SpellGeneratorPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final SpellGenerator spellGenerator;
    private final JComboBox<String> spellCount;
    private final JComboBox<String> casterClass;
    private final JComboBox<String> spellLevel;
    private final JEditorPane display;

    public SpellGeneratorPanel(DiceRollGenerator rollGenerator) {
        super();

        this.spellGenerator = new SpellGenerator(rollGenerator);

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        String labelText = "Number:";
        JLabel label1 = new JLabel(labelText);
        selectionPanel.add(label1);

        this.spellCount = new JComboBox<>(SpellTable.SPELL_COUNT);
        this.spellCount.setSelectedIndex(0);
        selectionPanel.add(this.spellCount);

        JLabel label2 = new JLabel("Class:");
        selectionPanel.add(label2);

        this.casterClass = new JComboBox<>(SpellTable.SPELL_CLASSES);
        this.casterClass.setSelectedIndex(0);
        selectionPanel.add(this.casterClass);

        JLabel label3 = new JLabel("Level:");
        selectionPanel.add(label3);

        this.spellLevel = new JComboBox<>(SpellTable.SPELL_LEVELS);
        this.spellLevel.setSelectedIndex(0);
        selectionPanel.add(this.spellLevel);

        JButton generateButton = new JButton("Generate");
        Dimension bd = new Dimension(90, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> displaySpells());
        selectionPanel.add(generateButton);

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

    private void displaySpells() {
        int count = this.spellCount.getSelectedIndex() + 1;
        int level = this.spellLevel.getSelectedIndex() + 1;
        String casterClass = SpellTable.SPELL_CLASSES[this.casterClass.getSelectedIndex()];

        if (!casterClass.equals(SpellTable.SPELL_CLASSES[0])) {
            if (level > 7) {
                level = 7;
            }
        }

        java.util.Set<String> spells = this.spellGenerator.generate(count, level, casterClass);

        String output = getOutput(level, spells);

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), output, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private String getOutput(int level, Set<String> spells) {
        if  (spells == null || spells.isEmpty()) {
            throw new IllegalArgumentException("Invalid spell list");
        }

        StringBuilder output = new StringBuilder();

        output.append("Level ");
        output.append(level);
        output.append(": ");

        int a = 0;
        for (String spell : spells) {
            output.append(spell);

            if (a < spells.size() - 1) {
                output.append(", ");
            }

            a++;
        }
        output.append("\n\n");

        return output.toString();
    }

    private void clearDisplay() {
        this.display.setText("");
    }
}
