package org.mreposa.dmtools.generator.adnd;

public class DiceRollGenerator extends org.mreposa.dmtools.generator.DiceRollGenerator {
    private static final int[] DICE_SIDES = {4, 6, 8, 10, 12, 20, 100};

    public DiceRollGenerator() { super(); }

    @Override
    public int[] getDice() {
        return DICE_SIDES;
    }
}
