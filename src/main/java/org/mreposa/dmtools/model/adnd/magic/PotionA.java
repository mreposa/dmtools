package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class PotionA extends MagicItemTable {
    public PotionA(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "potion of ";
        String type = "";
        int typeRoll = 0;

        if (roll < 4) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 5) {
                type = "mammal/marsupial";
            }
            else if (typeRoll < 9) {
                type = "avian";
            }
            else if (typeRoll < 13) {
                type = "reptile/amphibian";
            }
            else if (typeRoll < 16) {
                type = "fish";
            }
            else if (typeRoll < 18) {
                type = "mammal/marsupial/avian";
            }
            else if (typeRoll < 20) {
                type = "reptile/amphibian/fish";
            }
            else {
                type = "all";
            }

            itemName = itemName + "animal control (" + type + ")";
        }
        else if (roll < 7) {
            itemName = itemName + "clairaudience";
        }
        else if (roll < 10) {
            itemName = itemName + "clairvoyance";
        }
        else if (roll < 13) {
            itemName = itemName + "climbing";
        }
        else if (roll < 16) {
            itemName = itemName + "delusion";
        }
        else if (roll < 19) {
            itemName = itemName + "diminution";
        }
        else if (roll < 21) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 3) {
                type = "white";
            }
            else if (typeRoll < 5) {
                type = "black";
            }
            else if (typeRoll < 8) {
                type = "green";
            }
            else if (typeRoll < 10) {
                type = "blue";
            }
            else if (typeRoll == 10) {
                type = "red";
            }
            else if (typeRoll < 13) {
                type = "brass";
            }
            else if (typeRoll < 15) {
                type = "copper";
            }
            else if (typeRoll == 15) {
                type = "bronze";
            }
            else if (typeRoll == 16) {
                type = "silver";
            }
            else if (typeRoll == 17) {
                type = "gold";
            }
            else if (typeRoll < 20) {
                type = "evil";
            }
            else {
                type = "good";
            }

            itemName = itemName + "dragon control (" + type + ")";
        }
        else if (roll < 24) {
            itemName = itemName + "ESP";
        }
        else if (roll < 27) {
            itemName = itemName + "extra-healing";
        }
        else if (roll < 30) {
            itemName = itemName + "fire resistance";
        }
        else if (roll < 33) {
            itemName = itemName + "flying";
        }
        else if (roll < 35) {
            itemName = itemName + "gaseous form";
        }
        else if (roll < 37) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "hill";
            }
            else if (typeRoll < 10) {
                type = "stone";
            }
            else if (typeRoll < 14) {
                type = "frost";
            }
            else if (typeRoll < 18) {
                type = "fire";
            }
            else if (typeRoll < 20) {
                type = "cloud";
            }
            else {
                type = "storm";
            }

            itemName = itemName + "giant control (" + type + ")";
        }
        else if (roll < 40) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 7) {
                type = "hill";
            }
            else if (typeRoll < 11) {
                type = "stone";
            }
            else if (typeRoll < 15) {
                type = "frost";
            }
            else if (typeRoll < 18) {
                type = "fire";
            }
            else if (typeRoll < 20) {
                type = "cloud";
            }
            else {
                type = "storm";
            }

            itemName = itemName + "giant strength (" + type + ")";
        }
        else if (roll < 42) {
            itemName = itemName + "growth";
        }
        else if (roll < 48) {
            itemName = itemName + "healing";
        }
        else if (roll < 50) {
            itemName = itemName + "heroism";
        }
        else if (roll < 52) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 3) {
                type = "dwarves";
            }
            else if (typeRoll < 5) {
                type = "elves/half-elves";
            }
            else if (typeRoll < 7) {
                type = "gnomes";
            }
            else if (typeRoll < 9) {
                type = "halflings";
            }
            else if (typeRoll == 11) {
                type = "half-orcs";
            }
            else if (typeRoll < 17) {
                type = "humans";
            }
            else if (typeRoll < 20) {
                type = "humanoids";
            }
            else {
                type = "elves/half-elves/humans";
            }

            itemName = itemName + "human control (" + type + ")";
        }
        else if (roll < 55) {
            itemName = itemName + "invisibility";
        }
        else if (roll < 58) {
            itemName = itemName + "invulnerability";
        }
        else if (roll < 61) {
            itemName = itemName + "levitation";
        }
        else if (roll < 64) {
            itemName = itemName + "longevity";
        }
        else if (roll < 67) {
            itemName = "oil of etherealness";
        }
        else if (roll < 70) {
            itemName = "oil of slipperiness";
        }
        else if (roll < 73) {
            itemName = "philter of love";
        }
        else if (roll < 76) {
            itemName = "philter of persuasiveness";
        }
        else if (roll < 79) {
            itemName = itemName + "plant control";
        }
        else if (roll < 82) {
            itemName = itemName + "polymorph self";
        }
        else if (roll < 85) {
            itemName = itemName + "poison";
        }
        else if (roll < 88) {
            itemName = itemName + "speed";
        }
        else if (roll < 91) {
            itemName = itemName + "super-heroism";
        }
        else if (roll < 94) {
            itemName = itemName + "sweet water";
        }
        else if (roll < 97) {
            itemName = itemName + "treasure finding";
        }
        else if (roll == 97) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            typeRoll = dieRoll.getTotal();

            if (typeRoll == 1) {
                type = "ghasts";
            }
            else if (typeRoll == 2) {
                type = "ghosts";
            }
            else if (typeRoll == 3) {
                type = "ghouls";
            }
            else if (typeRoll == 4) {
                type = "shadows";
            }
            else if (typeRoll == 5) {
                type = "skeletons";
            }
            else if (typeRoll == 6) {
                type = "spectres";
            }
            else if (typeRoll == 7) {
                type = "wights";
            }
            else if (typeRoll == 8) {
                type = "wraiths";
            }
            else if (typeRoll == 9) {
                type = "vampires";
            }
            else if (typeRoll == 10) {
                type = "zombies";
            }

            itemName = itemName + "undead control (" + type + ")";
        }
        else {
            itemName = itemName + "water breathing";
        }

        return itemName;
    }
}
