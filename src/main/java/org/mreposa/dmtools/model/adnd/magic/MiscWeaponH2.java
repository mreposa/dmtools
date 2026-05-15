package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscWeaponH2 extends MagicItemTable {
    public MiscWeaponH2(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;

        if (roll < 3) {
            dieRoll = this.diceRollGenerator.roll(2, 4);
            int count = dieRoll.getTotal();

            itemName = "arrow +4 (" + count + ")";
        }
        else if (roll == 3) {
            itemName = "hand axe +4";
        }
        else if (roll == 4) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "+1";
            }
            else if (typeRoll < 11) {
                type = "+2";
            }
            else if (typeRoll < 16) {
                type = "+3";
            }
            else if (typeRoll < 20) {
                type = "+4";
            }
            else  {
                type = "+5";
            }

            itemName = "axe of hurling " + type;
        }
        else if (roll < 11) {
            itemName = "battle axe +2";
        }
        else if (roll < 14) {
            itemName = "battle axe +3";
        }
        else if (roll == 21) {
            dieRoll = this.diceRollGenerator.roll(6, 6);
            int count = dieRoll.getTotal();

            itemName = "bolt +1 (" + count + ")";
        }
        else if (roll < 23) {
            dieRoll = this.diceRollGenerator.roll(3, 4);
            int count = dieRoll.getTotal();

            itemName = "bolt +3 (" + count + ")";
        }
        else if (roll < 28) {
            dieRoll = this.diceRollGenerator.roll(5, 4);
            int count = dieRoll.getTotal();

            itemName = "sling bullet +1 (" + count + ")";
        }
        else if (roll == 32) {
            dieRoll = this.diceRollGenerator.roll(3, 4);
            int count = dieRoll.getTotal();

            itemName = "sling bullet +2 (" + count + ")";
        }
        else if (roll < 35) {
            dieRoll = this.diceRollGenerator.roll(2, 4);
            int count = dieRoll.getTotal();

            itemName = "sling bullet +3 (" + count + ")";
        }
        else if (roll == 35) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int count = dieRoll.getTotal();

            itemName = "sling bullet of impact (" + count + ")";
        }
        else if (roll < 41) {
            itemName = "dagger +1";
        }
        else if (roll < 44) {
            itemName = "dagger +2";
        }
        else if (roll == 44) {
            itemName = "dagger +2 (longtooth)";
        }
        else if (roll < 47) {
            itemName = "dagger +3";
        }
        else if (roll == 47) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 36) {
                type = "+1";
            }
            else if (typeRoll < 66) {
                type = "+2";
            }
            else if (typeRoll < 91) {
                type = "+3";
            }
            else {
                type = "+4";
            }

            itemName = "dagger of throwing " + type;
        }
        else if (roll < 52) {
            dieRoll = this.diceRollGenerator.roll(3, 4);
            int count = dieRoll.getTotal();

            itemName = "dart +1 (" + count + ")";
        }
        else if (roll < 55) {
            dieRoll = this.diceRollGenerator.roll(2, 4);
            int count = dieRoll.getTotal();

            itemName = "dart +2 (" + count + ")";
        }
        else if (roll < 57) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int count = dieRoll.getTotal();

            itemName = "dart +3 (" + count + ")";
        }
        else if (roll == 57) {
            dieRoll = this.diceRollGenerator.roll(1, 2);
            int count = dieRoll.getTotal();

            itemName = "dart dart of homing (" + count + ")";
        }
        else if (roll < 62) {
            itemName = "flail +2";
        }
        else if (roll == 62) {
            itemName = "hammer +4";
        }
        else if (roll == 63) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 21) {
                type = "+1 (knife-sized)";
            }
            else if (typeRoll < 36) {
                type = "+2 (knife-sized)";
            }
            else if (typeRoll < 51) {
                type = "+1 (dagger-sized)";
            }
            else if (typeRoll < 71) {
                type = "+2 (dagger-sized)";
            }
            else if (typeRoll < 91) {
                type = "+2 (scimitar-sized)";
            }
            else {
                type = "+3 (scimitar-sized)";
            }

            itemName = "hornblade " + type;
        }
        else if (roll < 69) {
            itemName = "javelin +1";
        }
        else if (roll < 71) {
            itemName = "javelin +2";
        }
        else if (roll < 76) {
            itemName = "knife +1";
        }
        else if (roll < 79) {
            itemName = "knife +2";
        }
        else if (roll == 79) {
            dieRoll = this.diceRollGenerator.roll(1, 10);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 5) {
                type = "+1";
            }
            else if (typeRoll < 8) {
                type = "+2";
            }
            else if (typeRoll < 10) {
                type = "+3";
            }
            else {
                type = "+4";
            }

            itemName = "buckle knife " + type;
        }
        else if (roll < 82) {
            itemName = "lance +1";
        }
        else if (roll < 84) {
            itemName = "mace +3";
        }
        else if (roll < 87) {
            itemName = "morning star +2";
        }
        else if (roll == 87) {
            itemName = "pole arm +1";
        }
        else if (roll < 90) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "+1";
            }
            else if (typeRoll < 10) {
                type = "+2";
            }
            else if (typeRoll < 14) {
                type = "+3";
            }
            else if (typeRoll < 18) {
                type = "+4";
            }
            else  {
                type = "+5";
            }

            itemName = "magic quarterstaff " + type;
        }
        else if (roll < 93) {
            itemName = "scimitar +1";
        }
        else if (roll < 95) {
            itemName = "scimitar +3";
        }
        else if (roll == 95) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            int specialRoll = dieRoll.getTotal();

            if (specialRoll < 76) {
                type = "+2";
            }
            else {
                dieRoll = this.diceRollGenerator.roll(1, 100);
                typeRoll = dieRoll.getTotal();

                if (typeRoll < 51) {
                    type = "+1";
                } else if (typeRoll < 76) {
                    type = "+3";
                } else if (typeRoll < 91) {
                    type = "+4";
                } else {
                    type = "+5";
                }
            }

            itemName = "scimitar of speed " + type;
        }
        else if (roll == 96) {
            itemName = "scimitar +4";
        }
        else if (roll < 100) {
            itemName = "spear +4";
        }
        else {
            itemName = "spear +5";
        }

        if (itemName.startsWith("scimitar")) {
            itemName = itemName.replaceFirst("scimitar", getScimitarType());
        }

        return itemName;
    }
}
