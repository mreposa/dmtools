package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.TreasureGenerator;
import org.mreposa.dmtools.model.adnd.treasure.GeneratedTreasure;
import org.mreposa.dmtools.model.adnd.treasure.TreasureType;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;

public class TreasureGeneratorPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private final TreasureGenerator treasureGenerator;
    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final JComboBox<String> treasureType;
    private final JEditorPane display;

    public TreasureGeneratorPanel(DiceRollGenerator rollGenerator) {
        super();

        this.treasureGenerator = new TreasureGenerator(rollGenerator);

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel label1 = new JLabel("Treasure Type:");
        selectionPanel.add(label1);

        this.treasureType = new JComboBox<>(TreasureType.TREASURE_TYPES);
        this.treasureType.setSelectedIndex(0);
        selectionPanel.add(this.treasureType);

        JButton generateButton = new JButton("Generate");
        Dimension bd = new Dimension(90, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> getTreasure());
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

    private void getTreasure() {
        String selectedTreasureType = (String)this.treasureType.getSelectedItem();
        java.util.List<GeneratedTreasure> list = this.treasureGenerator.generate(selectedTreasureType);

        String displayTreasure = displayTreasure(list);

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), displayTreasure, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private String displayTreasure(java.util.List<GeneratedTreasure> treasureList) {
        StringBuilder output = new StringBuilder();

        if (treasureList != null) {
            if (treasureList.isEmpty()) {
                output.append("No treasure!");
            }
            else {
                int count = 0;
                for (GeneratedTreasure treasure : treasureList) {
                    if (treasure.getAmount() > 0) {
                        output.append(treasure.getAmount());
                        output.append(" ");
                    }

                    output.append(treasure.getType());

                    if (count < treasureList.size() - 1) {
                        output.append(", ");
                    }

                    count++;
                }
            }

            output.append("\n\n");
        }
        else {
            output.append("Missing treasure\n\n");
        }

        return output.toString();
    }

    private void clearDisplay() {
        this.display.setText("");
    }
}
