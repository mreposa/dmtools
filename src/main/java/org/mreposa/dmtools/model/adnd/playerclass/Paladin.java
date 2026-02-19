package org.mreposa.dmtools.model.adnd.playerclass;

public class Paladin extends PlayerCharacterClass {
    public Paladin() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 12;
        minimums[STAT_INT] = 9;
        minimums[STAT_WIS] = 13;
        minimums[STAT_CON] = 9;
        minimums[STAT_CHA] = 17;
        return minimums;
    }
}
