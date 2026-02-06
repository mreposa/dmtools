package org.mreposa.dmtools.model.adnd.treasure;

public class TTG extends TreasureType {
    public TTG() {
        super();

        Treasure gp = new Treasure();
        gp.setNumber(10);
        gp.setAmount(4);
        gp.setMultiplier(1000);
        gp.setChance(50);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure pp = new Treasure();
        pp.setAmount(4);
        pp.setMultiplier(100);
        pp.setChance(25);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setNumber(5);
        gems.setAmount(4);
        gems.setChance(30);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(10);
        jewelry.setChance(25);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(35);
        magic.setType("any 4 magic items + 1 scroll");
        this.treasureList.add(magic);
    }
}
