package org.mreposa.dmtools.model.adnd.treasure;

public class TTA extends TreasureType {

    public TTA() {
        super();

        Treasure cp = new Treasure();
        cp.setAmount(6);
        cp.setMultiplier(1000);
        cp.setChance(25);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(6);
        sp.setMultiplier(1000);
        sp.setChance(30);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setAmount(6);
        ep.setMultiplier(1000);
        ep.setChance(35);
        ep.setType("ep");
        this.treasureList.add(ep);

        Treasure gp = new Treasure();
        gp.setAmount(10);
        gp.setMultiplier(1000);
        gp.setChance(40);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure pp = new Treasure();
        pp.setAmount(4);
        pp.setMultiplier(100);
        pp.setChance(25);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setNumber(4);
        gems.setAmount(10);
        gems.setChance(60);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setNumber(3);
        jewelry.setAmount(10);
        jewelry.setChance(50);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(30);
        magic.setType("any 3 magic items");
        this.treasureList.add(magic);
    }
}
