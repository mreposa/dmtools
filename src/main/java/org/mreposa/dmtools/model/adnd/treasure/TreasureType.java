package org.mreposa.dmtools.model.adnd.treasure;

import java.util.ArrayList;
import java.util.List;

public abstract class TreasureType {
    public static final String[] TREASURE_TYPES = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    protected final List<Treasure> treasureList;

    public TreasureType() {
        this.treasureList = new ArrayList<>();
    }

    public List<Treasure> getTreasureList() {
        return this.treasureList;
    }
}
