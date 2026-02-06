package org.mreposa.dmtools.model.adnd.treasure;

public class TTW extends TreasureType {

    public TTW() {
        super();

        Treasure gp = new Treasure();
        gp.setNumber(5);
        gp.setAmount(6);
        gp.setMultiplier(1000);
        gp.setChance(60);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure pp = new Treasure();
        pp.setAmount(8);
        pp.setMultiplier(100);
        pp.setChance(15);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setNumber(10);
        gems.setAmount(8);
        gems.setChance(60);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setNumber(5);
        jewelry.setAmount(8);
        jewelry.setChance(50);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(55);
        magic.setType("1 map");
        this.treasureList.add(magic);
    }
}
