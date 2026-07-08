package org.mreposa.dmtools.model.adnd.playerclass;

public class MagicUser extends PlayerCharacterClass {
    public MagicUser() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_INT] = 9;
        minimums[STAT_DEX] = 6;
        return minimums;
    }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_INT;
        priorities[1] = STAT_DEX;
        priorities[2] = STAT_CON;
        priorities[3] = STAT_WIS;
        priorities[4] = STAT_STR;
        priorities[5] = STAT_CHA;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
