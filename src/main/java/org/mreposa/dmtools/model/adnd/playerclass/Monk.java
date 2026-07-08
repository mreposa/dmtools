package org.mreposa.dmtools.model.adnd.playerclass;

public class Monk extends PlayerCharacterClass {
    public Monk() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 15;
        minimums[STAT_WIS] = 15;
        minimums[STAT_DEX] = 15;
        minimums[STAT_CON] = 11;
        return minimums;
    }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_WIS;
        priorities[1] = STAT_DEX;
        priorities[2] = STAT_STR;
        priorities[3] = STAT_CON;
        priorities[4] = STAT_INT;
        priorities[5] = STAT_CHA;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
