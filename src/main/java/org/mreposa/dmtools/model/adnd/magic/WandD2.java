package org.mreposa.dmtools.model.adnd.magic;

public class WandD2 extends MagicItemTable {
    public WandD2() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "wand of ";

        if (roll == 1) {
            itemName = "anything wand";
        }
        else if (roll < 6) {
            itemName = "buckler wand";
        }
        else if (roll == 8) {
            itemName = itemName + "conjuration";
        }
        else if (roll < 11) {
            itemName = itemName + "defoliation";
        }
        else if (roll < 13) {
            itemName = itemName + "earth and stone";
        }
        else if (roll == 17) {
            itemName = itemName + "enemy detection";
        }
        else if (roll < 21) {
            itemName = itemName + "fear";
        }
        else if (roll == 23) {
            itemName = itemName + "fire";
        }
        else if (roll == 27) {
            itemName = itemName + "fireballs";
        }
        else if (roll < 31) {
            itemName = itemName + "flame extinguishing";
        }
        else if (roll == 31) {
            itemName = itemName + "force";
        }
        else if (roll == 32) {
            itemName = itemName + "frost";
        }
        else if (roll < 36) {
            itemName = itemName + "ice storms";
        }
        else if (roll < 40) {
            itemName = itemName + "illumination";
        }
        else if (roll < 44) {
            itemName = itemName + "illusion";
        }
        else if (roll == 46) {
            itemName = itemName + "lightning";
        }
        else if (roll == 50) {
            itemName = itemName + "lightning bolts";
        }
        else if (roll < 54) {
            itemName = itemName + "magic detection";
        }
        else if (roll < 62) {
            itemName = itemName + "magic missiles";
        }
        else if (roll < 67) {
            itemName = itemName + "metal and mineral detection";
        }
        else if (roll < 69) {
            itemName = itemName + "metal command";
        }
        else if (roll < 75) {
            itemName = itemName + "negation";
        }
        else if (roll == 79) {
            itemName = itemName + "paralyzation";
        }
        else if (roll < 83) {
            itemName = itemName + "polymorphing";
        }
        else if (roll < 87) {
            itemName = itemName + "secret door and trap location";
        }
        else if (roll < 91) {
            itemName = itemName + "size alteration";
        }
        else if (roll < 93) {
            itemName = itemName + "steam and vapor";
        }
        else {
            itemName = itemName + "wonder";
        }

        return itemName;
    }
}
