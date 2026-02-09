package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class PotionA2 extends MagicItemTable {
    public PotionA2(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "potion of ";
        String type = "";
        int typeRoll = 0;

        if (roll < 6) {
            itemName = "elixir of health";
        }
        else if (roll < 16) {
            itemName = "elixir of life";
        }
        else if (roll < 21) {
            itemName = "elixir of madness";
        }
        else if (roll < 26) {
            itemName = "elixir of youth";
        }
        else if (roll < 31) {
            itemName = itemName + "fire breath";
        }
        else if (roll < 36) {
            itemName = "oil of acid resistance";
        }
        else if (roll < 41) {
            itemName = "oil of disenchantment";
        }
        else if (roll < 46) {
            itemName = "oil of elemental invulnerability";
        }
        else if (roll < 50) {
            itemName = "oil of fiery burning";
        }
        else if (roll < 56) {
            itemName = "oil of fumbling";
        }
        else if (roll < 60) {
            itemName = "oil of impact";
        }
        else if (roll < 66) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 3) {
                type = "+1";
            }
            else if (typeRoll < 6) {
                type = "+2";
            }
            else if (typeRoll < 12) {
                type = "+3";
            }
            else if (typeRoll < 17) {
                type = "+4";
            }
            else if (typeRoll < 20) {
                type = "+5";
            }
            else {
                type = "+6";
            }

            itemName = "oil of sharpness " + type;
        }
        else if (roll < 71) {
            itemName = "oil of timelessness";
        }
        else if (roll < 76) {
            itemName = "philter of beauty";
        }
        else if (roll < 81) {
            itemName = "philter of glibness";
        }
        else if (roll < 86) {
            itemName = "philter of stammering and stuttering";
        }
        else if (roll < 91) {
            itemName = itemName + "rainbow hues";
        }
        else if (roll < 96) {
            itemName = itemName + "ventriloquism";
        }
        else {
            itemName = itemName + "vitality";
        }

        return itemName;
    }
}
