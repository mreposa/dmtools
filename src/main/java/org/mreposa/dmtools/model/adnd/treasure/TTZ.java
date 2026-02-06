package org.mreposa.dmtools.model.adnd.treasure;

public class TTZ extends TreasureType {

    public TTZ() {
        super();

        Treasure cp = new Treasure();
        cp.setAmount(3);
        cp.setMultiplier(1000);
        cp.setChance(20);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(4);
        sp.setMultiplier(1000);
        sp.setChance(25);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setAmount(4);
        ep.setMultiplier(1000);
        ep.setChance(25);
        ep.setType("ep");
        this.treasureList.add(ep);

        Treasure gp = new Treasure();
        gp.setAmount(4);
        gp.setMultiplier(1000);
        gp.setChance(30);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure pp = new Treasure();
        pp.setAmount(6);
        pp.setMultiplier(100);
        pp.setChance(30);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setNumber(10);
        gems.setAmount(6);
        gems.setChance(55);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setNumber(5);
        jewelry.setAmount(6);
        jewelry.setChance(50);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(50);
        magic.setType("any 3 magic items");
        this.treasureList.add(magic);
    }
}
