package org.mreposa.dmtools.model.adnd.spells;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpellBook {
    private final int casterLevel;
    private final String casterClass;
    private final List<Set<String>> spellBook;

    public SpellBook(int casterLevel, String casterClass, int maxSpellLevel) {
        this.casterClass = casterClass;
        this.casterLevel = casterLevel;

        this.spellBook  = new ArrayList<>();

        for (int i = 0; i < maxSpellLevel; i++) {
            spellBook.add(new HashSet<>());
        }
    }

    public void addSpellList(int level, Set<String> newSpellList) throws IllegalArgumentException {
        if (level < 1 || level > this.spellBook.size()) {
            throw new IllegalArgumentException("Invalid level");
        }
        if (newSpellList == null || newSpellList.isEmpty()) {
            throw new IllegalArgumentException("Invalid spell list");
        }

        Set<String> bookSpellList = this.spellBook.get(level - 1);
        bookSpellList.clear();
        bookSpellList.addAll(newSpellList);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        int level = 1;
        int count;

        sb.append("Level ");
        sb.append(casterLevel);
        sb.append(" ");
        sb.append(casterClass);
        sb.append(" Spell Book");
        sb.append("\n\n");

        for (Set<String> spellList : this.spellBook) {
            count = 0;

            sb.append("Level ");
            sb.append(level);
            sb.append(": ");

            for (String spell : spellList) {
                sb.append(spell);
                if (count < spellList.size() - 1) {
                    sb.append(", ");
                }

                count++;
            }
            sb.append("\n");

            level++;
        }

        return sb.toString();
    }
}
