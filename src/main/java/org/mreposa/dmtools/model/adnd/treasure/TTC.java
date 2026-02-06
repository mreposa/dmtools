package org.mreposa.dmtools.model.adnd.treasure;

public class TTC extends TreasureType {
    public TTC() {
        super();

        Treasure cp = new Treasure();
        cp.setAmount(12);
        cp.setMultiplier(1000);
        cp.setChance(20);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(6);
        sp.setMultiplier(1000);
        sp.setChance(30);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setAmount(4);
        ep.setMultiplier(1000);
        ep.setChance(10);
        ep.setType("ep");
        this.treasureList.add(ep);

        Treasure gems = new Treasure();
        gems.setAmount(6);
        gems.setChance(25);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(3);
        jewelry.setChance(20);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(10);
        magic.setType("any 2 magic items");
        this.treasureList.add(magic);
    }
}
