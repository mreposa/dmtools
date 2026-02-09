package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class RingC extends MagicItemTable {
    public RingC(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "ring of ";
        String type = "";
        int typeRoll = 0;

        if (roll < 7) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 21) {
                type = "flying";
            }
            else if (typeRoll < 41) {
                type = "invisibility";
            }
            else if (typeRoll < 61) {
                type = "levitation";
            }
            else if (typeRoll < 71) {
                type = "shocking grasp once/round";
            }
            else if (typeRoll < 81) {
                type = "spell turning";
            }
            else {
                type = "strength 18/00";
            }

            itemName = itemName + "contrariness (" + type + ")";
        }
        else if (roll < 13) {
            itemName = itemName + "delusion";
        }
        else if (roll < 15) {
            itemName = itemName + "djinni summoning";
        }
        else if (roll == 15) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 26) {
                type = "air";
            }
            else if (typeRoll < 51) {
                type = "earth";
            }
            else if (typeRoll < 76) {
                type = "fire";
            }
            else {
                type = "water";
            }

            itemName = itemName + "elemental command (" + type + ")";
        }
        else if (roll < 22) {
            itemName = itemName + "feather falling";
        }
        else if (roll < 28) {
            itemName = itemName + "fire resistance";
        }
        else if (roll < 31) {
            itemName = itemName + "free action";
        }
        else if (roll < 34) {
            itemName = itemName + "human influence";
        }
        else if (roll < 41) {
            itemName = itemName + "invisibility";
        }
        else if (roll < 44) {
            itemName = itemName + "mammal control";
        }
        else if (roll == 44) {
            itemName = itemName + "multiple wishes";
        }
        else if (roll < 61) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 71) {
                type = "+1";
            }
            else if (typeRoll < 83) {
                type = "+2";
            }
            else if (typeRoll == 83) {
                type = "+2 5' radius";
            }
            else if (typeRoll < 91) {
                type = "+3";
            }
            else if (typeRoll == 91) {
                type = "+3 5' radius";
            }
            else if (typeRoll < 98) {
                type = "+4 AC and +2 on saving throws";
            }
            else {
                type = "+6 AC and +1 on saving throws";
            }

            itemName = itemName + "protection " + type;
        }
        else if (roll == 61) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 91) {
                type = "regeneration";
            }
            else {
                type = "vampiric regeneration";
            }

            itemName = itemName + type;
        }
        else if (roll < 64) {
            itemName = itemName + "shooting stars";
        }
        else if (roll < 66) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int spellCount = dieRoll.getTotal() + 1;

            dieRoll = this.diceRollGenerator.roll(1, 100);
            int classRoll = dieRoll.getTotal();

            int subClassRoll = 0;
            String casterClass = "";

            if (classRoll < 71) {
                casterClass = "magic-user";

                dieRoll = this.diceRollGenerator.roll(1, 100);
                subClassRoll = dieRoll.getTotal();

                if  (subClassRoll < 11) {
                    casterClass = "illusionist";
                }
            }
            else {
                casterClass = "cleric";

                dieRoll = this.diceRollGenerator.roll(1, 100);
                subClassRoll = dieRoll.getTotal();

                if  (subClassRoll < 26) {
                    casterClass = "druid";
                }
            }

            itemName = itemName + "spell storing (" + spellCount + " " + casterClass + " spells)";
        }
        else if (roll < 70) {
            itemName = itemName + "spell turning";
        }
        else if (roll < 76) {
            itemName = itemName + "swimming";
        }
        else if (roll < 78) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 26) {
                type = "250 gp max";
            }
            else if (typeRoll < 51) {
                type = "500 gp max";
            }
            else if (typeRoll < 90) {
                type = "1000 gp max";
            }
            else if (typeRoll < 100) {
                type = "2000 gp max";
            }
            else {
                type = "4000 gp max";
            }

            itemName = itemName + "telekinesis (" + type + ")";
        }
        else if (roll < 80) {
            itemName = itemName + "three wishes";
        }
        else if (roll < 86) {
            itemName = itemName + "warmth";
        }
        else if (roll < 91) {
            itemName = itemName + "water walking";
        }
        else if (roll < 99) {
            itemName = itemName + "weakness";
        }
        else if (roll == 99) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 51) {
                type = "1st";
            }
            else if (typeRoll < 76) {
                type = "2nd";
            }
            else if (typeRoll < 83) {
                type = "3rd";
            }
            else if (typeRoll < 89) {
                type = "1st and 2nd";
            }
            else if (typeRoll < 93) {
                type = "4th";
            }
            else if (typeRoll < 96) {
                type = "5th";
            }
            else if (typeRoll < 100) {
                type = "1st - 3rd";
            }
            else {
                type = "4th and 5th";
            }

            itemName = itemName + "wizardry (doubles " + type + " level spells)";
        }
        else {
            itemName = itemName + "x-ray vision";
        }

        return itemName;
    }
}
