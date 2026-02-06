package org.mreposa.dmtools.model.adnd.treasure;

public class TTQ extends TreasureType {

    public TTQ() {
        super();

        Treasure gems = new Treasure();
        gems.setAmount(4);
        gems.setChance(50);
        gems.setType("gems");
        this.treasureList.add(gems);
    }
}
