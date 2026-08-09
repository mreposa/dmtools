package org.mreposa.dmtools.model.adnd.treasure;

import java.util.ArrayList;
import java.util.List;

public class PouchContents {
    List<GeneratedTreasure> coins = new ArrayList<GeneratedTreasure>();
    List<String> oddsAndEnds = new ArrayList<>();

    public List<GeneratedTreasure> getCoins() {
        return coins;
    }

    public void setCoins(List<GeneratedTreasure> coins) {
        this.coins.addAll(0, coins);
    }

    public List<String> getOddsAndEnds() {
        return oddsAndEnds;
    }

    public void setOddsAndEnds(List<String> oddsAndEnds) {
        this.oddsAndEnds.addAll(0, oddsAndEnds);
    }
}
