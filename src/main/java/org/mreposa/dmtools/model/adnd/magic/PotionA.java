package org.mreposa.dmtools.model.adnd.magic;

public class PotionA extends MagicItemTable {
    public PotionA() {
        super();
    }

    @Override
    public String getMagicItem(int roll) {
        String itemName = "potion of ";

        if (roll < 4) {
            itemName = itemName + "animal control";
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
            itemName = itemName + "dragon control";
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
            itemName = itemName + "giant control";
        }
        else if (roll < 40) {
            itemName = itemName + "giant strength";
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
            itemName = itemName + "human control";
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
            itemName = itemName + "undead control";
        }
        else {
            itemName = itemName + "water breathing";
        }

        return itemName;
    }
}
