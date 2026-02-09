package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscMagicE7 extends MagicItemTable {
    public MiscMagicE7(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;

        if (roll < 6) {
            itemName = "Heward's handy haversack";
        }
        else if (roll < 11) {
            itemName = "horn of fog";
        }
        else if (roll < 13) {
            itemName = "horn of goodness/evil";
        }
        else if (roll < 15) {
            itemName = "iron bands of Bilarro";
        }
        else if (roll < 19) {
            itemName = "lens of detection";
        }
        else if (roll < 22) {
            itemName = "lens of ultravision";
        }
        else if (roll < 24) {
            itemName = "mantle of Celestian";
        }
        else if (roll < 28) {
            itemName = "Murlynd's spoon";
        }
        else if (roll < 30) {
            itemName = "pearl of the sirines";
        }
        else if (roll < 32) {
            itemName = "philosopher's stone";
        }
        else if (roll < 38) {
            itemName = "pouch of accessibility";
        }
        else if (roll == 38) {
            itemName = "prison of Zagyg";
        }
        else if (roll < 41) {
            itemName = "quiver of Ehlonna";
        }
        else if (roll < 43) {
            itemName = "robe of stars";
        }
        else if (roll < 49) {
            itemName = "robe of vermin";
        }
        else if (roll < 51) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 31) {
                type = "flesh";
            }
            else if (typeRoll < 56) {
                type = "clay";
            }
            else if (typeRoll < 76) {
                type = "stone";
            }
            else if (typeRoll < 86) {
                type = "iron";
            }
            else if (typeRoll < 96) {
                type = "flesh/clay/wood";
            }
            else  {
                type = "any";
            }

            itemName = "scarab vs. golems (" + type + " level cleric)";
        }
        else if (roll < 55) {
            itemName = "shadow lanthorn";
        }
        else if (roll < 58) {
            itemName = "sheet of smallness";
        }
        else if (roll < 60) {
            itemName = "shoes of Fharlanghn";
        }
        else if (roll < 65) {
            itemName = "slippers of kicking";
        }
        else if (roll < 71) {
            itemName = "slippers of spider climbing";
        }
        else if (roll < 73) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            int count = dieRoll.getTotal();

            itemName = "sovereign glue (" + count + " ounces)";
        }
        else if (roll < 78) {
            itemName = "spoon of stirring";
        }
        else if (roll < 82) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 51) {
                type = "courser";
            }
            else  {
                type = "destrier";
            }

            itemName = "stone horse (" + type + ")";
        }
        else if (roll < 85) {
            itemName = "ultimate solution";
        }
        else if (roll < 89) {
            itemName = "wind fan";
        }
        else if (roll < 93) {
            itemName = "Zagyg's flowing flagon";
        }
        else {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 4) {
                type = "2";
            }
            else if (typeRoll < 7) {
                type = "3";
            }
            else if (typeRoll < 11) {
                type = "4";
            }
            else if (typeRoll < 15) {
                type = "5";
            }
            else if (typeRoll < 20) {
                type = "6";
            }
            else  {
                type = "7";
            }

            itemName = "Zagyg's spell component case (" + type + " uses per day)";
        }

        return itemName;
    }
}
