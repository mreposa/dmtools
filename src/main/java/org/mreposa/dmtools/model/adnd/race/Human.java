package org.mreposa.dmtools.model.adnd.race;

public class Human extends PlayerCharacterRace {
    public Human() { super(); }

    @Override
    public int[] getUpdates() {
        return updates;
    }

    public int[] getMinimums() {
        return minimums;
    }
}
