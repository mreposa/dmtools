package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscMagicE6 extends MagicItemTable {
    public MiscMagicE6(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;

        if (roll < 5) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 31) {
                type = "5th";
            }
            else if (typeRoll < 56) {
                type = "6th";
            }
            else if (typeRoll < 76) {
                type = "7th";
            }
            else if (typeRoll < 91) {
                type = "8th";
            }
            else  {
                type = "9th";
            }

            itemName = "amulet vs. undead (" + type + " level cleric)";
        }
        else if (roll == 5) {
            itemName = "anything item";
        }
        else if (roll < 8) {
            itemName = "beads of force";
        }
        else if (roll < 15) {
            itemName = "Boccob's blessed book";
        }
        else if (roll < 17) {
            itemName = "boots of the north";
        }
        else if (roll < 20) {
            itemName = "boots of varied tracks";
        }
        else if (roll == 20) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            typeRoll = dieRoll.getTotal();

            if (typeRoll == 1) {
                type = "150' MC A";
            }
            else if (typeRoll == 2) {
                type = "180' MC B";
            }
            else if (typeRoll == 3) {
                type = "210' MC C";
            }
            else  {
                type = "240' MC D";
            }

            itemName = "winged boots (" + type + ")";
        }
        else if (roll < 25) {
            itemName = "bracers of archery";
        }
        else if (roll < 27) {
            itemName = "bracers of brachiation";
        }
        else if (roll < 29) {
            itemName = "chime of interruption";
        }
        else if (roll < 31) {
            itemName = "cloak of arachnidia";
        }
        else if (roll < 35) {
            itemName = "cloak of the bat";
        }
        else if (roll < 37) {
            itemName = "cyclocone";
        }
        else if (roll < 41) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();
            int count = 0;

            if (typeRoll < 41) {
                type = "+1";

                dieRoll = this.diceRollGenerator.roll(5, 4);
                count = dieRoll.getTotal();
            }
            else if (typeRoll < 71) {
                type = "+2";

                dieRoll = this.diceRollGenerator.roll(4, 4);
                count = dieRoll.getTotal();
            }
            else if (typeRoll < 91) {
                type = "+3";

                dieRoll = this.diceRollGenerator.roll(3, 4);
                count = dieRoll.getTotal();
            }
            else  {
                type = "+4";

                dieRoll = this.diceRollGenerator.roll(2, 4);
                count = dieRoll.getTotal();
            }

            itemName = "dart of the hornet nest " + type + " ("  + count + ")";
        }
        else if (roll < 43) {
            itemName = "deck of illusions";
        }
        else if (roll < 45) {
            itemName = "dicerion of light and darkness";
        }
        else if (roll < 48) {
            itemName = "dust of dryness";
        }
        else if (roll < 51) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            int count = dieRoll.getTotal() + 10;

            itemName = "dust of illusion (" + count + " uses)";
        }
        else if (roll < 55) {
            dieRoll = this.diceRollGenerator.roll(1, 12);
            int count = dieRoll.getTotal() + 12;

            itemName = "dust of tracelessness (" + count + " uses)";
        }
        else if (roll < 57) {
            itemName = "egg of desire";
        }
        else if (roll < 61) {
            itemName = "egg of reason";
        }
        else if (roll < 63) {
            itemName = "egg of shattering";
        }
        else if (roll < 66) {
            itemName = "gem of insight";
        }
        else if (roll < 69) {
            itemName = "girdle of dwarvenkind";
        }
        else if (roll < 77) {
            itemName = "girdle of many pouches";
        }
        else if (roll < 80) {
            itemName = "gloves of missile snaring";
        }
        else if (roll < 84) {
            itemName = "gloves of thievery";
        }
        else if (roll < 89) {
            itemName = "hat of difference";
        }
        else if (roll < 96) {
            itemName = "hat of disguise";
        }
        else {
            itemName = "hat of stupidity";
        }

        return itemName;
    }
}
