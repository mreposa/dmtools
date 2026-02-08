package org.mreposa.dmtools.model.adnd.magic;

public class MiscMagicE4 extends MagicItemTable {
    public MiscMagicE4() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll == 1) {
            itemName = "libram of gainful conjuration";
        }
        else if (roll == 2) {
            itemName = "libram of ineffable damnation";
        }
        else if (roll == 3) {
            itemName = "libram of silver magic";
        }
        else if (roll == 4) {
            itemName = "lyre of building";
        }
        else if (roll == 5) {
            itemName = "manual of bodily health";
        }
        else if (roll == 6) {
            itemName = "manual of gainful exercise";
        }
        else if (roll == 7) {
            itemName = "manual of golems";
        }
        else if (roll == 8) {
            itemName = "manual of puissant skill at arms";
        }
        else if (roll == 9) {
            itemName = "manual of quickness of action";
        }
        else if (roll == 10) {
            itemName = "manual of stealthy pilfering";
        }
        else if (roll == 11) {
            itemName = "mattock of the titans";
        }
        else if (roll == 12) {
            itemName = "maul of the titans";
        }
        else if (roll < 16) {
            itemName = "medallion of ESP";
        }
        else if (roll < 18) {
            itemName = "medallion of thought projection";
        }
        else if (roll == 18) {
            itemName = "mirror of life trapping";
        }
        else if (roll == 19) {
            itemName = "mirror of mental prowess";
        }
        else if (roll == 20) {
            itemName = "mirror of opposition";
        }
        else if (roll < 24) {
            itemName = "necklace of adaptation";
        }
        else if (roll < 28) {
            itemName = "necklace of missiles";
        }
        else if (roll < 34) {
            itemName = "necklace of prayer beads";
        }
        else if (roll < 36) {
            itemName = "necklace of strangulation";
        }
        else if (roll < 39) {
            itemName = "net of entrapment";
        }
        else if (roll < 43) {
            itemName = "net of snaring";
        }
        else if (roll < 45) {
            itemName = "Nolzur's marvelous pigments";
        }
        else if (roll < 47) {
            itemName = "pearl of power";
        }
        else if (roll < 49) {
            itemName = "pearl of wisdom";
        }
        else if (roll < 51) {
            itemName = "periapt of foul rotting";
        }
        else if (roll == 54) {
            itemName = "periapt of health";
        }
        else if (roll < 61) {
            itemName = "periapt of proof against poison";
        }
        else if (roll < 65) {
            itemName = "periapt of wound closure";
        }
        else if (roll < 71) {
            itemName = "phylactery of faithfulness";
        }
        else if (roll < 75) {
            itemName = "phylactery of long years";
        }
        else if (roll < 77) {
            itemName = "phylactery of monstrous attention";
        }
        else if (roll < 85) {
            itemName = "pipes of the sewers";
        }
        else if (roll == 85) {
            itemName = "portable hole";
        }
        else {
            itemName = "Quaal's feather token";
        }

        return itemName;
    }
}
