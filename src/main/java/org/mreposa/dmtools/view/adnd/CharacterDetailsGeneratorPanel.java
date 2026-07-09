package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.CharacterDetailsGenerator;
import org.mreposa.dmtools.model.adnd.details.CharacterDetails;
import org.mreposa.dmtools.model.adnd.details.CharacterDetailsTable;

import java.util.List;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import java.awt.*;
import java.io.Serial;

public class CharacterDetailsGeneratorPanel extends JPanel {
    @Serial
    private static final long serialVersionUID = 1L;

    private static final int PANEL_WIDTH = 1600;
    private static final int PANEL_HEIGHT = 1000;

    private final CharacterDetailsGenerator characterDetailsGenerator;
    private final JComboBox<String> race;
    private final JComboBox<String> sex;
    private final JEditorPane display;

    public CharacterDetailsGeneratorPanel(DiceRollGenerator rollGenerator) {
        super();

        this.characterDetailsGenerator = new CharacterDetailsGenerator(rollGenerator);

        setLayout(new BorderLayout());
        Dimension d = new Dimension(PANEL_WIDTH, PANEL_HEIGHT);
        setPreferredSize(d);

        JPanel selectionPanel = new JPanel();
        selectionPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        String labelText = "Race:";
        JLabel label1 = new JLabel(labelText);
        selectionPanel.add(label1);

        this.race = new JComboBox<>(CharacterDetailsTable.RACE);
        this.race.setSelectedIndex(0);
        selectionPanel.add(this.race);

        labelText = "Sex:";
        JLabel label2 = new JLabel(labelText);
        selectionPanel.add(label2);

        this.sex = new JComboBox<>(CharacterDetailsTable.SEX);
        this.sex.setSelectedIndex(0);
        selectionPanel.add(this.sex);

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
        int selectedRace = this.race.getSelectedIndex();
        int selectedSex = this.sex.getSelectedIndex();

        CharacterDetails characterDetails = this.characterDetailsGenerator.generate(selectedRace, selectedSex);

        String output = getOutput(characterDetails);

        try {
            Document doc = this.display.getDocument();
            doc.insertString(doc.getLength(), output, null);
        } catch (BadLocationException ble) {
            this.display.setText("ERROR: " + ble.getMessage());
        }
    }

    private String getOutput(CharacterDetails characterDetails) {
        StringBuilder output = new StringBuilder();
        int a = 0;

        output.append("Height: ");
        output.append(characterDetails.getHeight());
        output.append("\"\n");

        output.append("Weight: ");
        output.append(characterDetails.getWeight());
        output.append(" lbs\n");

        output.append("Secondary Skill(s): ");
        List<String> skills = characterDetails.getSecondarySkills();
        for (String skill : skills) {
            output.append(skill);

            if (a < skills.size() - 1) {
                output.append(", ");
            }

            a++;
        }
        output.append("\n");

        output.append("Alignment: ");
        output.append(characterDetails.getAlignment());
        output.append("\n");

        output.append("Wealth: ");
        output.append(characterDetails.getWealth());
        output.append("\n");

        output.append("Apparent Age: ");
        output.append(characterDetails.getAge());
        output.append("\n");

        output.append("General Appearance: ");
        output.append(characterDetails.getAppearance());
        output.append("\n");

        output.append("Sanity: ");
        output.append(characterDetails.getSanity());
        output.append("\n");

        a = 0;
        String[] tendencies = characterDetails.getTendencies();
        output.append("General Tendencies: ");
        for (String tendency : tendencies) {
            output.append(tendency);

            if (a < tendencies.length - 1) {
                output.append(", ");
            }

            a++;
        }
        output.append("\n");

        output.append("Personality: ");
        output.append(characterDetails.getPersonality());
        output.append("\n");

        output.append("Disposition: ");
        output.append(characterDetails.getDisposition());
        output.append("\n");

        output.append("Intellect: ");
        output.append(characterDetails.getIntellect());
        output.append("\n");

        output.append("Nature: ");
        output.append(characterDetails.getNature());
        output.append("\n");

        output.append("Materialism: ");
        output.append(characterDetails.getMaterialism());
        output.append("\n");

        output.append("Honesty: ");
        output.append(characterDetails.getHonesty());
        output.append("\n");

        output.append("Bravery: ");
        output.append(characterDetails.getBravery());
        output.append("\n");

        output.append("Energy: ");
        output.append(characterDetails.getEnergy());
        output.append("\n");

        output.append("Thrift: ");
        output.append(characterDetails.getThrift());
        output.append("\n");

        output.append("Morals: ");
        output.append(characterDetails.getMorals());
        output.append("\n");

        output.append("Piety: ");
        output.append(characterDetails.getPiety());
        output.append("\n");

        output.append("Interests: ");
        output.append(characterDetails.getInterests());
        output.append("\n");

        output.append("\n");

        return output.toString();
    }

    private void clearDisplay() {
        this.display.setText("");
    }
}
