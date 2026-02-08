package org.mreposa.dmtools.model.adnd.magic;

public class MiscWeaponH extends MagicItemTable {
    public MiscWeaponH() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "";

        if (roll == 9) {
            itemName = "arrow +1 (2 - 24)";
        }
        else if (roll < 13) {
            itemName = "arrow +2 (2 - 16)";
        }
        else if (roll < 15) {
            itemName = "arrow +3 (2 - 12)";
        }
        else if (roll == 15) {
            itemName = "arrow of slaying";
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
            itemName = "bolt +2 (2 - 20)";
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
