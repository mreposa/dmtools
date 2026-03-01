package org.mreposa.dmtools.model.adnd.details;

public class CharacterDetailsTable {
    public static final String[] ALIGNMENT = {"LG", "LN", "LE", "NE", "CE", "CN", "CG", "NG", "N", "N"};
    public static final String[] WEALTH = {"none", "scant", "scant", "average", "average", "average", "average", "above average", "exceptional", "superabundant"};
    public static final String[] AGE = {"young", "youthful", "youthful", "mature", "mature", "mature", "mature", "middle-aged", "old", "ancient"};
    public static final String[] APPEARANCE = {"dirty", "clean", "unkempt", "immaculate", "rough", "ragged", "dandyish", "foppish", "non-descript", "imposing"};
    public static final String[] SANITY = {"very stable", "normal", "normal", "normal", "normal", "normal", "neurotic", "unstable", "insane", "maniacal"};
    public static final String[] TENDENCIES_1 = {"optimist", "pessimist", "hedonist", "altruist", "helpful/kindly", "careless", "capricious/mischievous", "sober", "curious/inquisitive", "moody", "trusting", "suspicious/cautious"};
    public static final String[] TENDENCIES_2 = {"precise/exacting", "perceptive", "opinionated/contrary", "violent/warlike", "studious", "foul/barbaric", "cruel/callous", "practical joker/prankster", "servile/obsequious", "fanatical/obsessive", "malevolent", "loquacious"};
    public static final String[] PERSONALITY_1 = {"modest", "egoist/arrogant", "friendly", "aloof", "hostile", "well-spoken", "diplomatic", "abrasive"};
    public static final String[] PERSONALITY_2 = {"forceful", "overbearing", "friendly", "blustering", "antagonistic", "rude", "rash", "diplomatic"};
    public static final String[] PERSONALITY_3 = {"retiring", "taciturn", "friendly", "aloof", "hostile", "rude", "courteous", "solitary/secretive"};
    public static final String[] DISPOSITION = {"cheerful", "morose", "compassionate/sensitive", "unfeeling/insensitive", "humble", "proud/haughty", "even tempered", "hot tempered", "easy going", "harsh"};
    public static final String[] INTELLECT = {"dull", "average", "average", "active", "active", "dreaming", "ponderous", "anti-intellectual", "scheming", "brilliant"};
    public static final String[] NATURE = {"soft-hearted", "forgiving", "hard-hearted", "unforgiving", "jealous", "vengeful"};
    public static final String[] MATERIALISM = {"aesthetic", "intellectualist", "average", "covetous", "greedy", "avaricious"};
    public static final String[] HONESTY = {"scrupulous", "very honorable", "truthful", "average", "average", "average", "liar", "deceitful"};
    public static final String[] BRAVERY = {"normal", "normal", "normal", "foolhardy", "brave", "fearless", "cowardly", "craven"};
    public static final String[] ENERGY = {"slothful", "lazy", "normal", "normal", "normal", "energetic", "energetic", "driven"};
    public static final String[] THRIFT = {"miserly", "mean", "thrifty", "average", "average", "spendthrift", "spendthrift", "wastrel"};
    public static final String[] MORALS = {"aesthetic", "virtuous", "normal", "normal", "lusty", "lusty", "lustful", "immoral", "amoral", "perverted", "sadistic", "depraved"};
    public static final String[] PIETY = {"saintly", "martyr/zealot", "pious", "reverent", "average", "average", "average", "average", "impious", "irreverent", "iconoclastic", "irreligious"};
    public static final String[] INTERESTS_1 = {"religion", "legends", "history", "nature", "horticulture", "husbandry", "exotic animals", "hunting", "fishing", "handicrafts", "athletics", "politics"};
    public static final String[] INTERESTS_2 = {"wines and spirits", "foods and preparation", "gambling", "drugs", "collector", "collector", "collector", "collector", "community service", "altruism", "none", "none"};
    public static final String[] COLLECTIONS = {"knives and daggers", "swords", "weapons", "shields and weapons", "armor", "books and scrolls", "minerals and gems", "ornaments and jewelry", "coins and tokens", "trophies and skins", "porcelain, china, crystal", "artwork"};

    public static final int TENDENCIES_COUNT = 3;

    public static final String[] RACE = {"Dwarf", "Elf", "Gnome", "Half-Elf", "Halfling", "Half-Orc", "Human"};
    public static final int DWARF = 0;
    public static final int ELF = 1;
    public static final int GNOME = 2;
    public static final int HALF_ELF = 3;
    public static final int HALFLING = 4;
    public static final int HALF_ORC = 5;
    public static final int HUMAN = 6;

    public static final String[] SEX = {"Male", "Female"};
    public static final int MALE = 0;
    public static final int FEMALE = 1;

    public static final double DWARF_MALE_HEIGHT_INCHES = 48.0;
    public static final double DWARF_MALE_WEIGHT_POUNDS = 150.0;
    public static final double ELF_MALE_HEIGHT_INCHES = 60.0;
    public static final double ELF_MALE_WEIGHT_POUNDS = 100.0;
    public static final double GNOME_MALE_HEIGHT_INCHES = 42.0;
    public static final double GNOME_MALE_WEIGHT_POUNDS = 80.0;
    public static final double HALF_ELF_MALE_HEIGHT_INCHES = 66.0;
    public static final double HALF_ELF_MALE_WEIGHT_POUNDS = 130.0;
    public static final double HALFLING_MALE_HEIGHT_INCHES = 36.0;
    public static final double HALFLING_MALE_WEIGHT_POUNDS = 60.0;
    public static final double HALF_ORC_MALE_HEIGHT_INCHES = 66.0;
    public static final double HALF_ORC_MALE_WEIGHT_POUNDS = 150.0;
    public static final double HUMAN_MALE_HEIGHT_INCHES = 72.0;
    public static final double HUMAN_MALE_WEIGHT_POUNDS = 175.0;

    public static final double DWARF_FEMALE_HEIGHT_INCHES = 46.0;
    public static final double DWARF_FEMALE_WEIGHT_POUNDS = 120.0;
    public static final double ELF_FEMALE_HEIGHT_INCHES = 54.0;
    public static final double ELF_FEMALE_WEIGHT_POUNDS = 80.0;
    public static final double GNOME_FEMALE_HEIGHT_INCHES = 39.0;
    public static final double GNOME_FEMALE_WEIGHT_POUNDS = 75.0;
    public static final double HALF_ELF_FEMALE_HEIGHT_INCHES = 62.0;
    public static final double HALF_ELF_FEMALE_WEIGHT_POUNDS = 100.0;
    public static final double HALFLING_FEMALE_HEIGHT_INCHES = 33.0;
    public static final double HALFLING_FEMALE_WEIGHT_POUNDS = 50.0;
    public static final double HALF_ORC_FEMALE_HEIGHT_INCHES = 62.0;
    public static final double HALF_ORC_FEMALE_WEIGHT_POUNDS = 120.0;
    public static final double HUMAN_FEMALE_HEIGHT_INCHES = 66.0;
    public static final double HUMAN_FEMALE_WEIGHT_POUNDS = 130.0;
}
