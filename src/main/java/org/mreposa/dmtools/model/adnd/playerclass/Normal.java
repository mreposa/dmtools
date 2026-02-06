package org.mreposa.dmtools.model.adnd.playerclass;

public class Normal extends PlayerCharacterClass {
    public Normal() {
        super();
    }

    @Override
    public int[] getUpdates() {
        return updates;
    }

    @Override
    public int[] getMinimums() { return minimums; }
}
