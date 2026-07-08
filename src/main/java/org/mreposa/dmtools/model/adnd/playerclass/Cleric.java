package org.mreposa.dmtools.model.adnd.playerclass;

public class Cleric extends PlayerCharacterClass {
    public Cleric() { super(); }

    @Override
    public int[] getMinimums() {
        minimums[STAT_WIS] = 9;
        return minimums;
    }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_WIS;
        priorities[1] = STAT_STR;
        priorities[2] = STAT_CON;
        priorities[3] = STAT_CHA;
        priorities[4] = STAT_DEX;
        priorities[5] = STAT_INT;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
