package org.mreposa.dmtools.model.adnd.playerclass;

public class Barbarian extends PlayerCharacterClass {
    public Barbarian() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_DEX] = 14;
        minimums[STAT_CON] = 15;
        return minimums;
    }
}
