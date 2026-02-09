package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class SwordG2 extends MagicItemTable {
    public SwordG2(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";

        if (roll < 16) {
            itemName = "sun blade";
        }
        if (roll == 16) {
            itemName = "anything sword";
        }
        else if (roll < 33) {
            itemName = "broad sword final word";
        }
        else if (roll < 46) {
            itemName = "sword of dancing";
        }
        else if (roll == 62) {
            itemName = "sword +5 defender";
        }
        else if (roll < 70) {
            itemName = "sword +6 defender";
        }
        else if (roll < 85) {
            itemName = "sword +5 holy avenger";
        }
        else if (roll == 92) {
            itemName = "sword +6 holy avenger";
        }
        else if (roll < 94) {
            itemName = "sword of life stealing";
        }
        else if (roll < 96) {
            itemName = "sword +2 nine lives stealer";
        }
        else if (roll < 98) {
            itemName = "sword of sharpness";
        }
        else if (roll == 98) {
            itemName = "vorpal sword";
        }
        else {
            itemName = "sword of wounding";
        }

        return itemName;
    }
}
