package org.mreposa.dmtools.model.adnd.playerclass;

public class Monk extends PlayerCharacterClass {
    public Monk() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_WIS] = 15;
        minimums[STAT_DEX] = 15;
        minimums[STAT_CON] = 11;
        return minimums;
    }
}
