package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscMagicE5 extends MagicItemTable {
    public MiscMagicE5(DiceRollGenerator diceRollGenerator) {
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
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 46) {
                type = "good";
            }
            else if (typeRoll < 76) {
                type = "true neutral";
            }
            else  {
                type = "evil";
            }

            itemName = "robe of the archmagi (" + type + ")";
        }
        else if (roll < 9) {
            itemName = "robe of blending";
        }
        else if (roll == 9) {
            itemName = "robe of eyes";
        }
        else if (roll == 10) {
            itemName = "robe of powerlessness";
        }
        else if (roll == 11) {
            itemName = "robe of scintillating colors";
        }
        else if (roll < 20) {
            dieRoll = this.diceRollGenerator.roll(4, 4);
            int count = dieRoll.getTotal();

            itemName = "robe of useful items (plus " + count + " items)";
        }
        else if (roll < 26) {
            itemName = "rope of climbing";
        }
        else if (roll < 28) {
            itemName = "rope of constriction";
        }
        else if (roll < 32) {
            itemName = "rope of entanglement";
        }
        else if (roll == 32) {
            itemName = "rug of smothering";
        }
        else if (roll == 33) {
            itemName = "rug of welcome";
        }
        else if (roll == 34) {
            itemName = "saw of mighty cutting";
        }
        else if (roll == 35) {
            itemName = "scarab of death";
        }
        else if (roll < 39) {
            itemName = "scarab of enraging enemies";
        }
        else if (roll == 41) {
            dieRoll = this.diceRollGenerator.roll(1, 8);
            int count = dieRoll.getTotal() + 8;

            itemName = "scarab of insanity (" + count + " charges)";
        }
        else if (roll < 47) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if  (typeRoll == 1) {
                type = " (cursed)";

                dieRoll = this.diceRollGenerator.roll(1, 5);
                int special = dieRoll.getTotal();

                if (special == 1) {
                    type = " (special cursed)";
                }
            }

            itemName = "scarab of protection" + type;
        }
        else if (roll == 47) {
            itemName = "spade of colossal excavation";
        }
        else if (roll == 48) {
            itemName = "sphere of annihilation";
        }
        else if (roll < 51) {
            itemName = "stone of controlling earth elementals";
        }
        else if (roll < 53) {
            itemName = "stone of good luck";
        }
        else if (roll < 55) {
            itemName = "stone of weight";
        }
        else if (roll < 58) {
            itemName = "talisman of pure good";
        }
        else if (roll == 58) {
            itemName = "talisman of the sphere";
        }
        else if (roll < 61) {
            itemName = "talisman of ultimate evil";
        }
        else if (roll < 67) {
            itemName = "talisman of Zagy";
        }
        else if (roll == 67) {
            itemName = "tome of clear thought";
        }
        else if (roll == 68) {
            itemName = "tome of leadership and influence";
        }
        else if (roll == 69) {
            itemName = "tome of understanding";
        }
        else if (roll < 77) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int count = dieRoll.getTotal() + 16;

            itemName = "trident of fish command (" + count + " charges)";
        }
        else if (roll < 79) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int count = dieRoll.getTotal() + 16;

            itemName = "trident of submission (" + count + " charges)";
        }
        else if (roll < 84) {
            itemName = "trident of warning";
        }
        else if (roll < 86) {
            itemName = "trident of yearning";
        }
        else if (roll < 88) {
            itemName = "vacuous grimoire";
        }
        else if (roll < 91) {
            itemName = "well of many worlds";
        }
        else {
            itemName = "wings of flying";
        }

        return itemName;
    }
}
