package org.mreposa.dmtools.model.adnd.treasure;

public class TTP extends TreasureType {

    public TTP() {
        super();

        Treasure sp = new Treasure();
        sp.setAmount(6);
        sp.setMultiplier(1000);
        sp.setChance(30);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setAmount(2);
        ep.setMultiplier(1000);
        ep.setChance(25);
        ep.setType("ep");
        this.treasureList.add(ep);
    }
}
