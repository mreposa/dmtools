package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscMagicE extends MagicItemTable {
    public MiscMagicE(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;

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
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 31) {
                type = "250 lb/30 cu ft";
            }
            else if (typeRoll < 71) {
                type = "500 lb/70 cu ft";
            }
            else if (typeRoll < 91) {
                type = "1000 lb/150 cu ft";
            }
            else {
                type = "1500 lb/250 cu ft";
            }

            itemName = "bag of holding (" + type + ")";
        }
        else if (roll == 27) {
            itemName = "bag of transmuting";
        }
        else if (roll < 30) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "type I";
            }
            else if (typeRoll < 9) {
                type = "type II";
            }
            else {
                type = "type III";
            }

            itemName = "bag of tricks (" + type + ")";
        }
        else if (roll < 32) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int doses = dieRoll.getTotal() + 1;

            dieRoll = this.diceRollGenerator.roll(1, 4);
            int potions = dieRoll.getTotal() + 1;

            itemName = "beaker of plentiful potions (" + doses + " doses of " + potions + " potions)";
        }
        else if (roll == 32) {
            itemName = "folding boat";
        }
        else if (roll == 33) {
            itemName = "book of exalted deeds";
        }
        else if (roll == 34) {
            dieRoll = this.diceRollGenerator.roll(1, 8);
            int pages = dieRoll.getTotal() + 22;

            itemName = "book of infinite spells (" + pages + " pages)";
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
            dieRoll = this.diceRollGenerator.roll(1, 20);
            int weight = 280 + (dieRoll.getTotal() * 14);

            itemName = "boots of levitation (" + weight + " lbs max)";
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
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "8";
            }
            else if (typeRoll < 16) {
                type = "7";
            }
            else if (typeRoll < 36) {
                type = "6";
            }
            else if (typeRoll < 51) {
                type = "5";
            }
            else if (typeRoll < 71) {
                type = "4";
            }
            else if (typeRoll < 86) {
                type = "3";
            }
            else {
                type = "2";
            }

            itemName = "bracers of defense AC " + type;
        }
        else if (roll < 82) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "8";
            }
            else if (typeRoll < 16) {
                type = "7";
            }
            else if (typeRoll < 36) {
                type = "6";
            }
            else if (typeRoll < 51) {
                type = "5";
            }
            else if (typeRoll < 71) {
                type = "4";
            }
            else if (typeRoll < 86) {
                type = "3";
            }
            else {
                type = "2";
            }

            itemName = "bracers of defenselessness AC " + type;
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
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 51) {
                type = "type I";
            }
            else if (typeRoll < 91) {
                type = "type II";
            }
            else {
                type = "type III";
            }

            itemName = "Bucknard's everfull purse (" + type + ")";
        }

        return itemName;
    }
}
