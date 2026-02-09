package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscMagicE4 extends MagicItemTable {
    public MiscMagicE4(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;

        if (roll == 1) {
            itemName = "libram of gainful conjuration";
        }
        else if (roll == 2) {
            itemName = "libram of ineffable damnation";
        }
        else if (roll == 3) {
            itemName = "libram of silver magic";
        }
        else if (roll == 4) {
            itemName = "lyre of building";
        }
        else if (roll == 5) {
            itemName = "manual of bodily health";
        }
        else if (roll == 6) {
            itemName = "manual of gainful exercise";
        }
        else if (roll == 7) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "clay";
            }
            else if (typeRoll < 18) {
                type = "flesh";
            }
            else if (typeRoll == 18) {
                type = "iron";
            }
            else {
                type = "stone";
            }

            itemName = "manual of golems (" + type + ")";
        }
        else if (roll == 8) {
            itemName = "manual of puissant skill at arms";
        }
        else if (roll == 9) {
            itemName = "manual of quickness of action";
        }
        else if (roll == 10) {
            itemName = "manual of stealthy pilfering";
        }
        else if (roll == 11) {
            itemName = "mattock of the titans";
        }
        else if (roll == 12) {
            itemName = "maul of the titans";
        }
        else if (roll < 16) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 16) {
                type = "30' range";
            }
            else if (typeRoll < 19) {
                type = "30' range with empathy";
            }
            else if (typeRoll == 19) {
                type = "60' range";
            }
            else {
                type = "90' range";
            }

            itemName = "medallion of ESP (" + type + ")";
        }
        else if (roll < 18) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 16) {
                type = "30' range";
            }
            else if (typeRoll < 19) {
                type = "30' range with empathy";
            }
            else if (typeRoll == 19) {
                type = "60' range";
            }
            else {
                type = "90' range";
            }

            itemName = "medallion of thought projection (" + type + ")";
        }
        else if (roll == 18) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            int spaces = dieRoll.getTotal() + 12;

            itemName = "mirror of life trapping (" + spaces + " spaces)";
        }
        else if (roll == 19) {
            itemName = "mirror of mental prowess";
        }
        else if (roll == 20) {
            itemName = "mirror of opposition";
        }
        else if (roll < 24) {
            itemName = "necklace of adaptation";
        }
        else if (roll < 28) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 5) {
                type = "type I";
            }
            else if (typeRoll < 9) {
                type = "type II";
            }
            else if (typeRoll < 13) {
                type = "type III";
            }
            else if (typeRoll < 17) {
                type = "type IV";
            }
            else if (typeRoll < 19) {
                type = "type V";
            }
            else if (typeRoll == 19) {
                type = "type VI";
            }
            else {
                type = "type VII";
            }

            itemName = "necklace of missiles (" + type + ")";
        }
        else if (roll < 34) {
            itemName = "necklace of prayer beads";
        }
        else if (roll < 36) {
            itemName = "necklace of strangulation";
        }
        else if (roll < 39) {
            itemName = "net of entrapment";
        }
        else if (roll < 43) {
            itemName = "net of snaring";
        }
        else if (roll < 45) {
            itemName = "Nolzur's marvelous pigments";
        }
        else if (roll < 47) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 26) {
                type = "one 1st";
            }
            else if (typeRoll < 46) {
                type = "one 2nd";
            }
            else if (typeRoll < 61) {
                type = "one 3rd";
            }
            else if (typeRoll < 76) {
                type = "one 4th";
            }
            else if (typeRoll < 85) {
                type = "one 5th";
            }
            else if (typeRoll < 93) {
                type = "one 6th";
            }
            else if (typeRoll < 97) {
                type = "one 7th";
            }
            else if (typeRoll < 99) {
                type = "one 8th";
            }
            else if (typeRoll == 99) {
                type = "one 9th";
            }
            else {
                dieRoll = this.diceRollGenerator.roll(1, 6);
                int levelRoll = dieRoll.getTotal();
                String level = "";

                if  (levelRoll == 1) {
                    level = "1st";
                }
                else if  (levelRoll == 2) {
                    level = "2nd";
                }
                else if  (levelRoll == 3) {
                    level = "3rd";
                }
                else if  (levelRoll == 4) {
                    level = "4th";
                }
                else if  (levelRoll == 5) {
                    level = "5th";
                }
                else {
                    level = "6th";
                }

                type = "two " + level;
            }

            itemName = "pearl of power (" + type + ")";
        }
        else if (roll < 49) {
            itemName = "pearl of wisdom";
        }
        else if (roll < 51) {
            itemName = "periapt of foul rotting";
        }
        else if (roll == 54) {
            itemName = "periapt of health";
        }
        else if (roll < 61) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 9) {
                type = "+1";
            }
            else if (typeRoll < 15) {
                type = "+2";
            }
            else if (typeRoll < 19) {
                type = "+3";
            }
            else {
                type = "+4";
            }

            itemName = "periapt of proof against poison " + type;
        }
        else if (roll < 65) {
            itemName = "periapt of wound closure";
        }
        else if (roll < 71) {
            itemName = "phylactery of faithfulness";
        }
        else if (roll < 75) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll == 1) {
                type = " (cursed)";
            }
            else {
                type = "";
            }

            itemName = "phylactery of long years" + type;
        }
        else if (roll < 77) {
            itemName = "phylactery of monstrous attention";
        }
        else if (roll < 85) {
            itemName = "pipes of the sewers";
        }
        else if (roll == 85) {
            itemName = "portable hole";
        }
        else {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 5) {
                type = "anchor";
            }
            else if (typeRoll < 8) {
                type = "bird";
            }
            else if (typeRoll < 11) {
                type = "fan";
            }
            else if (typeRoll < 14) {
                type = "swan boat";
            }
            else if (typeRoll < 19) {
                type = "tree";
            }
            else {
                type = "whip";
            }

            itemName = "Quaal's feather token (" + type + ")";
        }

        return itemName;
    }
}
