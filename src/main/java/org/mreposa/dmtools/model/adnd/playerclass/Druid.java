package org.mreposa.dmtools.model.adnd.playerclass;

public class Druid extends PlayerCharacterClass {
    public Druid() {
        super();
    }

    @Override
    public int[] getMinimums() {
        minimums[STAT_WIS] = 12;
        minimums[STAT_CHA] = 15;
        return minimums;
    }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_CHA;
        priorities[1] = STAT_WIS;
        priorities[2] = STAT_CON;
        priorities[3] = STAT_DEX;
        priorities[4] = STAT_STR;
        priorities[5] = STAT_INT;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
