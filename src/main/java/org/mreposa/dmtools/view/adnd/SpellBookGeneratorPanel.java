package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.SpellBookGenerator;
import org.mreposa.dmtools.model.adnd.spells.SpellBook;
import org.mreposa.dmtools.model.adnd.spells.SpellTable;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;

public class SpellBookGeneratorPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final SpellBookGenerator spellBookGenerator;
    private final JComboBox<String> casterLevel;
    private final JComboBox<String> casterClass;
    private final JComboBox<String> intelligenceScore;
    private final JEditorPane display;

    public SpellBookGeneratorPanel(DiceRollGenerator rollGenerator) {
        super();

        this.spellBookGenerator = new SpellBookGenerator(rollGenerator);

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        String labelText = "Level:";
        JLabel label1 = new JLabel(labelText);
        selectionPanel.add(label1);

        this.casterLevel = new JComboBox<>(SpellTable.CASTER_LEVEL);
        this.casterLevel.setSelectedIndex(0);
        selectionPanel.add(this.casterLevel);

        JLabel label2 = new JLabel("Class:");
        selectionPanel.add(label2);

        this.casterClass = new JComboBox<>(SpellTable.SPELL_BOOK_CLASSES);
        this.casterClass.setSelectedIndex(0);
        selectionPanel.add(this.casterClass);

        JLabel label3 = new JLabel("Intelligence:");
        selectionPanel.add(label3);

        this.intelligenceScore = new JComboBox<>(SpellTable.INTELLIGENCE_SCORE);
        this.intelligenceScore.setSelectedIndex(0);
        selectionPanel.add(this.intelligenceScore);

        JButton generateButton = new JButton("Generate");
        Dimension bd = new Dimension(90, 20);
        generateButton.setSize(bd);
        generateButton.setPreferredSize(bd);
        generateButton.setMaximumSize(bd);
        generateButton.addActionListener(_ -> displaySpellBook());
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

    private void displaySpellBook() {
        int casterLevel = this.casterLevel.getSelectedIndex() + 1;
        String casterClass = SpellTable.SPELL_BOOK_CLASSES[this.casterClass.getSelectedIndex()];
        int intelligenceScorePosition = this.intelligenceScore.getSelectedIndex();

        SpellBook spellBook = this.spellBookGenerator.generate(casterLevel, casterClass, intelligenceScorePosition);
        String output = spellBook.toString() + "\n";

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), output, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private void clearDisplay() {
        this.display.setText("");
    }
}
