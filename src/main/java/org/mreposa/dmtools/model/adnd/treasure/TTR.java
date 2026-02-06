package org.mreposa.dmtools.model.adnd.treasure;

public class TTR extends TreasureType {

    public TTR() {
        super();

        Treasure gp = new Treasure();
        gp.setNumber(2);
        gp.setAmount(4);
        gp.setMultiplier(1000);
        gp.setChance(40);
        gp.setType("gp");
        this.treasureList.add(gp);

        Treasure pp = new Treasure();
        pp.setNumber(10);
        pp.setAmount(6);
        pp.setMultiplier(100);
        pp.setChance(50);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setNumber(4);
        gems.setAmount(8);
        gems.setChance(55);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(12);
        jewelry.setChance(45);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);
    }
}
