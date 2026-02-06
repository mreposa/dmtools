package org.mreposa.dmtools.model.adnd.treasure;

public class TTV extends TreasureType {

    public TTV() {
        super();

        Treasure magic = new Treasure();
        magic.setChance(85);
        magic.setType("2 of each magic item (excluding potions and scrolls)");
        this.treasureList.add(magic);
    }
}
