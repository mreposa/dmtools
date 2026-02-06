package org.mreposa.dmtools.model.adnd.treasure;

public class TTN extends TreasureType {

    public TTN() {
        super();

        Treasure pp = new Treasure();
        pp.setAmount(6);
        pp.setChance(100);
        pp.setType("pp");
        this.treasureList.add(pp);
    }
}
