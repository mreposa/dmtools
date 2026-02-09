package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class ScrollB extends MagicItemTable {
    public ScrollB(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "scroll of ";
        String type = "";
        int typeRoll = 0;
        String casterClass = "";
        String spellLevel = "";

        dieRoll = this.diceRollGenerator.roll(1, 100);
        int classRoll = dieRoll.getTotal();
        int subClassRoll = 0;

        if (classRoll < 71) {
            casterClass = "magic-user";

            dieRoll = this.diceRollGenerator.roll(1, 100);
            subClassRoll = dieRoll.getTotal();

            if  (subClassRoll < 11) {
                casterClass = "illusionist";
            }
        }
        else {
            casterClass = "cleric";

            dieRoll = this.diceRollGenerator.roll(1, 100);
            subClassRoll = dieRoll.getTotal();

            if  (subClassRoll < 26) {
                casterClass = "druid";
            }
        }

        if (roll < 11) {
            itemName = itemName + "1 " + casterClass + " spell (level 1 - 4)";
        }
        else if (roll < 17) {
            itemName = itemName + "1 " + casterClass + " spell (level 1 - 6)";
        }
        else if (roll < 20) {
            if (classRoll < 71) {
                spellLevel = "2 - 9";
            }
            else {
                spellLevel = "2 - 7";
            }

            itemName = itemName + "1 " + casterClass + " spell (level " + spellLevel + ")";
        }
        else if (roll < 25) {
            itemName = itemName + "2 " + casterClass + " spells (level 1 - 4)";
        }
        else if (roll < 28) {
            if (classRoll < 71) {
                spellLevel = "1 - 8";
            }
            else {
                spellLevel = "1 - 6";
            }

            itemName = itemName + "2 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll < 33) {
            itemName = itemName + "3 " + casterClass + " spells (level 1 - 4)";
        }
        else if (roll < 36) {
            if (classRoll < 71) {
                spellLevel = "2 - 9";
            }
            else {
                spellLevel = "2 - 7";
            }

            itemName = itemName + "3 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll < 40) {
            itemName = itemName + "4 " + casterClass + " spells (level 1 - 6)";
        }
        else if (roll < 43) {
            if (classRoll < 71) {
                spellLevel = "1 - 8";
            }
            else {
                spellLevel = "1 - 6";
            }

            itemName = itemName + "4 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll < 47) {
            itemName = itemName + "5 " + casterClass + " spells (level 1 - 6)";
        }
        else if (roll < 50) {
            if (classRoll < 71) {
                spellLevel = "1 - 8";
            }
            else {
                spellLevel = "1 - 6";
            }

            itemName = itemName + "5 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll < 53) {
            itemName = itemName + "6 " + casterClass + " spells (level 1 - 6)";
        }
        else if (roll < 55) {
            if (classRoll < 71) {
                spellLevel = "3 - 8";
            }
            else {
                spellLevel = "3 - 6";
            }

            itemName = itemName + "6 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll < 58) {
            if (classRoll < 71) {
                spellLevel = "1 - 8";
            }
            else {
                spellLevel = "1 - 7";
            }

            itemName = itemName + "7 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll < 60) {
            if (classRoll < 71) {
                spellLevel = "2 - 9";
            }
            else {
                spellLevel = "2 - 7";
            }

            itemName = itemName + "7 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll == 60) {
            if (classRoll < 71) {
                spellLevel = "4 - 9";
            }
            else {
                spellLevel = "4 - 7";
            }

            itemName = itemName + "7 " + casterClass + " spells (level " + spellLevel + ")";
        }
        else if (roll < 63) {
            itemName = itemName + "protection - demons";
        }
        else if (roll < 65) {
            itemName = itemName + "protection - devils";
        }
        else if (roll < 71) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 16) {
                type = "air";
            }
            else if (typeRoll < 31) {
                type = "earth";
            }
            else if (typeRoll < 46) {
                type = "fire";
            }
            else if (typeRoll < 61) {
                type = "water";
            }
            else {
                type = "all";
            }

            itemName = itemName + "protection - elementals (" + type + ")";
        }
        else if (roll < 77) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "werebears";
            }
            else if (typeRoll < 11) {
                type = "wereboars";
            }
            else if (typeRoll < 21) {
                type = "wererats";
            }
            else if (typeRoll < 26) {
                type = "weretigers";
            }
            else if (typeRoll < 41) {
                type = "werewolves";
            }
            else if (typeRoll < 99) {
                type = "all";
            }
            else {
                type = "all shape-changers";
            }

            itemName = itemName + "protection - lycanthropes (" + type + ")";
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
