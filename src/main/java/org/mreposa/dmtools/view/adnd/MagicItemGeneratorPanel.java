package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.MagicItemGenerator;
import org.mreposa.dmtools.model.adnd.magic.MagicItem;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;
import java.util.List;

public class MagicItemGeneratorPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final MagicItemGenerator magicItemGenerator;
    private final JTextField itemCount;
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

        JButton generateButton = new JButton("Generate");
        Dimension bd = new Dimension(90, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> displayRoll());
        selectionPanel.add(generateButton);

        JButton clearButton = new JButton("Clear");
        Dimension bd2 = new Dimension(90, 20);
        clearButton.setSize(bd2);
        clearButton.setPreferredSize(bd2);
        clearButton.setMaximumSize(bd2);
        clearButton.addActionListener(_ -> clearDisplay());
        selectionPanel.add(clearButton);

        this.display = new JEditorPane();
        this.display.setEditable(false);

        add(selectionPanel, BorderLayout.NORTH);
        add(this.display, BorderLayout.CENTER);
    }

    private void displayRoll() {
        int itemCount = Integer.parseInt(this.itemCount.getText());

        List<MagicItem> magicItems = this.magicItemGenerator.generate(itemCount);

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

    private void clearDisplay() {
        this.display.setText("");
    }
}
