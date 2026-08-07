package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.roll.Roll;

public class LanguageGenerator {
    private final DiceRollGenerator diceRollGenerator;

    public LanguageGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public LanguageGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public String generate() {
        String language = null;
        Roll roll;
        int value;

        roll = this.diceRollGenerator.roll(1, 100);
        value = roll.getTotal();

        if (value < 2) {
            language = "Brownie";
        }
        else if (value < 4) {
            language = "Bugbear";
        }
        else if (value < 5) {
            language = "Centaur";
        }
        else if (value < 6) {
            language = "Black Dragon";
        }
        else if (value < 7) {
            language = "Blue Dragon";
        }
        else if (value < 8) {
            language = "Brass Dragon";
        }
        else if (value < 9) {
            language = "Bronze Dragon";
        }
        else if (value < 10) {
            language = "Copper Dragon";
        }
        else if (value < 11) {
            language = "Gold Dragon";
        }
        else if (value < 12) {
            language = "Green Dragon";
        }
        else if (value < 13) {
            language = "Red Dragon";
        }
        else if (value < 14) {
            language = "Silver Dragon";
        }
        else if (value < 15) {
            language = "White Dragon";
        }
        else if (value < 16) {
            language = "Dryad";
        }
        else if (value < 21) {
            language = "Dwarvish";
        }
        else if (value < 26) {
            language = "Elvish";
        }
        else if (value < 27) {
            language = "Ettin";
        }
        else if (value < 28) {
            language = "Gargoyle";
        }
        else if (value < 29) {
            language = "Cloud Giant";
        }
        else if (value < 30) {
            language = "Fire Giant";
        }
        else if (value < 31) {
            language = "Frost Giant";
        }
        else if (value < 34) {
            language = "Hill Giant";
        }
        else if (value < 35) {
            language = "Stone Giant";
        }
        else if (value < 36) {
            language = "Storm Giant";
        }
        else if (value < 40) {
            language = "Goblin";
        }
        else if (value < 41) {
            language = "Gnoll";
        }
        else if (value < 45) {
            language = "Gnome";
        }
        else if (value < 50) {
            language = "Halfling";
        }
        else if (value < 52) {
            language = "Hobgoblin";
        }
        else if (value < 55) {
            language = "Kobold";
        }
        else if (value < 56) {
            language = "Lammasu";
        }
        else if (value < 59) {
            language = "Lizard Man";
        }
        else if (value < 60) {
            language = "Manticore";
        }
        else if (value < 61) {
            language = "Medusian";
        }
        else if (value < 62) {
            language = "Minotaur";
        }
        else if (value < 63) {
            language = "Guardian Naga";
        }
        else if (value < 64) {
            language = "Spirit Naga";
        }
        else if (value < 65) {
            language = "Water Naga";
        }
        else if (value < 66) {
            language = "Nixie";
        }
        else if (value < 67) {
            language = "Nymph";
        }
        else if (value < 71) {
            language = "Ogrish";
        }
        else if (value < 72) {
            language = "Ogre Magian";
        }
        else if (value < 77) {
            language = "Orcish";
        }
        else if (value < 78) {
            language = "Pixie";
        }
        else if (value < 79) {
            language = "Salamander";
        }
        else if (value < 80) {
            language = "Satyr";
        }
        else if (value < 81) {
            language = "Shedu";
        }
        else if (value < 82) {
            language = "Sprite";
        }
        else if (value < 83) {
            language = "Sylph";
        }
        else if (value < 84) {
            language = "Titan";
        }
        else if (value < 85) {
            language = "Troll";
        }
        else if (value < 86) {
            language = "Xorn";
        }
        else {
            language = "Human foreign or other";
        }

        return language;
    }
}
