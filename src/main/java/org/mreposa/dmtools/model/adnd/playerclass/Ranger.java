package org.mreposa.dmtools.model.adnd.playerclass;

public class Ranger extends PlayerCharacterClass {
    public Ranger() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 13;
        minimums[STAT_INT] = 13;
        minimums[STAT_WIS] = 14;
        minimums[STAT_CON] = 14;
        return minimums;
    }
}
