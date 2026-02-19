package org.mreposa.dmtools.model.adnd.playerclass;

public class Fighter extends PlayerCharacterClass {
    public Fighter() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 9;
        minimums[STAT_CON] = 7;
        return minimums;
    }
}
