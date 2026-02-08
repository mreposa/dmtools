package org.mreposa.dmtools.model.adnd.magic;

public class RingC extends MagicItemTable {
    public RingC() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "ring of ";

        if (roll < 7) {
            itemName = itemName + "contrariness";
        }
        else if (roll < 13) {
            itemName = itemName + "delusion";
        }
        else if (roll < 15) {
            itemName = itemName + "djinni summoning";
        }
        else if (roll == 15) {
            itemName = itemName + "elemental command";
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
            itemName = itemName + "protection";
        }
        else if (roll == 61) {
            itemName = itemName + "regeneration";
        }
        else if (roll < 64) {
            itemName = itemName + "shooting stars";
        }
        else if (roll < 66) {
            itemName = itemName + "spell storing";
        }
        else if (roll < 70) {
            itemName = itemName + "spell turning";
        }
        else if (roll < 76) {
            itemName = itemName + "swimming";
        }
        else if (roll < 78) {
            itemName = itemName + "telekinesis";
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
            itemName = itemName + "wizardry";
        }
        else {
            itemName = itemName + "x-ray vision";
        }

        return itemName;
    }
}
