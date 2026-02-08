package org.mreposa.dmtools.model.adnd.magic;

public class RingC2 extends MagicItemTable {
    public RingC2() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "ring of ";

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
            itemName = itemName + "clumsiness";
        }
        else if (roll < 50) {
            itemName = itemName + "faerie";
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
