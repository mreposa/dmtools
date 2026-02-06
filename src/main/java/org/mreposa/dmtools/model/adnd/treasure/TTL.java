package org.mreposa.dmtools.model.adnd.treasure;

public class TTL extends TreasureType {

    public TTL() {
        super();

        Treasure ep = new Treasure();
        ep.setNumber(2);
        ep.setAmount(6);
        ep.setChance(100);
        ep.setType("ep");
        this.treasureList.add(ep);
    }
}
