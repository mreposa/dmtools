package org.mreposa.dmtools.model.adnd.treasure;

public class TTF extends TreasureType {
    public TTF() {
        super();

        Treasure sp = new Treasure();
        sp.setAmount(20);
        sp.setMultiplier(1000);
        sp.setChance(10);
        sp.setType("sp");
        this.treasureList.add(sp);

        Treasure ep = new Treasure();
        ep.setAmount(12);
        ep.setMultiplier(1000);
        ep.setChance(15);
        ep.setType("ep");
        this.treasureList.add(ep);

        Treasure gp = new Treasure();
        gp.setAmount(10);
        gp.setMultiplier(1000);
        gp.setChance(40);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure pp = new Treasure();
        pp.setAmount(8);
        pp.setMultiplier(100);
        pp.setChance(35);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setNumber(3);
        gems.setAmount(10);
        gems.setChance(20);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(10);
        jewelry.setChance(10);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(30);
        magic.setType("any 3 magic items (except swords or misc. weapons) + 1 potion + 1 scroll");
        this.treasureList.add(magic);
    }
}
