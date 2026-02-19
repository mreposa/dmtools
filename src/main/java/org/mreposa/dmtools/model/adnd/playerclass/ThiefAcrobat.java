package org.mreposa.dmtools.model.adnd.playerclass;

public class ThiefAcrobat extends PlayerCharacterClass {
    public ThiefAcrobat() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_DEX] = 16;
        return minimums;
    }
}
