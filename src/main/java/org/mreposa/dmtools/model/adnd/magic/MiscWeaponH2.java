package org.mreposa.dmtools.model.adnd.magic;

public class MiscWeaponH2 extends MagicItemTable {
    public MiscWeaponH2() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll < 3) {
            itemName = "arrow +4 (2 - 8)";
        }
        if (roll == 3) {
            itemName = "axe +4";
        }
        if (roll == 4) {
            itemName = "axe of hurling";
        }
        else if (roll < 11) {
            itemName = "battle axe +2";
        }
        else if (roll < 14) {
            itemName = "battle axe +3";
        }
        else if (roll == 21) {
            itemName = "bolt +1 (6 - 36)";
        }
        else if (roll < 23) {
            itemName = "bolt +3 (3 - 12)";
        }
        else if (roll < 28) {
            itemName = "sling bullet +1 (5 - 20)";
        }
        else if (roll == 32) {
            itemName = "sling bullet +2 (3 - 12)";
        }
        else if (roll < 35) {
            itemName = "sling bullet +3 (2 - 8)";
        }
        else if (roll == 35) {
            itemName = "sling bullet of impact (1 - 4)";
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
            itemName = "dagger of throwing";
        }
        else if (roll < 52) {
            itemName = "dart +1 (3 - 12)";
        }
        else if (roll < 55) {
            itemName = "dart +2 (2 - 8)";
        }
        else if (roll < 57) {
            itemName = "dart +3 (1 - 4)";
        }
        else if (roll == 57) {
            itemName = "dart of homing (1 - 2)";
        }
        else if (roll < 62) {
            itemName = "flail +2";
        }
        else if (roll == 62) {
            itemName = "hammer +4";
        }
        else if (roll == 63) {
            itemName = "hornblade";
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
            itemName = "buckle knife";
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
            itemName = "magic quarterstaff";
        }
        else if (roll < 93) {
            itemName = "scimitar +1";
        }
        else if (roll < 95) {
            itemName = "scimitar +3";
        }
        else if (roll == 95) {
            itemName = "scimitar of speed";
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

        return itemName;
    }
}
