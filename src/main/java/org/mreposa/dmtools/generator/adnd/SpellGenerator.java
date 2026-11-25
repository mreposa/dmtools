package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.spells.SpellTable;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellGenerator {
    private final DiceRollGenerator diceRollGenerator;

    public SpellGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public SpellGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public Set<String> generate(int count, int level, String casterClass) {
        Set<String> spellList = new HashSet<>();
        String spell;
        int s = 0;
        boolean found = false;

        while (s < count) {
            spell = getSpell(level, casterClass);

            while (spellList.contains(spell)) {
                spell = getSpell(level, casterClass);
            }

            // Special Case: An Illusionist may only choose "First Level Magic-User Spells" once
            while (casterClass.equals(SpellTable.SPELL_CLASSES[3]) && level == 7 && spell.startsWith("first level")) {
                // Check if "first level magic-user spells" is already in the list
                for (String sp : spellList) {
                    if (sp.startsWith("first level")) {
                        found = true;
                        break;
                    }
                }

                if (found) {
                    // If it's in the list, choose a new spell and test it
                    spell = getSpell(level, casterClass);
                }
                else {
                    break;
                }
            }

            spellList.add(spell);
            s++;
        }

        return spellList;
    }

    // This is used when generating a spell book, which comes with starting first level spells
    public Set<String> generateAdditionalFirstLevelSpells(int count, String casterClass, Set<String> spellList) {
        int level = 1;
        int s = spellList.size();

        String spell;
        while (s < count) {
            spell = getSpell(level, casterClass);

            while (!spellList.add(spell)) {
                spell = getSpell(level, casterClass);
            }

            s++;
        }

        return spellList;
    }

    public String getSpell(int level, String casterClass) {
        String spell;
        Roll dieRoll;
        int value;

        if (casterClass.equals(SpellTable.SPELL_CLASSES[0])) {
            // Magic-User
            if (level == 1) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_1.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_1[value];
            }
            else if (level == 2) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_2.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_2[value];
            }
            else if (level == 3) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_3.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_3[value];
            }
            else if (level == 4) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_4.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_4[value];
            }
            else if (level == 5) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_5.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_5[value];
            }
            else if (level == 6) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_6.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_6[value];
            }
            else if (level == 7) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_7.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_7[value];
            }
            else if (level == 8) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_8.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_8[value];
            }
            else {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.MAGIC_USER_LEVEL_9.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.MAGIC_USER_LEVEL_9[value];
            }
        }
        else if (casterClass.equals(SpellTable.SPELL_CLASSES[1])) {
            // Cleric
            if (level == 1) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.CLERIC_LEVEL_1.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.CLERIC_LEVEL_1[value];
            }
            else if (level == 2) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.CLERIC_LEVEL_2.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.CLERIC_LEVEL_2[value];
            }
            else if (level == 3) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.CLERIC_LEVEL_3.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.CLERIC_LEVEL_3[value];
            }
            else if (level == 4) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.CLERIC_LEVEL_4.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.CLERIC_LEVEL_4[value];
            }
            else if (level == 5) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.CLERIC_LEVEL_5.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.CLERIC_LEVEL_5[value];
            }
            else if (level == 6) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.CLERIC_LEVEL_6.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.CLERIC_LEVEL_6[value];
            }
            else {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.CLERIC_LEVEL_7.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.CLERIC_LEVEL_7[value];
            }
        }
        else if (casterClass.equals(SpellTable.SPELL_CLASSES[2])) {
            // Druid
            if (level == 1) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.DRUID_LEVEL_1.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.DRUID_LEVEL_1[value];
            }
            else if (level == 2) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.DRUID_LEVEL_2.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.DRUID_LEVEL_2[value];
            }
            else if (level == 3) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.DRUID_LEVEL_3.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.DRUID_LEVEL_3[value];
            }
            else if (level == 4) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.DRUID_LEVEL_4.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.DRUID_LEVEL_4[value];
            }
            else if (level == 5) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.DRUID_LEVEL_5.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.DRUID_LEVEL_5[value];
            }
            else if (level == 6) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.DRUID_LEVEL_6.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.DRUID_LEVEL_6[value];
            }
            else {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.DRUID_LEVEL_7.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.DRUID_LEVEL_7[value];
            }
        }
        else {
            // Illusionist
            if (level == 1) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_LEVEL_1.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.ILLUSIONIST_LEVEL_1[value];
            }
            else if (level == 2) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_LEVEL_2.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.ILLUSIONIST_LEVEL_2[value];
            }
            else if (level == 3) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_LEVEL_3.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.ILLUSIONIST_LEVEL_3[value];
            }
            else if (level == 4) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_LEVEL_4.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.ILLUSIONIST_LEVEL_4[value];
            }
            else if (level == 5) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_LEVEL_5.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.ILLUSIONIST_LEVEL_5[value];
            }
            else if (level == 6) {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_LEVEL_6.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.ILLUSIONIST_LEVEL_6[value];
            }
            else {
                dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_LEVEL_7.length);
                value = dieRoll.getTotal() - 1;

                spell = SpellTable.ILLUSIONIST_LEVEL_7[value];

                if (spell.equals(SpellTable.ILLUSIONIST_LEVEL_7[7])) {
                    // Generate four allowed 1st level Magic-User spells
                    HashSet<String> firstLevelMagicUserSpellList = new HashSet<>();
                    int count = 0;
                    String flSpell;

                    while (count < 4) {
                        dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_MU_LEVEL_1.length);
                        value = dieRoll.getTotal() - 1;

                        flSpell = SpellTable.ILLUSIONIST_MU_LEVEL_1[value];

                        while (firstLevelMagicUserSpellList.contains(flSpell)) {
                            dieRoll = this.diceRollGenerator.roll(1, SpellTable.ILLUSIONIST_MU_LEVEL_1.length);
                            value = dieRoll.getTotal() - 1;

                            flSpell = SpellTable.ILLUSIONIST_MU_LEVEL_1[value];
                        }

                        firstLevelMagicUserSpellList.add(flSpell);
                        count++;
                    }

                    spell = spell + " [";
                    count = 0;
                    for (String s : firstLevelMagicUserSpellList) {
                        spell = spell + s;
                        if (count < firstLevelMagicUserSpellList.size() - 1) {
                            spell = spell + (", ");
                        }
                        count++;
                    }
                    spell = spell + "]";
                }
            }
        }

        return spell;
    }

    public Set<String> getAllSpells(int level, String casterClass) {
        List<String> spellList = new ArrayList<>();

        if (casterClass.equals(SpellTable.SPELL_CLASSES[0])) {
            if (level == 1) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_1);
            }
            else if (level == 2) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_2);
            }
            else if (level == 3) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_3);
            }
            else if (level == 4) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_4);
            }
            else if (level == 5) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_5);
            }
            else if (level == 6) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_6);
            }
            else if (level == 7) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_7);
            }
            else if (level == 8) {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_8);
            }
            else {
                spellList = List.of(SpellTable.MAGIC_USER_LEVEL_9);
            }
        }
        else {
            if (level == 1) {
                spellList = List.of(SpellTable.ILLUSIONIST_LEVEL_1);
            }
            else if (level == 2) {
                spellList = List.of(SpellTable.ILLUSIONIST_LEVEL_2);
            }
            else if (level == 3) {
                spellList = List.of(SpellTable.ILLUSIONIST_LEVEL_3);
            }
            else if (level == 4) {
                spellList = List.of(SpellTable.ILLUSIONIST_LEVEL_4);
            }
            else if (level == 5) {
                spellList = List.of(SpellTable.ILLUSIONIST_LEVEL_5);
            }
            else if (level == 6) {
                spellList = List.of(SpellTable.ILLUSIONIST_LEVEL_6);
            }
            else  {
                spellList = List.of(SpellTable.ILLUSIONIST_LEVEL_7);
            }
        }

        return new HashSet<>(spellList);
    }
}