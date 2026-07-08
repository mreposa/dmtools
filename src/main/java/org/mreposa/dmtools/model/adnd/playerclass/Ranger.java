package org.mreposa.dmtools.model.adnd.playerclass;

public class Ranger extends PlayerCharacterClass {
    public Ranger() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 13;
        minimums[STAT_INT] = 13;
        minimums[STAT_WIS] = 14;
        minimums[STAT_CON] = 14;
        return minimums;
    }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_CON;
        priorities[1] = STAT_WIS;
        priorities[2] = STAT_STR;
        priorities[3] = STAT_INT;
        priorities[4] = STAT_DEX;
        priorities[5] = STAT_CHA;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
