package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscWeaponH extends MagicItemTable {
    public MiscWeaponH(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";

        if (roll == 9) {
            dieRoll = this.diceRollGenerator.roll(2, 12);
            int count = dieRoll.getTotal();

            itemName = "arrow +1 (" + count + ")";
        }
        else if (roll < 13) {
            dieRoll = this.diceRollGenerator.roll(2, 8);
            int count = dieRoll.getTotal();

            itemName = "arrow +2 (" + count + ")";
        }
        else if (roll < 15) {
            dieRoll = this.diceRollGenerator.roll(2, 6);
            int count = dieRoll.getTotal();

            itemName = "arrow +3 (" + count + ")";
        }
        else if (roll == 15) {
            dieRoll = this.diceRollGenerator.roll(1, 3);
            int columnRoll = dieRoll.getTotal();
            dieRoll = this.diceRollGenerator.roll(1, 8);
            int typeRoll = dieRoll.getTotal();

            String type = "";
            if (columnRoll == 1) {
                if (typeRoll == 1) {
                    type = "arachnids";
                }
                else if (typeRoll == 2) {
                    type = "avians";
                }
                else if (typeRoll == 3) {
                    type = "bards";
                }
                else if (typeRoll == 4) {
                    type = "clerics";
                }
                else if (typeRoll == 5) {
                    type = "demons";
                }
                else if (typeRoll == 6) {
                    type = "devils";
                }
                else if (typeRoll == 7) {
                    type = "dragons";
                }
                else  {
                    type = "druids";
                }
            }
            else if (columnRoll == 2) {
                if (typeRoll == 1) {
                    type = "elementals";
                }
                else if (typeRoll == 2) {
                    type = "fighters";
                }
                else if (typeRoll == 3) {
                    type = "giants";
                }
                else if (typeRoll == 4) {
                    type = "golems";
                }
                else if (typeRoll == 5) {
                    type = "illusionists";
                }
                else if (typeRoll == 6) {
                    type = "ki-rin";
                }
                else if (typeRoll == 7) {
                    type = "magic-users";
                }
                else  {
                    type = "mammals";
                }
            }
            else {
                if (typeRoll == 1) {
                    type = "monks";
                }
                else if (typeRoll == 2) {
                    type = "paladins";
                }
                else if (typeRoll == 3) {
                    type = "rangers";
                }
                else if (typeRoll == 4) {
                    type = "reptiles";
                }
                else if (typeRoll == 5) {
                    type = "sea monsters";
                }
                else if (typeRoll == 6) {
                    type = "thieves";
                }
                else if (typeRoll == 7) {
                    type = "titans";
                }
                else  {
                    type = "undead";
                }
            }

            itemName = "arrow of slaying (" + type + ")";
        }
        else if (roll < 21) {
            itemName = "axe +1";
        }
        else if (roll < 23) {
            itemName = "axe +2";
        }
        else if (roll == 23) {
            itemName = "throwing axe +2";
        }
        else if (roll == 24) {
            itemName = "axe +3";
        }
        else if (roll < 28) {
            itemName = "battle axe +1";
        }
        else if (roll < 33) {
            dieRoll = this.diceRollGenerator.roll(2, 10);
            int count = dieRoll.getTotal();

            itemName = "bolt +2 (" + count + ")";
        }
        else if (roll < 36) {
            itemName = "bow +1";
        }
        else if (roll == 36) {
            itemName = "crossbow of accuracy";
        }
        else if (roll == 37) {
            itemName = "crossbow of distance";
        }
        else if (roll == 38) {
            itemName = "crossbow of speed";
        }
        else if (roll < 47) {
            itemName = "dagger +1 (+2 vs. smaller than man-sized creatures)";
        }
        else if (roll < 51) {
            itemName = "dagger +2 (+3 vs. larger than man-sized creatures)";
        }
        else if (roll == 51) {
            itemName = "dagger of venom";
        }
        else if (roll < 57) {
            itemName = "flail +1";
        }
        else if (roll < 61) {
            itemName = "hammer +1";
        }
        else if (roll < 63) {
            itemName = "hammer +2";
        }
        else if (roll == 63) {
            itemName = "hammer +3 (dwarven thrower)";
        }
        else if (roll == 64) {
            itemName = "hammer of thunderbolts";
        }
        else if (roll < 68) {
            itemName = "javelin +2";
        }
        else if (roll < 73) {
            itemName = "mace +1";
        }
        else if (roll < 76) {
            itemName = "mace +2";
        }
        else if (roll == 76) {
            itemName = "mace of disruption";
        }
        else if (roll == 77) {
            itemName = "mace +4";
        }
        else if (roll < 81) {
            itemName = "military pick +1";
        }
        else if (roll < 84) {
            itemName = "morning star +1";
        }
        else if (roll < 89) {
            itemName = "scimitar +2";
        }
        else if (roll == 89) {
            itemName = "sling of seeking";
        }
        else if (roll < 95) {
            itemName = "spear +1";
        }
        else if (roll < 97) {
            itemName = "spear +2";
        }
        else if (roll == 97) {
            itemName = "spear +3";
        }
        else if (roll < 100) {
            itemName = "spear cursed backbiter";
        }
        else {
            itemName = "trident +3";
        }

        return itemName;
    }
}
