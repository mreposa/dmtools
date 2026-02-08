package org.mreposa.dmtools.model.adnd.magic;

public class ScrollB2 extends MagicItemTable {
    public ScrollB2() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "scroll of ";

        if (roll < 3) {
            itemName = itemName + "protection - acid";
        }
        else if (roll < 8) {
            itemName = itemName + "protection - dragon breath weapons";
        }
        else if (roll < 13) {
            itemName = itemName + "protection - non-dragon breath weapons";
        }
        else if (roll < 18) {
            itemName = itemName + "protection - cold";
        }
        else if (roll < 23) {
            itemName = itemName + "protection - electricity";
        }
        else if (roll < 28) {
            itemName = itemName + "protection - fire";
        }
        else if (roll < 33) {
            itemName = itemName + "protection - gas";
        }
        else if (roll < 38) {
            itemName = itemName + "protection - illusions";
        }
        else if (roll < 43) {
            itemName = itemName + "protection - paralyzation";
        }
        else if (roll < 49) {
            itemName = itemName + "protection - plants";
        }
        else if (roll < 55) {
            itemName = itemName + "protection - poison";
        }
        else if (roll < 60) {
            itemName = itemName + "protection - traps";
        }
        else if (roll < 65) {
            itemName = itemName + "protection - water";
        }
        else if (roll < 71) {
            itemName = itemName + "protection - weapons (magic blunt)";
        }
        else if (roll < 77) {
            itemName = itemName + "protection - weapons (magic edged)";
        }
        else if (roll < 83) {
            itemName = itemName + "protection - weapons (magic missile)";
        }
        else if (roll < 89) {
            itemName = itemName + "protection - weapons (non-magic blunt)";
        }
        else if (roll < 95) {
            itemName = itemName + "protection - weapons (non-magic edged)";
        }
        else {
            itemName = itemName + "protection - weapons (non-magic missile)";
        }

        return itemName;
    }
}
