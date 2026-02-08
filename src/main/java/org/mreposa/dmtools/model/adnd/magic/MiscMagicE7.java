package org.mreposa.dmtools.model.adnd.magic;

public class MiscMagicE7 extends MagicItemTable {
    public MiscMagicE7() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll < 6) {
            itemName = "Heward's handy haversack";
        }
        else if (roll < 11) {
            itemName = "horn of fog";
        }
        else if (roll < 13) {
            itemName = "horn of goodness/evil";
        }
        else if (roll < 15) {
            itemName = "iron bands of Bilarro";
        }
        else if (roll < 19) {
            itemName = "lens of detection";
        }
        else if (roll < 22) {
            itemName = "lens of ultravision";
        }
        else if (roll < 24) {
            itemName = "mantle of Celestian";
        }
        else if (roll < 28) {
            itemName = "Murlynd's spoon";
        }
        else if (roll < 30) {
            itemName = "pearl of the sirines";
        }
        else if (roll < 32) {
            itemName = "philosopher's stone";
        }
        else if (roll < 38) {
            itemName = "pouch of accessibility";
        }
        else if (roll == 38) {
            itemName = "prison of Zagyg";
        }
        else if (roll < 41) {
            itemName = "quiver of Ehlonna";
        }
        else if (roll < 43) {
            itemName = "robe of stars";
        }
        else if (roll < 49) {
            itemName = "robe of vermin";
        }
        else if (roll < 51) {
            itemName = "scarab vs. golems";
        }
        else if (roll < 55) {
            itemName = "shadow lanthorn";
        }
        else if (roll < 58) {
            itemName = "sheet of smallness";
        }
        else if (roll < 60) {
            itemName = "shoes of Fharlanghn";
        }
        else if (roll < 65) {
            itemName = "slippers of kicking";
        }
        else if (roll < 71) {
            itemName = "slippers of spider climbing";
        }
        else if (roll < 73) {
            itemName = "sovereign glue";
        }
        else if (roll < 78) {
            itemName = "spoon of stirring";
        }
        else if (roll < 82) {
            itemName = "stone horse";
        }
        else if (roll < 85) {
            itemName = "ultimate solution";
        }
        else if (roll < 89) {
            itemName = "wind fan";
        }
        else if (roll < 93) {
            itemName = "Zagyg's flowing flagon";
        }
        else {
            itemName = "Zagyg's spell component case";
        }

        return itemName;
    }
}
