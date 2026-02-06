package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.gem.GemJewelryTable;
import org.mreposa.dmtools.model.adnd.gem.Jewelry;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.ArrayList;
import java.util.List;

public class JewelryGenerator {
    private final DiceRollGenerator diceRollGenerator;

    public JewelryGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public JewelryGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public List<Jewelry> generate(int count) {
        ArrayList<Jewelry> jewelryList = new ArrayList<>();
        Jewelry jewelry;
        Roll roll;
        int rollTotal;
        int baseValue = 0;
        String piece = "";
        String make = "";
        for (int i = 0; i < count; i++) {
            roll = this.diceRollGenerator.roll(1, 100);
            rollTotal = roll.getTotal();

            // Jewelry base value
            if (rollTotal < 11) {
                roll = this.diceRollGenerator.roll(10, 10);
                rollTotal = roll.getTotal() * 10;
                baseValue = rollTotal;

                make = GemJewelryTable.JEWELRY_MAKE[0];
            }
            else if (rollTotal < 21) {
                roll = this.diceRollGenerator.roll(20, 6);
                rollTotal = roll.getTotal() * 10;
                baseValue = rollTotal;

                make = GemJewelryTable.JEWELRY_MAKE[1];
            }
            else if (rollTotal < 41) {
                roll = this.diceRollGenerator.roll(30, 6);
                rollTotal = roll.getTotal() * 10;
                baseValue = rollTotal;

                make = GemJewelryTable.JEWELRY_MAKE[2];
            }
            else if (rollTotal < 51) {
                roll = this.diceRollGenerator.roll(50, 6);
                rollTotal = roll.getTotal() * 10;
                baseValue = rollTotal;

                make = GemJewelryTable.JEWELRY_MAKE[3];
            }
            else if (rollTotal < 71) {
                roll = this.diceRollGenerator.roll(100, 6);
                rollTotal = roll.getTotal() * 10;
                baseValue = rollTotal;

                make = GemJewelryTable.JEWELRY_MAKE[4];
            }
            else if (rollTotal < 91) {
                roll = this.diceRollGenerator.roll(200, 4);
                rollTotal = roll.getTotal() * 10;
                baseValue = rollTotal;

                make = GemJewelryTable.JEWELRY_MAKE[5];
            }
            else {
                roll = this.diceRollGenerator.roll(200, 6);
                rollTotal = roll.getTotal() * 10;
                baseValue = rollTotal;

                make = GemJewelryTable.JEWELRY_MAKE[6];
            }

            jewelry = new Jewelry();
            jewelry.setBaseValue(baseValue);
            jewelry.setMake(make);

            roll = this.diceRollGenerator.roll(1, GemJewelryTable.JEWELRY_PIECE.length);
            // Subtract one to index array
            rollTotal = roll.getTotal() - 1;
            piece = GemJewelryTable.JEWELRY_PIECE[rollTotal];
            jewelry.setPiece(piece);

            jewelryList.add(jewelry);
        }

        return jewelryList;
    }
}
