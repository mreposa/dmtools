package org.mreposa.dmtools.model.adnd.treasure;

public class TTK extends TreasureType {

    public TTK() {
        super();

        Treasure sp = new Treasure();
        sp.setNumber(3);
        sp.setAmount(6);
        sp.setChance(100);
        sp.setType("sp");
        this.treasureList.add(sp);
    }
}
