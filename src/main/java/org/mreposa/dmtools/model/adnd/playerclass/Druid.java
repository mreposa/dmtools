package org.mreposa.dmtools.model.adnd.playerclass;

public class Druid extends PlayerCharacterClass {
    public Druid() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_WIS] = 12;
        minimums[STAT_CHA] = 15;
        return minimums;
    }
}
