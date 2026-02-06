package org.mreposa.dmtools.model.adnd.treasure;

public class TTT extends TreasureType {

    public TTT() {
        super();

        Treasure magic = new Treasure();
        magic.setAmount(4);
        magic.setChance(50);
        magic.setType("scrolls");
        this.treasureList.add(magic);
    }
}
