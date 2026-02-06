package org.mreposa.dmtools.model.adnd.treasure;

public class TTJ extends TreasureType {

    public TTJ() {
        super();

        Treasure cp = new Treasure();
        cp.setNumber(3);
        cp.setAmount(8);
        cp.setChance(100);
        cp.setType("cp");
        this.treasureList.add(cp);
    }
}
