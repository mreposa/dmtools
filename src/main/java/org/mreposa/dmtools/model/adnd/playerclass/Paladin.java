package org.mreposa.dmtools.model.adnd.playerclass;

public class Paladin extends PlayerCharacterClass {
    public Paladin() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 12;
        minimums[STAT_INT] = 9;
        minimums[STAT_WIS] = 13;
        minimums[STAT_CON] = 9;
        minimums[STAT_CHA] = 17;
        return minimums;
    }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_CHA;
        priorities[1] = STAT_WIS;
        priorities[2] = STAT_STR;
        priorities[3] = STAT_CON;
        priorities[4] = STAT_INT;
        priorities[5] = STAT_DEX;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
