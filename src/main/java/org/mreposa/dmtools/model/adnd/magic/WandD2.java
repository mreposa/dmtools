package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class WandD2 extends MagicItemTable {
    public WandD2(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "wand of ";
        String type = "";
        int typeRoll = 0;

        Roll chargeRoll = this.diceRollGenerator.roll(1, 20);
        int charges = 100 - (chargeRoll.getTotal() - 1);

        if (roll == 1) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "anything wand (" + charges + " charges)";
        }
        else if (roll < 6) {
            itemName = "buckler wand";
        }
        else if (roll == 8) {
            itemName = itemName + "conjuration (" + charges + " charges)";
        }
        else if (roll < 11) {
            itemName = itemName + "defoliation (" + charges + " charges)";
        }
        else if (roll < 13) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 51) {
                type = "";
            }
            else {
                type = "high value ";
            }

            itemName = itemName + "earth and stone (" + type + + charges + " charges)";
        }
        else if (roll == 17) {
            itemName = itemName + "enemy detection (" + charges + " charges)";
        }
        else if (roll < 21) {
            itemName = itemName + "fear (" + charges + " charges)";
        }
        else if (roll == 23) {
            itemName = itemName + "fire (" + charges + " charges)";
        }
        else if (roll == 27) {
            itemName = itemName + "fireballs (" + charges + " charges)";
        }
        else if (roll < 31) {
            itemName = itemName + "flame extinguishing (" + charges + " charges)";
        }
        else if (roll == 31) {
            itemName = itemName + "force (" + charges + " charges)";
        }
        else if (roll == 32) {
            itemName = itemName + "frost (" + charges + " charges)";
        }
        else if (roll < 36) {
            itemName = itemName + "ice storms (" + charges + " charges)";
        }
        else if (roll < 40) {
            itemName = itemName + "illumination (" + charges + " charges)";
        }
        else if (roll < 44) {
            itemName = itemName + "illusion (" + charges + " charges)";
        }
        else if (roll == 46) {
            itemName = itemName + "lightning (" + charges + " charges)";
        }
        else if (roll == 50) {
            itemName = itemName + "lightning bolts (" + charges + " charges)";
        }
        else if (roll < 54) {
            itemName = itemName + "magic detection (" + charges + " charges)";
        }
        else if (roll < 62) {
            itemName = itemName + "magic missiles (" + charges + " charges)";
        }
        else if (roll < 67) {
            itemName = itemName + "metal and mineral detection (" + charges + " charges)";
        }
        else if (roll < 69) {
            itemName = itemName + "metal command (" + charges + " charges)";
        }
        else if (roll < 75) {
            itemName = itemName + "negation (" + charges + " charges)";
        }
        else if (roll == 79) {
            itemName = itemName + "paralyzation (" + charges + " charges)";
        }
        else if (roll < 83) {
            itemName = itemName + "polymorphing (" + charges + " charges)";
        }
        else if (roll < 87) {
            itemName = itemName + "secret door and trap location (" + charges + " charges)";
        }
        else if (roll < 91) {
            itemName = itemName + "size alteration (" + charges + " charges)";
        }
        else if (roll < 93) {
            itemName = itemName + "steam and vapor (" + charges + " charges)";
        }
        else {
            itemName = itemName + "wonder (" + charges + " charges)";
        }

        return itemName;
    }
}
