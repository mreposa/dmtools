package org.mreposa.dmtools.model.adnd.treasure;

public class TTU extends TreasureType {

    public TTU() {
        super();

        Treasure gems = new Treasure();
        gems.setNumber(10);
        gems.setAmount(8);
        gems.setChance(90);
        gems.setType("gems");
        this.treasureList.add(gems);

        Treasure jewelry = new Treasure();
        jewelry.setNumber(5);
        jewelry.setAmount(6);
        jewelry.setChance(80);
        jewelry.setType("jewelry");
        this.treasureList.add(jewelry);

        Treasure magic = new Treasure();
        magic.setChance(70);
        magic.setType("1 of each magic item (excluding potions and scrolls)");
        this.treasureList.add(magic);
    }
}
