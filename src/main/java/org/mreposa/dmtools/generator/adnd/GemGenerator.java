package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.gem.Gem;
import org.mreposa.dmtools.model.adnd.gem.GemJewelryTable;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.ArrayList;
import java.util.List;

public class GemGenerator {
    private final DiceRollGenerator diceRollGenerator;

    public GemGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public GemGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public List<Gem> generate(int count) {
        ArrayList<Gem> gems = new ArrayList<>();
        Gem gem;
        Roll roll;
        int rollTotal;
        int baseValue = 0;
        String type = "";
        for (int i = 0; i < count; i++) {
            roll = this.diceRollGenerator.roll(1, 100);
            rollTotal = roll.getTotal();

            // Gem base value
            if (rollTotal < 26) {
                baseValue = 10;

                roll = this.diceRollGenerator.roll(1, 12);
                // Subtract one to index array
                rollTotal = roll.getTotal() - 1;
                type = GemJewelryTable.BASE_TEN_GP_GEMS[rollTotal];
            }
            else if (rollTotal < 51) {
                baseValue = 50;

                roll = this.diceRollGenerator.roll(1, 13);
                // Subtract one to index array
                rollTotal = roll.getTotal() - 1;
                type = GemJewelryTable.BASE_FIFTY_GP_GEMS[rollTotal];
            }
            else if (rollTotal < 71) {
                baseValue = 100;

                roll = this.diceRollGenerator.roll(1, 11);
                // Subtract one to index array
                rollTotal = roll.getTotal() - 1;
                type = GemJewelryTable.BASE_ONE_HUNDRED_GP_GEMS[rollTotal];
            }
            else if (rollTotal < 91) {
                baseValue = 500;

                roll = this.diceRollGenerator.roll(1, 6);
                // Subtract one to index array
                rollTotal = roll.getTotal() - 1;
                type = GemJewelryTable.BASE_FIVE_HUNDRED_GP_GEMS[rollTotal];
            }
            else if (rollTotal < 100) {
                baseValue = 1000;

                roll = this.diceRollGenerator.roll(1, 9);
                // Subtract one to index array
                rollTotal = roll.getTotal() - 1;
                type = GemJewelryTable.BASE_ONE_THOUSAND_GP_GEMS[rollTotal];
            }
            else {
                baseValue = 5000;

                roll = this.diceRollGenerator.roll(1, 5);
                // Subtract one to index array
                rollTotal = roll.getTotal() - 1;
                type = GemJewelryTable.BASE_FIVE_THOUSAND_GP_GEMS[rollTotal];
            }

            gem = new Gem();
            gem.setBaseValue(baseValue);
            gem.setType(type);
            gems.add(gem);
        }

        return gems;
    }
}
