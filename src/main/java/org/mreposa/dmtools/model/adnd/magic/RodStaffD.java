package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class RodStaffD extends MagicItemTable {
    public RodStaffD(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;
        int charges = 0;

        if (roll < 7) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of absorption (" + charges + " charges)";
        }
        else if (roll < 11) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of alertness (" + charges + " charges)";
        }
        else if (roll == 11) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of beguiling (" + charges + " charges)";
        }
        else if (roll < 22) {
            itemName = "rod of cancellation";
        }
        else if (roll < 27) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of flailing (" + charges + " charges)";
        }
        else if (roll == 27) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of lordly might (" + charges + " charges)";
        }
        else if (roll < 31) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of passage (" + charges + " charges)";
        }
        else if (roll == 31) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of resurrection (" + charges + " charges)";
        }
        else if (roll == 32) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of rulership (" + charges + " charges)";
        }
        else if (roll < 37) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of security (" + charges + " charges)";
        }
        else if (roll == 37) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of smiting (" + charges + " charges)";
        }
        else if (roll < 41) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            charges = 50 - (dieRoll.getTotal() - 1);

            itemName = "rod of splendor (" + charges + " charges)";
        }
        else if (roll == 41) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of command (" + charges + " charges)";
        }
        else if (roll < 49) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of curing (" + charges + " charges)";
        }
        else if (roll < 56) {
            itemName = "staff-mace";
        }
        else if (roll == 56) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of the magi (" + charges + " charges)";
        }
        else if (roll == 57) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of power (" + charges + " charges)";
        }
        else if (roll < 64) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 61) {
                type = "python";
            }
            else {
                type = "adder";
            }

            itemName = "staff of the serpent (" + type + ")";
        }
        else if (roll < 71) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of slinging (" + charges + " charges)";
        }
        else if (roll < 77) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 7) {
                type = "+1";
            }
            else if (typeRoll < 11) {
                type = "+2";
            }
            else if (typeRoll < 14) {
                type = "+3";
            }
            else if (typeRoll < 17) {
                type = "+4";
            }
            else if (typeRoll < 20) {
                type = "+5";
            }
            else {
                type = "+3 and 2 - 8 damage";
            }

            itemName = "staff-spear " + type;
        }
        else if (roll < 83) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of striking (" + charges + " charges)";
        }
        else if (roll < 86) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of swarming insects (" + charges + " charges)";
        }
        else if (roll == 86) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of hunder and lightning (" + charges + " charges)";
        }
        else if (roll < 91) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of withering (" + charges + " charges)";
        }
        else {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            charges = 25 - (dieRoll.getTotal() - 1);

            itemName = "staff of the woodlands (" + charges + " charges)";
        }

        return itemName;
    }
}
