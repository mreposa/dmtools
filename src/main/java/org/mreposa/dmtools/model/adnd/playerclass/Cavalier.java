package org.mreposa.dmtools.model.adnd.playerclass;

public class Cavalier extends PlayerCharacterClass {
    public Cavalier() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_INT] = 10;
        minimums[STAT_WIS] = 10;
        minimums[STAT_DEX] = 15;
        minimums[STAT_CON] = 15;
        return minimums;
    }
}
