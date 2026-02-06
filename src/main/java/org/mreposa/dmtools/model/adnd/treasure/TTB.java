package org.mreposa.dmtools.model.adnd.treasure;

public class TTB extends TreasureType {
    public TTB() {
        super();

        Treasure cp = new Treasure();
        cp.setAmount(8);
        cp.setMultiplier(1000);
        cp.setChance(50);
        cp.setType("cp");
        this.treasureList.add(cp);

        Treasure sp = new Treasure();
        sp.setAmount(6);
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
        gp.setAmount(3);
        gp.setMultiplier(1000);
        gp.setChance(25);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure gems = new Treasure();
        gems.setAmount(8);
        gems.setChance(30);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(4);
        jewelry.setChance(20);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(10);
        magic.setType("magic sword, armor, or misc. weapon");
        this.treasureList.add(magic);
    }
}
