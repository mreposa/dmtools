package org.mreposa.dmtools.model.adnd.magic;

public class MiscMagicE6 extends MagicItemTable {
    public MiscMagicE6() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll < 5) {
            itemName = "amulet vs. undead";
        }
        else if (roll == 5) {
            itemName = "anything item";
        }
        else if (roll < 8) {
            itemName = "beads of force";
        }
        else if (roll < 15) {
            itemName = "Boccob's blessed book";
        }
        else if (roll < 17) {
            itemName = "boots of the north";
        }
        else if (roll < 20) {
            itemName = "boots of varied tracks";
        }
        else if (roll == 20) {
            itemName = "winged boots";
        }
        else if (roll < 25) {
            itemName = "bracers of archery";
        }
        else if (roll < 27) {
            itemName = "bracers of brachiation";
        }
        else if (roll < 29) {
            itemName = "chime of interruption";
        }
        else if (roll < 31) {
            itemName = "cloak of arachnidia";
        }
        else if (roll < 35) {
            itemName = "cloak of the bat";
        }
        else if (roll < 37) {
            itemName = "cyclocone";
        }
        else if (roll < 41) {
            itemName = "dart of the hornet nest";
        }
        else if (roll < 43) {
            itemName = "deck of illusions";
        }
        else if (roll < 45) {
            itemName = "dicerion of light and darkness";
        }
        else if (roll < 48) {
            itemName = "dust of dryness";
        }
        else if (roll < 51) {
            itemName = "dust of illusion";
        }
        else if (roll < 55) {
            itemName = "dust of tracelessness";
        }
        else if (roll < 57) {
            itemName = "egg of desire";
        }
        else if (roll < 61) {
            itemName = "egg of reason";
        }
        else if (roll < 63) {
            itemName = "egg of shattering";
        }
        else if (roll < 66) {
            itemName = "gem of insight";
        }
        else if (roll < 69) {
            itemName = "girdle of dwarvenkind";
        }
        else if (roll < 77) {
            itemName = "girdle of many pouches";
        }
        else if (roll < 80) {
            itemName = "gloves of missile snaring";
        }
        else if (roll < 84) {
            itemName = "gloves of thievery";
        }
        else if (roll < 89) {
            itemName = "hat of difference";
        }
        else if (roll < 96) {
            itemName = "hat of disguise";
        }
        else {
            itemName = "hat of stupidity";
        }

        return itemName;
    }
}
