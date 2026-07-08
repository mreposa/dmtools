package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.treasure.*;
import org.mreposa.dmtools.model.adnd.treasure.Treasure;
import org.mreposa.dmtools.model.adnd.treasure.GeneratedTreasure;
import org.mreposa.dmtools.model.adnd.treasure.TreasureType;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreasureGenerator {
    private final DiceRollGenerator diceRollGenerator;

    private final ArrayList<String> coinTypes = new ArrayList<>(Arrays.asList("cp", "sp", "ep", "gp", "pp"));

    public TreasureGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public TreasureGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public List<GeneratedTreasure> generate(String treasureType) {
        if (treasureType == null || treasureType.isBlank()) {
            throw new IllegalArgumentException("treasureType must not be null or blank");
        }

        TreasureType tt = getTreasureType(treasureType);

        ArrayList<GeneratedTreasure> treasureList = new ArrayList<>();
        GeneratedTreasure genTreasure;
        Roll roll;
        int amount;

        List<Treasure> treasures = tt.getTreasureList();
        for (Treasure treasure : treasures) {
            amount = 0;

            roll = this.diceRollGenerator.roll(1, 100);
            int treasureChance = roll.getTotal();

            if (treasureChance <= treasure.getChance()) {
                genTreasure = new GeneratedTreasure();
                if (treasure.getAmount() > 0) {
                    roll = this.diceRollGenerator.roll(treasure.getNumber(), treasure.getAmount());
                    amount = roll.getTotal() * treasure.getMultiplier();
                }

                genTreasure.setAmount(amount);
                genTreasure.setType(treasure.getType());

                treasureList.add(genTreasure);
            }
        }

        return treasureList;
    }

    public List<GeneratedTreasure> generatePouch(int maxCoins) {
        ArrayList<GeneratedTreasure> treasureList = new ArrayList<>();
        GeneratedTreasure genTreasure;
        Roll roll;
        int amount;

        for (String coinType : this.coinTypes) {
            if (maxCoins > 0) {
                roll = this.diceRollGenerator.roll(1, maxCoins);
                amount = roll.getTotal();

                genTreasure = new GeneratedTreasure();
                genTreasure.setAmount(amount);
                genTreasure.setType(coinType);

                treasureList.add(genTreasure);

                maxCoins = maxCoins - amount;
            }
            else {
                break;
            }
        }

        return treasureList;
    }

    private TreasureType getTreasureType(String treasureType) {
        TreasureType tt = null;

        switch (treasureType) {
            case "A":
            {
                tt = new TTA();
                break;
            }
            case "B":
            {
                tt = new TTB();
                break;
            }
            case "C":
            {
                tt = new TTC();
                break;
            }
            case "D":
            {
                tt = new TTD();
                break;
            }
            case "E":
            {
                tt = new TTE();
                break;
            }
            case "F":
            {
                tt = new TTF();
                break;
            }
            case "G":
            {
                tt = new TTG();
                break;
            }
            case "H":
            {
                tt = new TTH();
                break;
            }
            case "I":
            {
                tt = new TTI();
                break;
            }
            case "J":
            {
                tt = new TTJ();
                break;
            }
            case "K":
            {
                tt = new TTK();
                break;
            }
            case "L":
            {
                tt = new TTL();
                break;
            }
            case "M":
            {
                tt = new TTM();
                break;
            }
            case "N":
            {
                tt = new TTN();
                break;
            }
            case "O":
            {
                tt = new TTO();
                break;
            }
            case "P":
            {
                tt = new TTP();
                break;
            }
            case "Q":
            {
                tt = new TTQ();
                break;
            }
            case "R":
            {
                tt = new TTR();
                break;
            }
            case "S":
            {
                tt = new TTS();
                break;
            }
            case "T":
            {
                tt = new TTT();
                break;
            }
            case "U":
            {
                tt = new TTU();
                break;
            }
            case "V":
            {
                tt = new TTV();
                break;
            }
            case "W":
            {
                tt = new TTW();
                break;
            }
            case "X":
            {
                tt = new TTX();
                break;
            }
            case "Y":
            {
                tt = new TTY();
                break;
            }
            case "Z":
            {
                tt = new TTZ();
                break;
            }
            default:
                break;
        }

        if (tt == null) {
            throw new IllegalArgumentException("Invalid treasureType");
        }

        return tt;
    }
}
