package org.mreposa.dmtools.model.adnd.magic;

public class MiscMagicE2 extends MagicItemTable {
    public MiscMagicE2() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll < 7) {
            itemName = "candle of invocation";
        }
        else if (roll < 9) {
            itemName = "carpet of flying";
        }
        else if (roll < 11) {
            itemName = "censer of controlling air elementals";
        }
        else if (roll == 11) {
            itemName = "censer of summoning hostile air elementals";
        }
        else if (roll < 14) {
            itemName = "chime of opening";
        }
        else if (roll == 14) {
            itemName = "chime of hunger";
        }
        else if (roll < 19) {
            itemName = "cloak of displacement";
        }
        else if (roll < 28) {
            itemName = "cloak of elvenkind";
        }
        else if (roll < 31) {
            itemName = "cloak of the manta ray";
        }
        else if (roll < 33) {
            itemName = "cloak of poisonousness";
        }
        else if (roll < 56) {
            itemName = "cloak of protection";
        }
        else if (roll < 61) {
            itemName = "crystal ball";
        }
        else if (roll == 61) {
            itemName = "crystal hypnosis ball";
        }
        else if (roll < 64) {
            itemName = "cube of force";
        }
        else if (roll < 66) {
            itemName = "cube of frost resistance";
        }
        else if (roll < 68) {
            itemName = "cubic gate";
        }
        else if (roll < 70) {
            itemName = "Daern's instant fortress";
        }
        else if (roll < 73) {
            itemName = "decanter of endless water";
        }
        else if (roll < 77) {
            itemName = "deck of many things";
        }
        else if (roll == 77) {
            itemName = "drums of deafening";
        }
        else if (roll < 80) {
            itemName = "drums of panic";
        }
        else if (roll < 86) {
            itemName = "dust of appearance";
        }
        else if (roll < 92) {
            itemName = "dust of disappearance";
        }
        else if (roll == 92) {
            itemName = "dust of sneezing and choking";
        }
        else if (roll == 93) {
            itemName = "efreeti bottle";
        }
        else if (roll == 94) {
            itemName = "eversmoking bottle";
        }
        else if (roll == 95) {
            itemName = "eyes of charming";
        }
        else if (roll < 98) {
            itemName = "eyes of the eagle";
        }
        else if (roll < 100) {
            itemName = "eyes of minute seeing";
        }
        else {
            itemName = "eyes of petrification";
        }

        return itemName;
    }
}
