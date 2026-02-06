package org.mreposa.dmtools.model.adnd.treasure;

public class TTX extends TreasureType {

    public TTX() {
        super();

        Treasure magic = new Treasure();
        magic.setChance(60);
        magic.setType("1 misc. magic item + 1 potion");
        this.treasureList.add(magic);
    }
}
