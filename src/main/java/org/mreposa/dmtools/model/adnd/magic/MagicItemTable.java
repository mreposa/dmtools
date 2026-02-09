package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;

public abstract class MagicItemTable {
    protected DiceRollGenerator diceRollGenerator;

    public MagicItemTable(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public abstract String getMagicItem();
}
