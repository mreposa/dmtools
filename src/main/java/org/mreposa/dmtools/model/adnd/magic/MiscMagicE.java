package org.mreposa.dmtools.model.adnd.magic;

public class MiscMagicE extends MagicItemTable {
    public MiscMagicE() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll < 3) {
            itemName = "alchemy jug";
        }
        else if (roll < 5) {
            itemName = "amulet of inescapable location";
        }
        else if (roll == 5) {
            itemName = "amulet of life protection";
        }
        else if (roll < 8) {
            itemName = "amulet of the planes";
        }
        else if (roll < 12) {
            itemName = "amulet of proof against detection and location";
        }
        else if (roll < 14) {
            itemName = "apparatus of Kwalish";
        }
        else if (roll < 17) {
            itemName = "arrow of direction";
        }
        else if (roll == 17) {
            itemName = "artifact or relic (see DMG pg. 124)";
        }
        else if (roll < 21) {
            itemName = "bag of beans";
        }
        else if (roll == 21) {
            itemName = "bag of devouring";
        }
        else if (roll < 27) {
            itemName = "bag of holding";
        }
        else if (roll == 27) {
            itemName = "bag of transmuting";
        }
        else if (roll < 30) {
            itemName = "bag of tricks";
        }
        else if (roll < 32) {
            itemName = "beaker of plentiful potions";
        }
        else if (roll == 32) {
            itemName = "folding boat";
        }
        else if (roll == 33) {
            itemName = "book of exalted deeds";
        }
        else if (roll == 34) {
            itemName = "book of infinite spells";
        }
        else if (roll == 35) {
            itemName = "book of vile darkness";
        }
        else if (roll == 36) {
            itemName = "boots of dancing";
        }
        else if (roll < 43) {
            itemName = "boots of elvenkind";
        }
        else if (roll < 48) {
            itemName = "boots of levitation";
        }
        else if (roll < 52) {
            itemName = "boots of speed";
        }
        else if (roll < 56) {
            itemName = "boots of striding and springing";
        }
        else if (roll < 59) {
            itemName = "bowl of commanding water elementals";
        }
        else if (roll == 59) {
            itemName = "bowl of watery death";
        }
        else if (roll < 80) {
            itemName = "bracers of defense";
        }
        else if (roll < 82) {
            itemName = "bracers of defenselessness";
        }
        else if (roll < 85) {
            itemName = "brazier commanding fire elementals";
        }
        else if (roll == 85) {
            itemName = "brazier of sleep smoke";
        }
        else if (roll < 93) {
            itemName = "brooch of shielding";
        }
        else if (roll == 93) {
            itemName = "broom of animated attack";
        }
        else if (roll < 99) {
            itemName = "broom of flying";
        }
        else {
            itemName = "Bucknard's everfull purse";
        }

        return itemName;
    }
}
