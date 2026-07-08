package org.mreposa.dmtools.model.adnd.playerclass;

public class Assassin extends PlayerCharacterClass {
    public Assassin() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_STR] = 12;
        minimums[STAT_INT] = 11;
        minimums[STAT_DEX] = 12;
        return minimums;
    }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_DEX;
        priorities[1] = STAT_STR;
        priorities[2] = STAT_INT;
        priorities[3] = STAT_CON;
        priorities[4] = STAT_WIS;
        priorities[5] = STAT_CHA;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
