package org.mreposa.dmtools.model.adnd.magic;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.roll.Roll;

public class MiscMagicE3 extends MagicItemTable {
    public MiscMagicE3(DiceRollGenerator diceRollGenerator) {
        super(diceRollGenerator);
    }

    @Override
    public String getMagicItem() {
        Roll dieRoll = this.diceRollGenerator.roll(1, 100);
        int roll = dieRoll.getTotal();

        String itemName = "";
        String type = "";
        int typeRoll = 0;

        if (roll < 16) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 16) {
                type = "ebony fly";
            }
            else if (typeRoll < 31) {
                type = "golden lions";
            }
            else if (typeRoll < 41) {
                type = "ivory goats";
            }
            else if (typeRoll < 56) {
                dieRoll = this.diceRollGenerator.roll(1, 100);
                int subTypeRoll = dieRoll.getTotal();
                String subType = "";

                if (typeRoll < 51) {
                    subType = "elephant";
                }
                else if (typeRoll < 51) {
                    subType = "loxodont";
                }
                else if (typeRoll < 51) {
                    subType = "mammoth";
                }
                else {
                    subType = "mastodon";
                }

                type = "marble " + subType;
            }
            else if (typeRoll < 66) {
                type = "obsidian steed";
            }
            else if (typeRoll < 86) {
                type = "onyx dog";
            }
            else {
                type = "serpentine owl";
            }

