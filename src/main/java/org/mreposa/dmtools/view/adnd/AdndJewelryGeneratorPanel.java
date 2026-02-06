package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.JewelryGenerator;
import org.mreposa.dmtools.model.adnd.gem.Jewelry;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;
import java.util.List;

public class AdndJewelryGeneratorPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final JewelryGenerator jewelryGenerator;
    private final JTextField jewelryCount;
    private final JEditorPane display;

    public AdndJewelryGeneratorPanel(DiceRollGenerator rollGenerator) {
        super();

        this.jewelryGenerator = new JewelryGenerator(rollGenerator);

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        String labelText = "Number (" + DiceRollGenerator.MIN_DICE_COUNT + " - " + DiceRollGenerator.MAX_DICE_COUNT + "):";
        JLabel label1 = new JLabel(labelText);
        selectionPanel.add(label1);

        this.jewelryCount = new JTextField("1");
        this.jewelryCount.setColumns(3);
        selectionPanel.add(this.jewelryCount);

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
        int jewelryCount = Integer.parseInt(this.jewelryCount.getText());

        List<Jewelry> jewelryList = this.jewelryGenerator.generate(jewelryCount);

        String output = getOutput(jewelryList);

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), output, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private String getOutput(List<Jewelry> jewelryList) {
        StringBuilder output = new StringBuilder();
        int a = 0;
        for (Jewelry jewelry : jewelryList) {
            output.append(jewelry.getPiece());
            output.append(" (");
            output.append(jewelry.getMake());
            output.append(", ");
            output.append(jewelry.getBaseValue());
            output.append(" gp)");

            if (a < jewelryList.size() - 1) {
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
