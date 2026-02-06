package org.mreposa.dmtools.model.adnd.treasure;

public class TTO extends TreasureType {

    public TTO() {
        super();

        Treasure cp = new Treasure();
        cp.setAmount(4);
        cp.setMultiplier(1000);
        cp.setChance(25);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(3);
        sp.setMultiplier(1000);
        sp.setChance(20);
        sp.setType("sp");
        this.treasureList.add(sp);
    }
}
