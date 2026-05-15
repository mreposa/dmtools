package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;

public abstract class MagicItemTable {
    protected DiceRollGenerator diceRollGenerator;

    public MagicItemTable(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public abstract String getMagicItem();

    public String getArmorSize() {
        String armorSize = "[";

        int roll = this.diceRollGenerator.roll(1, 100).getTotal();
        if (roll < 66) {
            armorSize = armorSize + "man-sized";
        }
        else if (roll < 86) {
            armorSize = armorSize + "elf-sized";
        }
        else if (roll < 96) {
            armorSize = armorSize + "dwarf-sized";
        }
        else {
            armorSize = armorSize + "gnome/halfling-sized";
        }

        armorSize = armorSize + "]";

        return armorSize;
    }

    public String getElfinChainSize() {
        String armorSize = "[";

        int roll = this.diceRollGenerator.roll(1, 100).getTotal();
        if (roll < 66) {
            armorSize = armorSize + "elf-sized";
        }
        else if (roll < 86) {
            armorSize = armorSize + "man-sized";
        }
        else if (roll < 96) {
            armorSize = armorSize + "dwarf-sized";
        }
        else {
            armorSize = armorSize + "gnome/halfling-sized";
        }

        armorSize = armorSize + "]";

        return armorSize;
    }

    public String getSwordType() {
        String swordType = "";

        int roll = this.diceRollGenerator.roll(1, 100).getTotal();

        if (roll < 66) {
            swordType = "long sword";
        }
        else if (roll < 86) {
            swordType = "broad sword";
        }
        else if (roll < 91) {
            swordType = "falchion";
        }
        else if (roll < 96) {
            swordType = "short sword";
        }
        else if (roll < 100) {
            swordType = "bastard sword";
        }
        else {
            swordType = "two-handed sword";
        }

        return swordType;
    }

    public String getScimitarType() {
        String scimitarType = "";

        int roll = this.diceRollGenerator.roll(1, 100).getTotal();

        if (roll < 11) {
            scimitarType = "khopesh";
        }
        else {
            scimitarType = "scimitar";
        }

        return scimitarType;
    }

    public String getBowType() {
        String bowType = "";

        int roll = this.diceRollGenerator.roll(1, 100).getTotal();

        if (roll < 11) {
            bowType = "composite ";
        }

        roll = this.diceRollGenerator.roll(1, 100).getTotal();

        if (roll < 61) {
            bowType = "long";
        }
        else {
            bowType = "short";
        }

        return bowType;
    }

    public String getCrossbowType() {
        String crossbowType = "";

        int roll = this.diceRollGenerator.roll(1, 100).getTotal();

        if (roll < 11) {
            crossbowType = "heavy";
        }
        else if (roll < 16) {
            crossbowType = "hand";
        }
        else {
            crossbowType = "light";
        }

        return crossbowType;
    }
}
