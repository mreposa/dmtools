package org.mreposa.dmtools.model.adnd.treasure;

public class TTY extends TreasureType {

    public TTY() {
        super();

        Treasure gp = new Treasure();
        gp.setNumber(2);
        gp.setAmount(6);
        gp.setMultiplier(1000);
        gp.setChance(70);
        gp.setType("gp");
        this.treasureList.add(gp);
    }
}
