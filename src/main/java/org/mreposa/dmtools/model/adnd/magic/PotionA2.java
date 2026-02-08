package org.mreposa.dmtools.model.adnd.magic;

public class PotionA2 extends MagicItemTable {
    public PotionA2() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "potion of ";

        if (roll < 6) {
            itemName = "elixir of health";
        }
        else if (roll < 16) {
            itemName = "elixir of life";
        }
        else if (roll < 21) {
            itemName = "elixir of madness";
        }
        else if (roll < 26) {
            itemName = "elixir of youth";
        }
        else if (roll < 31) {
            itemName = itemName + "fire breath";
        }
        else if (roll < 36) {
            itemName = "oil of acid resistance";
        }
        else if (roll < 41) {
            itemName = "oil of disenchantment";
        }
        else if (roll < 46) {
            itemName = "oil of elemental invulnerability";
        }
        else if (roll < 50) {
            itemName = "oil of fiery burning";
        }
        else if (roll < 56) {
            itemName = "oil of fumbling";
        }
        else if (roll < 60) {
            itemName = "oil of impact";
        }
        else if (roll < 66) {
            itemName = "oil of sharpness";
        }
        else if (roll < 71) {
            itemName = "oil of timelessness";
        }
        else if (roll < 76) {
            itemName = "philter of beauty";
        }
        else if (roll < 81) {
            itemName = "philter of glibness";
        }
        else if (roll < 86) {
            itemName = "philter of stammering and stuttering";
        }
        else if (roll < 91) {
            itemName = itemName + "rainbow hues";
        }
        else if (roll < 96) {
            itemName = itemName + "ventriloquism";
        }
        else {
            itemName = itemName + "vitality";
        }

        return itemName;
    }
}
