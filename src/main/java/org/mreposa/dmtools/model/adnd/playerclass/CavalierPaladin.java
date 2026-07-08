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

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_CHA;
        priorities[1] = STAT_STR;
        priorities[2] = STAT_CON;
        priorities[3] = STAT_DEX;
        priorities[4] = STAT_WIS;
        priorities[5] = STAT_INT;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
