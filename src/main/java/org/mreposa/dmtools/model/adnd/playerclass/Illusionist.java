package org.mreposa.dmtools.model.adnd.playerclass;

public class Illusionist extends PlayerCharacterClass {
    public Illusionist() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_INT] = 15;
        minimums[STAT_DEX] = 16;
        return minimums;
    }
}
