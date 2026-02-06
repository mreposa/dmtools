package org.mreposa.dmtools.model.adnd.treasure;

public class TTS extends TreasureType {

    public TTS() {
        super();

        Treasure magic = new Treasure();
        magic.setNumber(2);
        magic.setAmount(4);
        magic.setChance(40);
        magic.setType("potions");
        this.treasureList.add(magic);
    }
}
