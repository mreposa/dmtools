package org.mreposa.dmtools.model.adnd.playerclass;

public class CavalierPaladin extends PlayerCharacterClass {
    public CavalierPaladin() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_INT] = 10;
        minimums[STAT_WIS] = 13;
        minimums[STAT_DEX] = 15;
        minimums[STAT_CON] = 15;
        minimums[STAT_CHA] = 17;
        return minimums;
    }
}
