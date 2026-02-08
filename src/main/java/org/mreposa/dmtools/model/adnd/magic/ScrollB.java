package org.mreposa.dmtools.model.adnd.magic;

public class ScrollB extends MagicItemTable {
    public ScrollB() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "scroll of ";

        if (roll < 11) {
            itemName = itemName + "1 spell (level 1 - 4)";
        }
        else if (roll < 17) {
            itemName = itemName + "1 spell (level 1 - 6)";
        }
        else if (roll < 20) {
            itemName = itemName + "1 spell (level 2 - 9 or 2 - 7)";
        }
        else if (roll < 25) {
            itemName = itemName + "2 spells (level 1 - 4)";
        }
        else if (roll < 28) {
            itemName = itemName + "2 spells (level 1 - 8 or 1 - 6)";
        }
        else if (roll < 33) {
            itemName = itemName + "3 spells (level 1 - 4)";
        }
        else if (roll < 36) {
            itemName = itemName + "3 spells (level 2 - 9 or 2 - 7)";
        }
        else if (roll < 40) {
            itemName = itemName + "4 spells (level 1 - 6)";
        }
        else if (roll < 43) {
            itemName = itemName + "4 spells (level 1 - 8 or 1 - 6)";
        }
        else if (roll < 47) {
            itemName = itemName + "5 spells (level 1 - 6)";
        }
        else if (roll < 50) {
            itemName = itemName + "5 spells (level 1 - 8 or 1 - 6)";
        }
        else if (roll < 53) {
            itemName = itemName + "6 spells (level 1 - 6)";
        }
        else if (roll < 55) {
            itemName = itemName + "6 spells (level 3 - 8 or 3 - 6)";
        }
        else if (roll < 58) {
            itemName = itemName + "7 spells (level 1 - 8)";
        }
        else if (roll < 60) {
            itemName = itemName + "7 spells (level 2 - 9 or 2 - 7)";
        }
        else if (roll == 60) {
            itemName = itemName + "7 spells (level 4 - 9 or 4 - 7)";
        }
        else if (roll < 63) {
            itemName = itemName + "protection - demons";
        }
        else if (roll < 65) {
            itemName = itemName + "protection - devils";
        }
        else if (roll < 71) {
            itemName = itemName + "protection - elementals";
        }
        else if (roll < 77) {
            itemName = itemName + "protection - lycanthropes";
        }
        else if (roll < 83) {
            itemName = itemName + "protection - magic";
        }
        else if (roll < 88) {
            itemName = itemName + "protection - petrification";
        }
        else if (roll < 93) {
            itemName = itemName + "protection - possession";
        }
        else if (roll < 98) {
            itemName = itemName + "protection - undead";
        }
        else {
            itemName = itemName + "curse";
        }

        return itemName;
    }
}
