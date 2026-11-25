package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.generator.adnd.SpellGenerator;
import org.mreposa.dmtools.model.adnd.spells.SpellTable;
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
        String type;
        int typeRoll;
        int levelRoll;
        int spellCount = 0;
        StringBuilder spells = new StringBuilder();
        String casterClass;
        SpellGenerator spellGenerator = new SpellGenerator(this.diceRollGenerator);

        dieRoll = this.diceRollGenerator.roll(1, 100);
        int classRoll = dieRoll.getTotal();
        int subClassRoll;

        if (classRoll < 71) {
            // Magic-User
            casterClass = SpellTable.SPELL_CLASSES[0];

            dieRoll = this.diceRollGenerator.roll(1, 100);
            subClassRoll = dieRoll.getTotal();

            if  (subClassRoll < 11) {
                // Illusionist
                casterClass = SpellTable.SPELL_CLASSES[3];
            }
        }
        else {
            // Cleric
            casterClass = SpellTable.SPELL_CLASSES[1];

            dieRoll = this.diceRollGenerator.roll(1, 100);
            subClassRoll = dieRoll.getTotal();

            if  (subClassRoll < 26) {
                // Druid
                casterClass = SpellTable.SPELL_CLASSES[2];
            }
        }

        if (roll < 11) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            levelRoll = dieRoll.getTotal();
            itemName = itemName + "1 " + casterClass + " spell (" + spellGenerator.getSpell(levelRoll, casterClass) + ")";
        }
        else if (roll < 17) {
            dieRoll = this.diceRollGenerator.roll(1, 6);
            levelRoll = dieRoll.getTotal();
            itemName = itemName + "1 " + casterClass + " spell (" + spellGenerator.getSpell(levelRoll, casterClass) + ")";
        }
        else if (roll < 20) {
            if (classRoll < 71) {
                dieRoll = this.diceRollGenerator.roll(1, 8);
                levelRoll = dieRoll.getTotal() + 1;
            }
            else {
                dieRoll = this.diceRollGenerator.roll(1, 6);
                levelRoll = dieRoll.getTotal() + 1;
            }

            itemName = itemName + "1 " + casterClass + " spell (" + spellGenerator.getSpell(levelRoll, casterClass) + ")";
        }
        else if (roll < 25) {
            while (spellCount < 2) {
                dieRoll = this.diceRollGenerator.roll(1, 4);
                levelRoll = dieRoll.getTotal();
                spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                if (spellCount < 1) {
                    spells.append(", ");
                }
                spellCount++;
            }

            itemName = itemName + "2 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 28) {
            if (classRoll < 71) {
                while (spellCount < 2) {
                    dieRoll = this.diceRollGenerator.roll(1, 8);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 1) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 2) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 1) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "2 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 33) {
            while (spellCount < 3) {
                dieRoll = this.diceRollGenerator.roll(1, 4);
                levelRoll = dieRoll.getTotal();
                spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                if (spellCount < 2) {
                    spells.append(", ");
                }
                spellCount++;
            }

            itemName = itemName + "3 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 36) {
            if (classRoll < 71) {
                while (spellCount < 3) {
                    dieRoll = this.diceRollGenerator.roll(1, 8);
                    levelRoll = dieRoll.getTotal() + 1;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 2) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 3) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal() + 1;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 2) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "3 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 40) {
            while (spellCount < 4) {
                dieRoll = this.diceRollGenerator.roll(1, 6);
                levelRoll = dieRoll.getTotal() + 1;
                spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                if (spellCount < 3) {
                    spells.append(", ");
                }
                spellCount++;
            }

            itemName = itemName + "4 " + casterClass + " spells ("  + spells + ")";
        }
        else if (roll < 43) {
            if (classRoll < 71) {
                while (spellCount < 4) {
                    dieRoll = this.diceRollGenerator.roll(1, 8);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 3) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 4) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 3) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "4 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 47) {
            while (spellCount < 5) {
                dieRoll = this.diceRollGenerator.roll(1, 6);
                levelRoll = dieRoll.getTotal();
                spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                if (spellCount < 4) {
                    spells.append(", ");
                }
                spellCount++;
            }

            itemName = itemName + "5 " + casterClass + " spells ("  + spells + ")";
        }
        else if (roll < 50) {
            if (classRoll < 71) {
                while (spellCount < 5) {
                    dieRoll = this.diceRollGenerator.roll(1, 8);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 4) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 5) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 4) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "5 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 53) {
            while (spellCount < 6) {
                dieRoll = this.diceRollGenerator.roll(1, 6);
                levelRoll = dieRoll.getTotal();
                spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                if (spellCount < 5) {
                    spells.append(", ");
                }
                spellCount++;
            }

            itemName = itemName + "6 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 55) {
            if (classRoll < 71) {
                while (spellCount < 6) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal() + 2;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 5) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 6) {
                    dieRoll = this.diceRollGenerator.roll(1, 4);
                    levelRoll = dieRoll.getTotal() + 2;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 5) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "6 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 58) {
            if (classRoll < 71) {
                while (spellCount < 7) {
                    dieRoll = this.diceRollGenerator.roll(1, 8);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 6) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 7) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal();
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 6) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "7 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll < 60) {
            if (classRoll < 71) {
                while (spellCount < 7) {
                    dieRoll = this.diceRollGenerator.roll(1, 8);
                    levelRoll = dieRoll.getTotal() + 1;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 6) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 7) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal() + 1;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 6) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "7 " + casterClass + " spells (" + spells + ")";
        }
        else if (roll == 60) {
            if (classRoll < 71) {
                while (spellCount < 7) {
                    dieRoll = this.diceRollGenerator.roll(1, 6);
                    levelRoll = dieRoll.getTotal() + 3;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 6) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }
            else {
                while (spellCount < 7) {
                    dieRoll = this.diceRollGenerator.roll(1, 4);
                    levelRoll = dieRoll.getTotal() + 3;
                    spells.append(spellGenerator.getSpell(levelRoll, casterClass));
                    if (spellCount < 6) {
                        spells.append(", ");
                    }
                    spellCount++;
                }
            }

            itemName = itemName + "7 " + casterClass + " spells (" + spells + ")";
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

        // Special Case: on any Illusionist scroll,  re-roll the 7th level spell "First Level Magic-User Spells"
        if (casterClass.equals(SpellTable.SPELL_CLASSES[3]) && itemName.contains(SpellTable.ILLUSIONIST_LEVEL_7[4])) {
            itemName = fixIllusionistScroll(itemName);
        }

        return itemName;
    }

    private String fixIllusionistScroll(String scroll) {
        SpellGenerator spellGenerator = new SpellGenerator();
        StringBuilder sb;
        int start;
        int end;
        String newSpell;

        sb = new StringBuilder(scroll);
        while (sb.indexOf(SpellTable.ILLUSIONIST_LEVEL_7[7]) != -1) {
            do {
                newSpell = spellGenerator.getSpell(7, SpellTable.SPELL_CLASSES[3]);
            }
            while (newSpell.contains(SpellTable.ILLUSIONIST_LEVEL_7[7]));

            start = sb.indexOf(SpellTable.ILLUSIONIST_LEVEL_7[7]);
            end = sb.indexOf("]") + 1;

            sb.replace(start, end, newSpell);
        }

        return sb.toString();
    }
}
