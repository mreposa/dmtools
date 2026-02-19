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
}
