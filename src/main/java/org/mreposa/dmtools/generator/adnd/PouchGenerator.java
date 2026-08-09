package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.treasure.*;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PouchGenerator {
    public static final int LG_POUCH_CAP = 50;
    public static final int SM_POUCH_CAP = 25;

    private final DiceRollGenerator diceRollGenerator;
    private final ArrayList<String> coinTypes = new ArrayList<>(Arrays.asList("cp", "sp", "ep", "gp", "pp"));

    public PouchGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public PouchGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public PouchContents generate(int maxCoins, boolean includeOddsAndEnds) {
        PouchContents pouchContents = new PouchContents();

        if (maxCoins > LG_POUCH_CAP) {
            maxCoins = LG_POUCH_CAP;
        }
        else if (maxCoins < SM_POUCH_CAP) {
            maxCoins = SM_POUCH_CAP;
        }

        if  (includeOddsAndEnds) {
            List<String> oddsAndEnds = generateOddAndEnds();
            pouchContents.setOddsAndEnds(oddsAndEnds);

            // Make some room in the pouch for these items
            maxCoins = maxCoins - oddsAndEnds.size();
        }

        ArrayList<GeneratedTreasure> coinList = new ArrayList<>();
        GeneratedTreasure genTreasure;
        Roll roll;
        int amount;

        for (String coinType : this.coinTypes) {
            if (maxCoins > 0) {
                roll = this.diceRollGenerator.roll(1, maxCoins);
                amount = roll.getTotal();

                if (amount > maxCoins) {
                    amount = maxCoins;
                }

                genTreasure = new GeneratedTreasure();
                genTreasure.setAmount(amount);
                genTreasure.setType(coinType);

                coinList.add(genTreasure);

                maxCoins = maxCoins - amount;
            }
            else {
                break;
            }
        }

        pouchContents.setCoins(coinList);

        return pouchContents;
    }

    public List<String> generateOddAndEnds() {
        ArrayList<String> junkList = new ArrayList<>();

        Roll roll = this.diceRollGenerator.roll(1, 8);
        int amount = roll.getTotal() - 1;
        int value;
        String item;

        for (int i = 0; i < amount; i++) {
            roll = this.diceRollGenerator.roll(1, 100);
            value = roll.getTotal();

            if (value == 1) {
                item = "animal bone";
            }
            else if (value == 2) {
                item = "animal claw";
            }
            else if (value == 3) {
                item = "animal tooth";
            }
            else if (value == 4) {
                item = "azurite (10 gp)";
            }
            else if (value == 5) {
                item = "ball of twine";
            }
            else if (value == 6) {
                item = "bone pendant";
            }
            else if (value == 7) {
                item = "bone ring";
            }
            else if (value == 8) {
                item = "bone six-sided die";
            }
            else if (value == 9) {
                item = "bone whistle";
            }
            else if (value == 10) {
                item = "braided cloth bracelet";
            }
            else if (value == 11) {
                item = "brass bell";
            }
            else if (value == 12) {
                item = "brass buckle";
            }
            else if (value == 13) {
                item = "brass button";
            }
            else if (value == 14) {
                item = "brass figurine";
            }
            else if (value == 15) {
                item = "brass hinge";
            }
            else if (value == 16) {
                item = "brass incense holder";
            }
            else if (value == 17) {
                item = "brass locket";
            }
            else if (value == 18) {
                item = "brass pendant";
            }
            else if (value == 19) {
                item = "brass ring";
            }
            else if (value == 20) {
                item = "brass scale weight";
            }
            else if (value == 21) {
                item = "brass signet ring";
            }
            else if (value == 22) {
                item = "brass whistle";
            }
            else if (value == 23) {
                item = "bread heel";
            }
            else if (value == 24) {
                item = "bronze medallion";
            }
            else if (value == 25) {
                item = "candle stub";
            }
            else if (value == 26) {
                item = "carved wooden box";
            }
            else if (value == 27) {
                item = "carved wooden bracelet";
            }
            else if (value == 28) {
                item = "carved wooden pendant";
            }
            else if (value == 29) {
                item = "chalk";
            }
            else if (value == 30) {
                item = "charcoal chunk";
            }
            else if (value == 31) {
                item = "charcoal pencil";
            }
            else if (value == 32) {
                item = "clay figurine";
            }
            else if (value == 33) {
                item = "clay smoking pipe";
            }
            else if (value == 34) {
                item = "cooking herbs packet";
            }
            else if (value == 35) {
                item = "cork";
            }
            else if (value == 36) {
                item = "crystal pendant";
            }
            else if (value == 37) {
                item = "crystal prism";
            }
            else if (value == 38) {
                item = "deck of cards";
            }
            else if (value == 39) {
                item = "dried apple";
            }
            else if (value == 40) {
                item = "dried meat slab";
            }
            else if (value == 41) {
                item = "dried mushroom";
            }
            else if (value == 42) {
                item = "dried pepper";
            }
            else if (value == 43) {
                item = "eye agate (10 gp)";
            }
            else if (value == 44) {
                item = "flint and steel";
            }
            else if (value == 45) {
                item = "garlic head";
            }
            else if (value == 46) {
                item = "glass marble";
            }
            else if (value == 47) {
                item = "hard biscuit";
            }
            else if (value == 48) {
                item = "hard cheese chunk";
            }
            else if (value == 49) {
                item = "hematite (10 gp)";
            }
            else if (value == 50) {
                item = "horn button";
            }
            else if (value == 51) {
                item = "horn comb";
            }
            else if (value == 52) {
                item = "horn ring";
            }
            else if (value == 53) {
                item = "iron brooch";
            }
            else if (value == 54) {
                item = "iron fork";
            }
            else if (value == 55) {
                item = "iron key";
            }
            else if (value == 56) {
                item = "iron locket";
            }
            else if (value == 57) {
                item = "iron nail";
            }
            else if (value == 58) {
                item = "iron pendant";
            }
            else if (value == 59) {
                item = "iron ring";
            }
            else if (value == 60) {
                item = "iron ring puzzle";
            }
            else if (value == 61) {
                item = "iron scale weight";
            }
            else if (value == 62) {
                item = "iron spoon";
            }
            else if (value == 63) {
                item = "leather boot lace";
            }
            else if (value == 64) {
                item = "malachite (10 gp)";
            }
            else if (value == 65) {
                item = "moss agate (10 gp)";
            }
            else if (value == 66) {
                item = "pewter figurine";
            }
            else if (value == 67) {
                item = "pewter thimble";
            }
            else if (value == 68) {
                item = "polished stone";
            }
            else if (value == 69) {
                item = "poultice herbs packet";
            }
            else if (value == 70) {
                item = "pumice chunk";
            }
            else if (value == 71) {
                item = "pyrite chunk";
            }
            else if (value == 72) {
                item = "rock candy chunk";
            }
            else if (value == 73) {
                item = "rock salt chunk";
            }
            else if (value == 74) {
                item = "roll of ribbon";
            }
            else if (value == 75) {
                item = "sap";
            }
            else if (value == 76) {
                item = "seed packet";
            }
            else if (value == 77) {
                item = "shell";
            }
            else if (value == 78) {
                item = "small brass lock with key";
            }
            else if (value == 79) {
                item = "smoking herbs packet";
            }
            else if (value == 80) {
                item = "smooth wooden disk";
            }
            else if (value == 81) {
                item = "snuff box";
            }
            else if (value == 82) {
                item = "spool of thread";
            }
            else if (value == 83) {
                item = "square clay tile";
            }
            else if (value == 84) {
                item = "stick of wax";
            }
            else if (value == 85) {
                item = "sulphur chunk";
            }
            else if (value == 86) {
                item = "thin leather strip";
            }
            else if (value == 87) {
                item = "tiger eye (10 gp)";
            }
            else if (value == 88) {
                item = "turquoise (10 gp)";
            }
            else if (value == 89) {
                item = "uncarved wood chunk";
            }
            else if (value == 90) {
                item = "whet stone";
            }
            else if (value == 91) {
                item = "wood carving";
            }
            else if (value == 92) {
                item = "wooden brooch";
            }
            else if (value == 93) {
                item = "wooden cube puzzle";
            }
            else if (value == 94) {
                item = "wooden fork";
            }
            else if (value == 95) {
                item = "wooden game piece";
            }
            else if (value == 96) {
                item = "wooden hair pin";
            }
            else if (value == 97) {
                item = "wooden incense holder";
            }
            else if (value == 98) {
                item = "wooden measuring spoon";
            }
            else if (value == 99) {
                item = "wooden smoking pipe";
            }
            else {
                item = "wooden spoon";
            }

            junkList.add(item);
        }

        return junkList;
    }
}
