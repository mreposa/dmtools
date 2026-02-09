package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class RingC2 extends MagicItemTable {
    public RingC2(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "ring of ";
        String type = "";
        int typeRoll = 0;

        if (roll < 8) {
            itemName = itemName + "animal friendship";
        }
        else if (roll < 11) {
            itemName = itemName + "anything";
        }
        else if (roll < 21) {
            itemName = itemName + "blinking";
        }
        else if (roll == 23) {
            itemName = itemName + "Boccob";
        }
        else if (roll < 32) {
            itemName = itemName + "chameleon power";
        }
        else if (roll < 41) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 11) {
                type = "free action";
            }
            else if (typeRoll < 21) {
                type = "feather falling";
            }
            else if (typeRoll < 36) {
                type = "invisibility";
            }
            else if (typeRoll < 51) {
                type = "jumping";
            }
            else if (typeRoll < 61) {
                type = "swimming";
            }
            else if (typeRoll < 81) {
                type = "warmth";
            }
            else {
                type = "water walking";
            }

            itemName = itemName + "clumsiness (" + type + ")";
        }
        else if (roll < 50) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "evil";
            }
            else if (typeRoll < 76) {
                type = "good";
            }
            else {
                type = "neutral";
            }

            itemName = itemName + "faerie (" + type + ")";
        }
        else if (roll < 59) {
            itemName = itemName + "jumping";
        }
        else if (roll < 68) {
            itemName = itemName + "mind shielding";
        }
        else if (roll < 71) {
            itemName = itemName + "the ram";
        }
        else if (roll < 80) {
            itemName = itemName + "shocking grasp";
        }
        else if (roll < 93) {
            itemName = itemName + "sustenance";
        }
        else {
            itemName = itemName + "truth";
        }

        return itemName;
    }
}