            itemName = "figurine of wonderous power (" + type + ")";
        }
        else if (roll == 16) {
            itemName = "flask of curses";
        }
        else if (roll < 19) {
            itemName = "gauntlets of dexterity";
        }
        else if (roll < 21) {
            itemName = "gauntlets of fumbling";
        }
        else if (roll < 23) {
            itemName = "gauntlets of ogre power";
        }
        else if (roll < 26) {
            itemName = "gauntlets of swimming and climbing";
        }
        else if (roll == 26) {
            itemName = "gem of brightness";
        }
        else if (roll == 27) {
            itemName = "gem of seeing";
        }
        else if (roll == 28) {
            itemName = "girdle of femininity/masculinity";
        }
        else if (roll == 29) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 31) {
                type = "hill";
            }
            else if (typeRoll < 51) {
                type = "stone";
            }
            else if (typeRoll < 71) {
                type = "frost";
            }
            else if (typeRoll < 86) {
                type = "fire";
            }
            else if (typeRoll < 96) {
                type = "cloud";
            }
            else {
                type = "storm";
            }

            itemName = "girdle of giant strength (" + type + ")";
        }
        else if (roll == 30) {
            itemName = "helm of brilliance";
        }
        else if (roll < 35) {
            itemName = "helm of comprehending languages and reading magic";
        }
        else if (roll < 38) {
            itemName = "helm of opposite alignment";
        }
        else if (roll < 40) {
            itemName = "helm of telepathy";
        }
        else if (roll == 40) {
            itemName = "helm of teleportation";
        }
        else if (roll < 46) {
            itemName = "helm of underwater action";
        }
        else if (roll == 46) {
            itemName = "horn of blasting";
        }
        else if (roll < 49) {
            itemName = "horn of bubbles";
        }
        else if (roll == 49) {
            itemName = "horn of collapsing";
        }
        else if (roll < 54) {
            itemName = "horn of the tritons";
        }
        else if (roll < 61) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 9) {
                type = "silver";
            }
            else if (typeRoll < 16) {
                type = "brass";
            }
            else if (typeRoll < 19) {
                type = "bronze";
            }
            else {
                type = "iron";
            }

            itemName = "horn of Valhalla (" + type + ")";
        }
        else if (roll < 64) {
            itemName = "horseshoes of speed";
        }
        else if (roll < 66) {
            itemName = "horseshoes of a zephyr";
        }
        else if (roll < 71) {
            dieRoll = this.diceRollGenerator.roll(2, 4);
            int count = dieRoll.getTotal();

            itemName = "incense of meditation (" + count + " pieces)";
        }
        else if (roll == 71) {
            dieRoll = this.diceRollGenerator.roll(2, 4);
            int count = dieRoll.getTotal();

            itemName = "incense of obsession (" + count + " pieces)";
        }
        else if (roll == 72) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll == 1) {
                type = "pale blue rhomboid";
            }
            else if (typeRoll == 2) {
                type = "scarlet and blue sphere";
            }
            else if (typeRoll == 3) {
                type = "incandescent blue sphere";
            }
            else if (typeRoll == 4) {
                type = "deep red sphere";
            }
            else if (typeRoll == 5) {
                type = "pink rhomboid";
            }
            else if (typeRoll == 6) {
                type = "pink and green sphere";
            }
            else if (typeRoll == 7) {
                type = "pale green prism";
            }
            else if (typeRoll == 8) {
                type = "clear spindle";
            }
            else if (typeRoll == 9) {
                type = "iridescent spindle";
            }
            else if (typeRoll == 10) {
                type = "pearly white spindle";
            }
            else if (typeRoll == 11) {
                type = "pale lavender ellipsoid";
            }
            else if (typeRoll == 12) {
                type = "lavender and green ellipsoid";
            }
            else if (typeRoll == 13) {
                type = "vibrant purple prism";
            }
            else if (typeRoll == 14) {
                type = "dusty rose prism";
            }
            else {
                type = "dull gray stone";
            }

            itemName = "ioun stone (" + type + ")";
        }
        else if (roll < 80) {
            dieRoll = this.diceRollGenerator.roll(1, 20);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 6) {
                type = "fochlucan bandalore";
            }
            else if (typeRoll < 10) {
                type = "mac-fuirmidh cittern";
            }
            else if (typeRoll < 13) {
                type = "doss lute";
            }
            else if (typeRoll < 16) {
                type = "canaith mandolin";
            }
            else if (typeRoll < 18) {
                type = "cli lyre";
            }
            else if (typeRoll < 20) {
                type = "anstruth harp";
            }
            else {
                type = "ollamh harp";
            }

            itemName = "instrument of the bards (" + type + ")";
        }
        else if (roll < 82) {
            dieRoll = this.diceRollGenerator.roll(1, 100);
            typeRoll = dieRoll.getTotal();

            if (typeRoll < 51) {
                type = "empty";
            }
            else if (typeRoll < 55) {
                type = "air elemental";
            }
            else if (typeRoll < 57) {
                type = "demon type I - III";
            }
            else if (typeRoll == 57) {
                type = "demon type IV - VI";
            }
            else if (typeRoll < 60) {
                type = "lesser devil";
            }
            else if (typeRoll == 60) {
                type = "greater devil";
            }
            else if (typeRoll < 66) {
                type = "djinni";
            }
            else if (typeRoll < 70) {
                type = "earth elemental";
            }
            else if (typeRoll < 73) {
                type = "efreeti";
            }
            else if (typeRoll < 77) {
                type = "fire elemental";
            }
            else if (typeRoll < 82) {
                type = "invisible stalker";
            }
            else if (typeRoll < 84) {
                type = "mezzodaemon";
            }
            else if (typeRoll < 86) {
                type = "night hag";
            }
            else if (typeRoll == 86) {
                type = "nycadaemon";
            }
            else if (typeRoll < 90) {
                type = "rakshasa";
            }
            else if (typeRoll < 94) {
                type = "salamander";
            }
            else if (typeRoll < 98) {
                type = "water elemental";
            }
            else if (typeRoll < 100) {
                type = "wind walker";
            }
            else {
                type = "xorn";
            }

            itemName = "iron flask (" + type + ")";
        }
        else if (roll < 85) {
            dieRoll = this.diceRollGenerator.roll(1, 4);
            int count = dieRoll.getTotal() + 1;

            itemName = "javelin of lightning (" + count + ")";
        }
        else if (roll < 91) {
            dieRoll = this.diceRollGenerator.roll(2, 4);
            int count = dieRoll.getTotal();

            itemName = "javelin of piercing (" + count + ")";
        }
        else if (roll == 91) {
            itemName = "jewel of attacks";
        }
        else if (roll == 92) {
            dieRoll = this.diceRollGenerator.roll(10, 10);
            int count = dieRoll.getTotal();

            itemName = "jewel of flawlessness (" + count + " facets)";
        }
        else {
            dieRoll = this.diceRollGenerator.roll(1, 3);
            int count = dieRoll.getTotal();

            itemName = "Keoghtom's ointment (" + count + " jars)";
        }

        return itemName;
    }
}
