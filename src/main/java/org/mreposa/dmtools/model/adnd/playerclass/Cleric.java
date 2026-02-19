package org.mreposa.dmtools.model.adnd.playerclass;

public class Cleric extends PlayerCharacterClass {
    public Cleric() { super(); }

    @Override
    public int[] getMinimums() {
        minimums[STAT_WIS] = 9;
        return minimums;
    }
}
