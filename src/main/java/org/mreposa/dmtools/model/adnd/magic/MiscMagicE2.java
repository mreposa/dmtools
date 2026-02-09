package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscMagicE2 extends MagicItemTable {
    public MiscMagicE2(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;

        if (roll < 7) {
            itemName = "candle of invocation";
        }
        else if (roll < 9) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 21) {
                type = "1 person";
            }
            else if (typeRoll < 56) {
                type = "2 persons";
            }
            else if (typeRoll < 81) {
                type = "3 persons";
            }
            else {
                type = "4 persons";
            }

            itemName = "carpet of flying (" + type + ")";
        }
        else if (roll < 11) {
            itemName = "censer of controlling air elementals";
        }
        else if (roll == 11) {
            itemName = "censer of summoning hostile air elementals";
        }
        else if (roll < 14) {
            itemName = "chime of opening";
        }
        else if (roll == 14) {
            itemName = "chime of hunger";
        }
        else if (roll < 19) {
            itemName = "cloak of displacement";
        }
        else if (roll < 28) {
            itemName = "cloak of elvenkind";
        }
        else if (roll < 31) {
            itemName = "cloak of the manta ray";
        }
        else if (roll < 33) {
            itemName = "cloak of poisonousness";
        }
        else if (roll < 56) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 36) {
                type = "+1";
            }
            else if (typeRoll < 66) {
                type = "+2";
            }
            else if (typeRoll < 86) {
                type = "+3";
            }
            else if (typeRoll < 96) {
                type = "+4";
            }
            else {
                type = "+5";
            }

            itemName = "cloak of protection " + type;
        }
        else if (roll < 61) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 21) {
                itemName = "crystal ball";
            }
            else if (typeRoll < 56) {
                itemName = "crystal ball with clairaudience";
            }
            else if (typeRoll < 81) {
                itemName = "crystal ball with ESP";
            }
            else {
                itemName = "crystal ball with telepathy";
            }
        }
        else if (roll == 61) {
            itemName = "crystal hypnosis ball";
        }
        else if (roll < 64) {
            itemName = "cube of force";
        }
        else if (roll < 66) {
            itemName = "cube of frost resistance";
        }
        else if (roll < 68) {
            itemName = "cubic gate";
        }
        else if (roll < 70) {
            itemName = "Daern's instant fortress";
        }
        else if (roll < 73) {
            itemName = "decanter of endless water";
        }
        else if (roll < 77) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 76) {
                type = "13 plaques";
            }
            else {
                type = "22 plaques";
            }

            itemName = "deck of many things (" + type + ")";
        }
        else if (roll == 77) {
            itemName = "drums of deafening";
        }
        else if (roll < 80) {
            itemName = "drums of panic";
        }
        else if (roll < 86) {
            dieRoll = this.diceRollGenerator.roll(5, 10);
            typeRoll = dieRoll.getTotal();

            itemName = "dust of appearance (" + typeRoll + " uses)";
        }
        else if (roll < 92) {
            dieRoll = this.diceRollGenerator.roll(5, 10);
            typeRoll = dieRoll.getTotal();

            itemName = "dust of disappearance (" + typeRoll + " uses)";
        }
        else if (roll == 92) {
            dieRoll = this.diceRollGenerator.roll(5, 10);
            typeRoll = dieRoll.getTotal();

            itemName = "dust of sneezing and choking (" + typeRoll + " uses)";
        }
        else if (roll == 93) {
            itemName = "efreeti bottle";
        }
        else if (roll == 94) {
            itemName = "eversmoking bottle";
        }
        else if (roll == 95) {
            itemName = "eyes of charming";
        }
        else if (roll < 98) {
            itemName = "eyes of the eagle";
        }
        else if (roll < 100) {
            itemName = "eyes of minute seeing";
        }
        else {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 76) {
                itemName = "eyes of petrification";
            }
            else {
                itemName = "eyes of petrification (basilisk)";
            }
        }

        return itemName;
    }
}
