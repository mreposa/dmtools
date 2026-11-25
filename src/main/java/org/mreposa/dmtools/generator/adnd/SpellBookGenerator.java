package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.spells.SpellBook;
import org.mreposa.dmtools.model.adnd.spells.SpellTable;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.HashSet;
import java.util.Set;

public class SpellBookGenerator {
    private final DiceRollGenerator diceRollGenerator;
    private final SpellGenerator  spellGenerator;

    public SpellBookGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
        this.spellGenerator = new SpellGenerator(this.diceRollGenerator);
    }

    public SpellBookGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
        this.spellGenerator = new SpellGenerator(this.diceRollGenerator);
    }

    public SpellBook generate(int casterLevel, String casterClass, int intelligenceScorePosition) {
        if (casterClass.equals(SpellTable.SPELL_BOOK_CLASSES[1]) && intelligenceScorePosition < 6) {
            // Minimum 15 Intelligence required for Illusionists
            intelligenceScorePosition = 6;
        }

        int maxSpellLevel = getMaxSpellLevel(casterLevel, casterClass, intelligenceScorePosition);

        SpellBook spellBook = new SpellBook(casterLevel, casterClass, maxSpellLevel);

        int spellCount;
        Set<String> spellList;
        for (int spellLevel = 1; spellLevel <= maxSpellLevel; spellLevel++) {
            spellCount = getSpellCount(spellLevel, casterClass, casterLevel, intelligenceScorePosition);

            if (spellCount == getTotalSpellCount(spellLevel, casterClass)) {
                spellList = this.spellGenerator.getAllSpells(spellLevel, casterClass);
            }
            else {
                if (spellLevel == 1) {
                    spellList = generateStartingSpells(casterClass);
                    spellList = this.spellGenerator.generateAdditionalFirstLevelSpells(spellCount, casterClass, spellList);
                } else {
                    spellList = this.spellGenerator.generate(spellCount, spellLevel, casterClass);
                }
            }

            spellBook.addSpellList(spellLevel, spellList);
        }

        return spellBook;
    }

    private int getMaxSpellLevel(int casterLevel, String casterClass, int intelligenceScorePosition) {
        int maxSpellLevel;

        if (casterClass.equals(SpellTable.SPELL_BOOK_CLASSES[0])) {
            if (casterLevel > SpellTable.MAGIC_USER_MAX_SPELL_LEVEL.length) {
                maxSpellLevel = SpellTable.MAGIC_USER_MAX_SPELL_LEVEL[SpellTable.MAGIC_USER_MAX_SPELL_LEVEL.length - 1];
            }
            else {
                maxSpellLevel = SpellTable.MAGIC_USER_MAX_SPELL_LEVEL[casterLevel - 1];
            }
        }
        else {
            if (casterLevel > SpellTable.ILLUSIONIST_MAX_SPELL_LEVEL.length) {
                maxSpellLevel = SpellTable.ILLUSIONIST_MAX_SPELL_LEVEL[SpellTable.ILLUSIONIST_MAX_SPELL_LEVEL.length - 1];
            }
            else {
                maxSpellLevel = SpellTable.ILLUSIONIST_MAX_SPELL_LEVEL[casterLevel - 1];
            }
        }

        // Magic-User maximum spell level is limited by Intelligence
        // Illusionist minimum qualifying Intelligence is enough to cast their highest level spells
        if (casterClass.equals(SpellTable.SPELL_BOOK_CLASSES[0])) {
            if (intelligenceScorePosition == 0) { // 9
                if (maxSpellLevel > 4) {
                    maxSpellLevel = 4;
                }
            }
            else if (intelligenceScorePosition == 1 || intelligenceScorePosition == 2) { // 10 - 11
                if (maxSpellLevel > 5) {
                    maxSpellLevel = 5;
                }
            }
            else if (intelligenceScorePosition == 3 || intelligenceScorePosition == 4) { // 12 - 13
                if (maxSpellLevel > 6) {
                    maxSpellLevel = 6;
                }
            }
            else if (intelligenceScorePosition == 5 || intelligenceScorePosition == 6) { // 14 - 15
                if (maxSpellLevel > 7) {
                    maxSpellLevel = 7;
                }
            }
            else if (intelligenceScorePosition == 7 || intelligenceScorePosition == 8) { // 16 - 17
                if (maxSpellLevel > 8) {
                    maxSpellLevel = 8;
                }
            }
        }

        return maxSpellLevel;
    }

    private Set<String> generateStartingSpells(String casterClass) {
        Set<String> startingSpells = new HashSet<>();
        Roll roll;
        int value;

        if (casterClass.equals(SpellTable.SPELL_BOOK_CLASSES[0])) {
            startingSpells.add(SpellTable.MAGIC_USER_AUTO);

            roll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_OFFENSIVE.length);
            value = roll.getTotal() - 1;
            startingSpells.add(SpellTable.MAGIC_USER_OFFENSIVE[value]);

            roll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_DEFENSIVE.length);
            value = roll.getTotal() - 1;
            startingSpells.add(SpellTable.MAGIC_USER_DEFENSIVE[value]);

            roll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_MISC.length);
            value = roll.getTotal() - 1;
            startingSpells.add(SpellTable.MAGIC_USER_MISC[value]);
        }
        else {
            startingSpells.add(SpellTable.ILLUSIONIST_AUTO);

            roll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_OFFENSIVE.length);
            value = roll.getTotal() - 1;
            startingSpells.add(SpellTable.ILLUSIONIST_OFFENSIVE[value]);

            roll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_DEFENSIVE.length);
            value = roll.getTotal() - 1;
            startingSpells.add(SpellTable.ILLUSIONIST_DEFENSIVE[value]);

            roll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_MISC.length);
            value = roll.getTotal() - 1;
            startingSpells.add(SpellTable.ILLUSIONIST_MISC[value]);
        }

        return startingSpells;
    }

    private int getSpellCount(int spellLevel, String casterClass, int casterLevel, int intelligenceScorePosition) {
        int spellCount = SpellTable.MIN_NUMBER_SPELLS[0];

        if (casterLevel > 1) {
            int spellCountMin = SpellTable.MIN_NUMBER_SPELLS[intelligenceScorePosition];
            int spellCountMax;

            spellCount = spellCountMin;

            // SPECIAL CASE: a 19 or higher Intelligence score gives access to all spells
            if (intelligenceScorePosition == SpellTable.INTELLIGENCE_SCORE.length - 1) {
                // Determine what "all" means for each spell level
                spellCountMax = getTotalSpellCount(spellLevel, casterClass);
            }
            else {
                // Determine which is lower: max spells allowed by Intelligence score or total number of spells
                spellCountMax = getCasterMaximumSpellCount(SpellTable.MAX_NUMBER_SPELLS[intelligenceScorePosition],
                        spellLevel, casterClass);
            }

            // Randomize the actual number of spells for this level
            int sides = (spellCountMax - spellCountMin) + 1;
            Roll roll = this.diceRollGenerator.roll(1, sides);
            int value = roll.getTotal() - 1;

            spellCount = spellCount + value;

            if (spellCount > spellCountMax) {
                spellCount = spellCountMax;
            }
        }

        return spellCount;
    }

    private int getCasterMaximumSpellCount(int currentMax, int spellLevel, String casterClass) {
        int spellCountMax = currentMax;

        if (casterClass.equals(SpellTable.SPELL_BOOK_CLASSES[0])) {
            if (spellLevel == 1) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_1.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_1.length;
                }
            }
            else if (spellLevel == 2) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_2.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_2.length;
                }
            }
            else if (spellLevel == 3) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_3.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_3.length;
                }
            }
            else if (spellLevel == 4) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_4.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_4.length;
                }
            }
            else if (spellLevel == 5) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_5.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_5.length;
                }
            }
            else if (spellLevel == 6) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_6.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_6.length;
                }
            }
            else if (spellLevel == 7) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_7.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_7.length;
                }
            }
            else if (spellLevel == 8) {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_8.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_8.length;
                }
            }
            else {
                if (currentMax > SpellTable.MAGIC_USER_LEVEL_9.length) {
                    spellCountMax = SpellTable.MAGIC_USER_LEVEL_9.length;
                }
            }
        }
        else {
            if (spellLevel == 1) {
                if (currentMax > SpellTable.ILLUSIONIST_LEVEL_1.length) {
                    spellCountMax = SpellTable.ILLUSIONIST_LEVEL_1.length;
                }
            }
            else if (spellLevel == 2) {
                if (currentMax > SpellTable.ILLUSIONIST_LEVEL_2.length) {
                    spellCountMax = SpellTable.ILLUSIONIST_LEVEL_2.length;
                }
            }
            else if (spellLevel == 3) {
                if (currentMax > SpellTable.ILLUSIONIST_LEVEL_3.length) {
                    spellCountMax = SpellTable.ILLUSIONIST_LEVEL_3.length;
                }
            }
            else if (spellLevel == 4) {
                if (currentMax > SpellTable.ILLUSIONIST_LEVEL_4.length) {
                    spellCountMax = SpellTable.ILLUSIONIST_LEVEL_4.length;
                }
            }
            else if (spellLevel == 5) {
                if (currentMax > SpellTable.ILLUSIONIST_LEVEL_5.length) {
                    spellCountMax = SpellTable.ILLUSIONIST_LEVEL_5.length;
                }
            }
            else if (spellLevel == 6) {
                if (currentMax > SpellTable.ILLUSIONIST_LEVEL_6.length) {
                    spellCountMax = SpellTable.ILLUSIONIST_LEVEL_6.length;
                }
            }
            else {
                if (currentMax > SpellTable.ILLUSIONIST_LEVEL_7.length) {
                    spellCountMax = SpellTable.ILLUSIONIST_LEVEL_7.length;
                }
            }
        }

        return spellCountMax;
    }

    private int getTotalSpellCount(int spellLevel, String casterClass) {
        int spellCountMax;

        if (casterClass.equals(SpellTable.SPELL_BOOK_CLASSES[0])) {
            if (spellLevel == 1) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_1.length;
            }
            else if (spellLevel == 2) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_2.length;
            }
            else if (spellLevel == 3) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_3.length;
            }
            else if (spellLevel == 4) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_4.length;
            }
            else if (spellLevel == 5) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_5.length;
            }
            else if (spellLevel == 6) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_6.length;
            }
            else if (spellLevel == 7) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_7.length;
            }
            else if (spellLevel == 8) {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_8.length;
            }
            else {
                spellCountMax = SpellTable.MAGIC_USER_LEVEL_9.length;
            }
        }
        else {
            if (spellLevel == 1) {
                spellCountMax = SpellTable.ILLUSIONIST_LEVEL_1.length;
            }
            else if (spellLevel == 2) {
                spellCountMax = SpellTable.ILLUSIONIST_LEVEL_2.length;
            }
            else if (spellLevel == 3) {
                spellCountMax = SpellTable.ILLUSIONIST_LEVEL_3.length;
            }
            else if (spellLevel == 4) {
                spellCountMax = SpellTable.ILLUSIONIST_LEVEL_4.length;
            }
            else if (spellLevel == 5) {
                spellCountMax = SpellTable.ILLUSIONIST_LEVEL_5.length;
            }
            else if (spellLevel == 6) {
                spellCountMax = SpellTable.ILLUSIONIST_LEVEL_6.length;
            }
            else {
                spellCountMax = SpellTable.ILLUSIONIST_LEVEL_7.length;
            }
        }

        return spellCountMax;
    }
}
