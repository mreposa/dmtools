package org.mreposa.dmtools.model.adnd.magic;

public class MiscMagicE3 extends MagicItemTable {
    public MiscMagicE3() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll < 16) {
            itemName = "figurine of wonderous power";
        }
        else if (roll == 16) {
            itemName = "flask of curses";
        }
        else if (roll < 19) {
            itemName = "gauntlets of dexterity";
        }
        else if (roll < 21) {
            itemName = "gauntlets of fumbling";
        }
        else if (roll < 23) {
            itemName = "gauntlets of ogre power";
        }
        else if (roll < 26) {
            itemName = "gauntlets of swimming and climbing";
        }
        else if (roll == 26) {
            itemName = "gem of brightness";
        }
        else if (roll == 27) {
            itemName = "gem of seeing";
        }
        else if (roll == 28) {
            itemName = "girdle of femininity/masculinity";
        }
        else if (roll == 29) {
            itemName = "girdle of giant strength";
        }
        else if (roll == 30) {
            itemName = "helm of brilliance";
        }
        else if (roll < 35) {
            itemName = "helm of comprehending languages and reading magic";
        }
        else if (roll < 38) {
            itemName = "helm of opposite alignment";
        }
        else if (roll < 40) {
            itemName = "helm of telepathy";
        }
        else if (roll == 40) {
            itemName = "helm of teleportation";
        }
        else if (roll < 46) {
            itemName = "helm of underwater action";
        }
        else if (roll == 46) {
            itemName = "horn of blasting";
        }
        else if (roll < 49) {
            itemName = "horn of bubbles";
        }
        else if (roll == 49) {
            itemName = "horn of collapsing";
        }
        else if (roll < 54) {
            itemName = "horn of the tritons";
        }
        else if (roll < 61) {
            itemName = "horn of Valhalla";
        }
        else if (roll < 64) {
            itemName = "horseshoes of speed";
        }
        else if (roll < 66) {
            itemName = "horseshoes of a zephyr";
        }
        else if (roll < 71) {
            itemName = "incense of meditation";
        }
        else if (roll == 71) {
            itemName = "incense of obsession";
        }
        else if (roll == 72) {
            itemName = "ioun stone";
        }
        else if (roll < 80) {
            itemName = "instrument of the bards";
        }
        else if (roll < 82) {
            itemName = "iron flask";
        }
        else if (roll < 85) {
            itemName = "javelin of lightning";
        }
        else if (roll < 91) {
            itemName = "javelin of piercing";
        }
        else if (roll == 91) {
            itemName = "jewel of attacks";
        }
        else if (roll == 92) {
            itemName = "jewel of flawlessness";
        }
        else {
            itemName = "Keoghtom's ointment";
        }

        return itemName;
    }
}
