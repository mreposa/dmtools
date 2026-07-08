package org.mreposa.dmtools.view.adnd;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.adnd.playerclass.PlayerCharacterClass;
import org.mreposa.dmtools.generator.adnd.StatGenerator;
import org.mreposa.dmtools.model.adnd.rollmethod.StatMethod;

import javax.swing.*;

public class StatFrame extends org.mreposa.dmtools.view.StatFrame {
    private static final String APP_VERSION = "1.0.0";
    private static final String APP_TITLE = "AD&D DM Tools";
    private static final String ABOUT_MESSAGE = APP_TITLE + "\nVersion " + APP_VERSION + "\n" + "Michael Reposa\n" + "27-AUG-2025";

    public StatFrame() {
        super(new StatGenerator(), new DiceRollGenerator());

        this.setTitle(APP_TITLE);

        for (int a = 0; a < StatMethod.AVAILABLE_METHODS.length; a++) {
            JRadioButton btn = new JRadioButton();
            btn.setText(StatMethod.AVAILABLE_METHODS[a]);
            btn.setActionCommand(StatMethod.AVAILABLE_METHODS[a]);
            this.methodButtonGroup.add(btn);
            this.methodPanel.add(btn);
            if (a == 0) {
                this.methodButtonGroup.setSelected(btn.getModel(), true);
                this.selectedMethod = StatMethod.AVAILABLE_METHODS[0];
            }
        }

        this.tabs.add("Character Facts and Traits", new CharacterDetailsGeneratorPanel((org.mreposa.dmtools.generator.adnd.DiceRollGenerator)this.rollGenerator));
        this.tabs.add("Thief Functions", new ThiefFunctionPanel());
        this.tabs.add("Treasure Generator", new TreasureGeneratorPanel((org.mreposa.dmtools.generator.adnd.DiceRollGenerator)this.rollGenerator));
        this.tabs.add("Gem Generator", new GemGeneratorPanel((org.mreposa.dmtools.generator.adnd.DiceRollGenerator)this.rollGenerator));
        this.tabs.add("Jewelry Generator", new JewelryGeneratorPanel((org.mreposa.dmtools.generator.adnd.DiceRollGenerator)this.rollGenerator));
        this.tabs.add("Magic Item Generator", new MagicItemGeneratorPanel((org.mreposa.dmtools.generator.adnd.DiceRollGenerator)this.rollGenerator));
    }

    @Override
    public String formatStats(int[] stats) {
        StringBuilder output = new StringBuilder();

        if (stats != null) {
            output.append(this.selectedRace);
            output.append("\n");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_STR]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_STR]);

            // Display Exceptional ST value
            if (stats[PlayerCharacterClass.STAT_STR] == PlayerCharacterClass.MAX_STAT_VALUE &&
                    (this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_FIGHTER]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_RANGER]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_PALADIN]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_CAVALIER]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_CAVALIER_PALADIN]) ||
                            this.selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_BARBARIAN]))) {
                output.append("/");
                output.append(stats[PlayerCharacterClass.STAT_EX_STR]);
            }

            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_INT]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_INT]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_WIS]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_WIS]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_DEX]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_DEX]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_CON]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_CON]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_CHA]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_CHA]);
            output.append(", ");
            output.append(PlayerCharacterClass.AVAILABLE_STATS[PlayerCharacterClass.STAT_COM]);
            output.append(" ");
            output.append(stats[PlayerCharacterClass.STAT_COM]);
            output.append("\n\n");
        }
        else {
            output.append("Missing stats\n\n");
        }

        return output.toString();
    }

    @Override
    public String getAbout() {
        return ABOUT_MESSAGE;
    }
}
