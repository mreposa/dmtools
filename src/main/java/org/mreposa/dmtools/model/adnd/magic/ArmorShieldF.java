package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class ArmorShieldF extends MagicItemTable {
    public ArmorShieldF(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";

        if (roll < 6) {
            itemName = "chain mail +1";
        }
        else if (roll < 10) {
            itemName = "chain mail +2";
        }
        else if (roll < 12) {
            itemName = "chain mail +3";
        }
        else if (roll == 20) {
            itemName = "leather armor +1";
        }
        else if (roll < 27) {
            itemName = "plate mail +1";
        }
        else if (roll < 33) {
            itemName = "plate mail +2";
        }
        else if (roll < 36) {
            itemName = "plate mail +3";
        }
        else if (roll < 38) {
            itemName = "plate mail +4";
        }
        else if (roll == 38) {
            itemName = "plate mail +5";
        }
        else if (roll == 39) {
            itemName = "plate mail of etherealness";
        }
        else if (roll < 45) {
            itemName = "plate mail of vulnerability";
        }
        else if (roll < 51) {
            itemName = "ring mail +1";
        }
        else if (roll < 56) {
            itemName = "scale mail +1";
        }
        else if (roll == 60) {
            itemName = "scale mail +2";
        }
        else if (roll == 64) {
            itemName = "splint mail +1";
        }
        else if (roll < 67) {
            itemName = "splint mail +2";
        }
        else if (roll < 69) {
            itemName = "splint mail +3";
        }
        else if (roll == 69) {
            itemName = "splint mail +4";
        }
        else if (roll < 76) {
            itemName = "studded leather +1";
        }
        else if (roll < 85) {
            itemName = "shield +1";
        }
        else if (roll < 90) {
            itemName = "shield +2";
        }
        else if (roll == 94) {
            itemName = "shield +3";
        }
        else if (roll < 96) {
            itemName = "shield +4";
        }
        else if (roll == 96) {
            itemName = "shield +5";
        }
        else if (roll == 97) {
            itemName = "shield, large +1 (+4 vs. missiles)";
        }
        else {
            itemName = itemName + "shield -1 (missile attractor)";
        }

        return itemName;
    }
}
