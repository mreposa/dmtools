package org.mreposa.dmtools.model.adnd.treasure;

public class TTD extends TreasureType {
    public TTD() {
        super();

        Treasure cp = new Treasure();
        cp.setAmount(8);
        cp.setMultiplier(1000);
        cp.setChance(10);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(12);
        sp.setMultiplier(1000);
        sp.setChance(15);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setAmount(8);
        ep.setMultiplier(1000);
        ep.setChance(15);
        ep.setType("ep");
        this.treasureList.add(ep);

        Treasure gp = new Treasure();
        gp.setAmount(6);
        gp.setMultiplier(1000);
        gp.setChance(50);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure gems = new Treasure();
        gems.setAmount(10);
        gems.setChance(30);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(6);
        jewelry.setChance(25);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(15);
        magic.setType("any 2 magic items + 1 potion");
        this.treasureList.add(magic);
    }
}
