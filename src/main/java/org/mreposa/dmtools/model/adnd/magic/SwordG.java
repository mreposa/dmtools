package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class SwordG extends MagicItemTable {
    public SwordG(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";

        if (roll == 26) {
            itemName = "sword +1";
        }
        else if (roll < 31) {
            itemName = "sword +1 (+2 vs. magic-using and enchanted creatures)";
        }
        else if (roll < 36) {
            itemName = "sword +1 (+3 vs. lycanthropes and shape-changers)";
        }
        else if (roll == 41) {
            itemName = "sword +1 (+3 vs. regenerating creatures)";
        }
        else if (roll < 46) {
            itemName = "sword +1 (+4 vs. reptiles)";
        }
        else if (roll < 50) {
            itemName = "sword +1 flame tongue";
        }
        else if (roll == 50) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int count = dieRoll.getTotal() + 1;

            itemName = "sword +1 luck blade (" + count + " wishes)";
        }
        else if (roll < 59) {
            itemName = "sword +2";
        }
        else if (roll < 63) {
            itemName = "sword +2 giant slayer";
        }
        else if (roll < 67) {
            itemName = "sword +2 dragon slayer";
        }
        else if (roll < 71) {
            itemName = "short sword of quickness";
        }
        else if (roll == 77) {
            itemName = "sword +3";
        }
        else if (roll < 80) {
            itemName = "sword +3 frost brand";
        }
        else if (roll < 82) {
            itemName = "sword of the planes";
        }
        else if (roll < 85) {
            itemName = "sword +4";
        }
        else if (roll < 87) {
            itemName = "sword +4 defender";
        }
        else if (roll < 89) {
            itemName = "sword +5";
        }
        else if (roll < 95) {
            itemName = "sword -1 cursed";
        }
        else if (roll == 99) {
            itemName = "sword -2 cursed";
        }
        else {
            itemName = "sword cursed berserking";
        }

        return itemName;
    }
}
