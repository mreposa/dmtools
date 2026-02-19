package org.mreposa.dmtools.model.adnd.playerclass;

public class Assassin extends PlayerCharacterClass {
    public Assassin() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 12;
        minimums[STAT_INT] = 11;
        minimums[STAT_DEX] = 12;
        return minimums;
    }
}
