package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.PouchGenerator;
import org.mreposa.dmtools.model.adnd.treasure.GeneratedTreasure;
import org.mreposa.dmtools.model.adnd.treasure.PouchContents;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;
import java.util.List;

public class PouchGeneratorPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private final PouchGenerator pouchGenerator;
    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private JCheckBox includeOddsAndEnds;
    private final JEditorPane display;

    public PouchGeneratorPanel(DiceRollGenerator rollGenerator) {
        super();

        this.pouchGenerator = new PouchGenerator(rollGenerator);

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        Dimension bd;

        JButton generateLargePouchButton = new JButton("Large Pouch");
        bd = new Dimension(120, 20);
        generateLargePouchButton.setSize(bd);
        generateLargePouchButton.setPreferredSize(bd);
        generateLargePouchButton.setMaximumSize(bd);
        generateLargePouchButton.addActionListener(_ -> getPouch(PouchGenerator.LG_POUCH_CAP));
        selectionPanel.add(generateLargePouchButton);

        JButton generateSmallPouchButton = new JButton("Small Pouch");
        bd = new Dimension(120, 20);
        generateSmallPouchButton.setSize(bd);
        generateSmallPouchButton.setPreferredSize(bd);
        generateSmallPouchButton.setMaximumSize(bd);
        generateSmallPouchButton.addActionListener(_ -> getPouch(PouchGenerator.SM_POUCH_CAP));
        selectionPanel.add(generateSmallPouchButton);

        this.includeOddsAndEnds = new JCheckBox("Include Odds and Ends", true);
        selectionPanel.add(includeOddsAndEnds);

        JButton clearButton = new JButton("Clear");
        bd = new Dimension(90, 20);
        clearButton.setSize(bd);
        clearButton.setPreferredSize(bd);
        clearButton.setMaximumSize(bd);
        clearButton.addActionListener(_ -> clearDisplay());
        selectionPanel.add(clearButton);

        this.display = new JEditorPane();
        this.display.setEditable(false);

        add(selectionPanel, BorderLayout.NORTH);
        add(this.display, BorderLayout.CENTER);
    }

    private void getPouch(int maxCoins) {
        PouchContents pouch = this.pouchGenerator.generate(maxCoins, this.includeOddsAndEnds.isSelected());

        String pouchContents = displayPouch(pouch);

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), pouchContents, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private String displayPouch(PouchContents pouch) {
        StringBuilder output = new StringBuilder();

        List<GeneratedTreasure> coinList = pouch.getCoins();
        List<String> oddsAndEnds = pouch.getOddsAndEnds();

        if (coinList != null) {
            if (coinList.isEmpty()) {
                output.append("No treasure!");
            }
            else {
                int count = 0;
                for (GeneratedTreasure treasure : coinList) {
                    if (treasure.getAmount() > 0) {
                        output.append(treasure.getAmount());
                        output.append(" ");
                    }

                    output.append(treasure.getType());

                    if (count < coinList.size() - 1) {
                        output.append(", ");
                    }

                    count++;
                }

                if (!oddsAndEnds.isEmpty()) {
                    count = 0;

                    output.append(", ");
                    for (String item : oddsAndEnds) {
                        output.append(item);

                        if (count < oddsAndEnds.size() - 1) {
                            output.append(", ");
                        }

                        count++;
                    }
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
