package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class ArmorShieldF2 extends MagicItemTable {
    public ArmorShieldF2(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";

        if (roll == 1) {
            itemName = "anything armor";
        }
        else if (roll < 8) {
            itemName = "bronze plate mail +1";
        }
        else if (roll < 12) {
            itemName = "bronze plate mail +2";
        }
        else if (roll == 18) {
            itemName = "buckler +1";
        }
        else if (roll < 22) {
            itemName = "buckler +2";
        }
        else if (roll < 24) {
            itemName = "buckler +3";
        }
        else if (roll < 26) {
            itemName = "chain mail +4";
        }
        else if (roll < 32) {
            itemName = "elfin chain mail +1";
        }
        else if (roll < 36) {
            itemName = "elfin chain mail +2";
        }
        else if (roll < 39) {
            itemName = "elfin chain mail +3";
        }
        else if (roll < 41) {
            itemName = "elfin chain mail +4";
        }
        else if (roll == 41) {
            itemName = "elfin chain mail +5";
        }
        else if (roll < 51) {
            itemName = "leather armor +2";
        }
        else if (roll < 56) {
            itemName = "leather armor +3";
        }
        else if (roll < 63) {
            itemName = "field plate armor +1";
        }
        else if (roll < 69) {
            itemName = "field plate armor +2";
        }
        else if (roll < 73) {
            itemName = "field plate armor +3";
        }
        else if (roll < 74) {
            itemName = "field plate armor +4";
        }
        else if (roll == 74) {
            itemName = "field plate armor +5";
        }
        else if (roll < 81) {
            itemName = "full plate armor +1";
        }
        else if (roll < 85) {
            itemName = "full plate armor +2";
        }
        else if (roll < 88) {
            itemName = "full plate armor +3";
        }
        else if (roll == 90) {
            itemName = "full plate armor +4";
        }
        else if (roll < 94) {
            itemName = "ring mail +2";
        }
        else if (roll == 96) {
            itemName = "scale mail +3";
        }
        else {
            itemName = itemName + "studded leather +2";
        }

        if (itemName.startsWith("elfin chain mail")) {
            itemName = itemName + " " + getElfinChainSize();
        }
        else if (!itemName.startsWith("buckler")) {
            itemName = itemName + " " + getArmorSize();
        }

        return itemName;
    }
}
