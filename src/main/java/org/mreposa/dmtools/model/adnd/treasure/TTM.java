package org.mreposa.dmtools.model.adnd.treasure;

public class TTM extends TreasureType {

    public TTM() {
        super();

        Treasure gp = new Treasure();
        gp.setNumber(2);
        gp.setAmount(4);
        gp.setChance(100);
        gp.setType("gp");
        this.treasureList.add(gp);
    }
}
