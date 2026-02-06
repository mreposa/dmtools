package org.mreposa.dmtools.model.adnd.treasure;

public class TTI extends TreasureType {

    public TTI() {
        super();

        Treasure pp = new Treasure();
        pp.setNumber(3);
        pp.setAmount(6);
        pp.setMultiplier(100);
        pp.setChance(30);
        pp.setType("pp");
        this.treasureList.add(pp);

        Treasure gems = new Treasure();
        gems.setNumber(2);
        gems.setAmount(10);
        gems.setChance(55);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setAmount(12);
        jewelry.setChance(50);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(15);
        magic.setType("any 1 magic item");
        this.treasureList.add(magic);
    }
}
