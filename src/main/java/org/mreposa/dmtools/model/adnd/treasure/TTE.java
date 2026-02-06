package org.mreposa.dmtools.model.adnd.treasure;

public class TTE extends TreasureType {
    public TTE() {
        super();

        Treasure cp = new Treasure();
        cp.setAmount(10);
        cp.setMultiplier(1000);
        cp.setChance(5);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(12);
        sp.setMultiplier(1000);
        sp.setChance(25);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setAmount(6);
        ep.setMultiplier(1000);
        ep.setChance(25);
        ep.setType("ep");
        this.treasureList.add(ep);

        Treasure gp = new Treasure();
        gp.setAmount(8);
        gp.setMultiplier(1000);
        gp.setChance(25);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure gems = new Treasure();
        gems.setAmount(12);
        gems.setChance(15);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(8);
        jewelry.setChance(10);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(25);
        magic.setType("any 3 magic items + 1 scroll");
        this.treasureList.add(magic);
    }
}
