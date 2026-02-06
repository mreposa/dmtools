package org.mreposa.dmtools.model.adnd.treasure;

public class TTH extends TreasureType {

    public TTH() {
        super();

        Treasure cp = new Treasure();
        cp.setNumber(5);
        cp.setAmount(6);
        cp.setMultiplier(1000);
        cp.setChance(25);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(100);
        sp.setMultiplier(1000);
        sp.setChance(40);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setNumber(10);
        ep.setAmount(4);
        ep.setMultiplier(1000);
        ep.setChance(40);
        ep.setType("ep");
        this.treasureList.add(ep);

        Treasure gp = new Treasure();
        gp.setNumber(10);
        gp.setAmount(6);
        gp.setMultiplier(1000);
        gp.setChance(55);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure pp = new Treasure();
        pp.setNumber(5);
        pp.setAmount(10);
        pp.setMultiplier(100);
        pp.setChance(25);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setAmount(100);
        gems.setChance(50);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setNumber(10);
        jewelry.setAmount(4);
        jewelry.setChance(50);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(15);
        magic.setType("any 4 magic items + 1 potion + 1 scroll");
        this.treasureList.add(magic);
    }
}
