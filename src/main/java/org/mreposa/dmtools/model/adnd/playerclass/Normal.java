package org.mreposa.dmtools.model.adnd.playerclass;

public class Normal extends PlayerCharacterClass {
    public Normal() {
        super();
    }

    @Override
    public int[] getMinimums() { return minimums; }

    @Override
    public int[] getPriorities() {
        priorities[0] = STAT_CON;
        priorities[1] = STAT_DEX;
        priorities[2] = STAT_STR;
        priorities[3] = STAT_CHA;
        priorities[4] = STAT_WIS;
        priorities[5] = STAT_INT;
        priorities[6] = STAT_COM;
        priorities[7] = STAT_EX_STR;
        return priorities;
    }
}
