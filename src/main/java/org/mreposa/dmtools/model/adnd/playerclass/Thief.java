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

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_DEX;
        priorities[1] = STAT_CON;
        priorities[2] = STAT_STR;
        priorities[3] = STAT_WIS;
        priorities[4] = STAT_INT;
        priorities[5] = STAT_CHA;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
