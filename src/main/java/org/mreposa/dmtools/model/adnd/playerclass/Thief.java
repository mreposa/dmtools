package org.mreposa.dmtools.model.adnd.playerclass;

public class Thief extends PlayerCharacterClass {
    public Thief() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_DEX] = 9;
        return minimums;
    }
}
