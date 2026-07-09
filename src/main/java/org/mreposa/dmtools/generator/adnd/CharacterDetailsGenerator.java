package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.details.*;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CharacterDetailsGenerator {
    private final DiceRollGenerator diceRollGenerator;

    public CharacterDetailsGenerator() {
        this.diceRollGenerator = new DiceRollGenerator();
    }

    public CharacterDetailsGenerator(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public CharacterDetails generate(int race, int sex) {
        CharacterDetails details = new CharacterDetails();
        Roll roll;
        int rollValue;
        int columnValue;

        /* FACTS */

        roll = this.diceRollGenerator.roll(1, 10);
        rollValue = roll.getTotal() - 1;
        details.setAlignment(CharacterDetailsTable.ALIGNMENT[rollValue]);

        roll = this.diceRollGenerator.roll(1, 10);
        rollValue = roll.getTotal() - 1;
        details.setWealth(CharacterDetailsTable.WEALTH[rollValue]);

        roll = this.diceRollGenerator.roll(1, 10);
        rollValue = roll.getTotal() - 1;
        details.setAge(CharacterDetailsTable.AGE[rollValue]);

        roll = this.diceRollGenerator.roll(1, 10);
        rollValue = roll.getTotal() - 1;
        details.setAppearance(CharacterDetailsTable.APPEARANCE[rollValue]);

        String insanity = "";
        roll = this.diceRollGenerator.roll(1, 10);
        rollValue = roll.getTotal() - 1;
        if (rollValue == 8 || rollValue == 9) {
            // Re-roll insane or maniacal; only use these if they come up a second time
            roll = this.diceRollGenerator.roll(1, 10);
            rollValue = roll.getTotal() - 1;

            if (rollValue == 8) {
                // Roll type of insanity
                roll = this.diceRollGenerator.roll(1, 20);
                insanity = " (" + CharacterDetailsTable.INSANITIES[(roll.getTotal() - 1)] + ")";
            }
        }
        details.setSanity(CharacterDetailsTable.SANITY[rollValue] + insanity);

        /* TRAITS */

        HashSet<String> tendencySet = new HashSet<>();
        String tendency;
        for (int i = 0; i < CharacterDetailsTable.TENDENCIES_COUNT; i++) {
            do {
                roll = this.diceRollGenerator.roll(1, 6);
                columnValue = roll.getTotal();

                roll = this.diceRollGenerator.roll(1, 12);
                rollValue = roll.getTotal() - 1;

                if (columnValue < 4) {
                    tendency = CharacterDetailsTable.TENDENCIES_1[rollValue];
                } else {
                    tendency = CharacterDetailsTable.TENDENCIES_2[rollValue];
                }
            } while (!tendencySet.add(tendency));
        }
        details.setTendencies(tendencySet.toArray(details.getTendencies()));

        roll = this.diceRollGenerator.roll(1, 8);
        columnValue = roll.getTotal();
        roll = this.diceRollGenerator.roll(1, 8);
        rollValue = roll.getTotal() - 1;

        if (columnValue < 6) {
            details.setPersonality(CharacterDetailsTable.PERSONALITY_1[rollValue]);
        }
        else if (columnValue < 8) {
            details.setPersonality(CharacterDetailsTable.PERSONALITY_2[rollValue]);
        }
        else {
            details.setPersonality(CharacterDetailsTable.PERSONALITY_3[rollValue]);
        }

        roll = this.diceRollGenerator.roll(1, 10);
        rollValue = roll.getTotal() - 1;
        details.setDisposition(CharacterDetailsTable.DISPOSITION[rollValue]);

        roll = this.diceRollGenerator.roll(1, 10);
        rollValue = roll.getTotal() - 1;
        details.setIntellect(CharacterDetailsTable.INTELLECT[rollValue]);

        roll = this.diceRollGenerator.roll(1, 6);
        rollValue = roll.getTotal() - 1;
        details.setNature(CharacterDetailsTable.NATURE[rollValue]);

        roll = this.diceRollGenerator.roll(1, 6);
        rollValue = roll.getTotal() - 1;
        details.setMaterialism(CharacterDetailsTable.MATERIALISM[rollValue]);

        roll = this.diceRollGenerator.roll(1, 8);
        rollValue = roll.getTotal() - 1;
        details.setHonesty(CharacterDetailsTable.HONESTY[rollValue]);

        roll = this.diceRollGenerator.roll(1, 8);
        rollValue = roll.getTotal() - 1;
        details.setBravery(CharacterDetailsTable.BRAVERY[rollValue]);

        roll = this.diceRollGenerator.roll(1, 8);
        rollValue = roll.getTotal() - 1;
        details.setEnergy(CharacterDetailsTable.ENERGY[rollValue]);

        roll = this.diceRollGenerator.roll(1, 8);
        rollValue = roll.getTotal() - 1;
        details.setThrift(CharacterDetailsTable.THRIFT[rollValue]);

        roll = this.diceRollGenerator.roll(1, 12);
        rollValue = roll.getTotal() - 1;
        if (rollValue == 9 || rollValue == 10 || rollValue == 11) {
            // Re-roll perverted, sadistic, or depraved; only use these if they come up a second time
            roll = this.diceRollGenerator.roll(1, 12);
            rollValue = roll.getTotal() - 1;
        }
        details.setMorals(CharacterDetailsTable.MORALS[rollValue]);

        roll = this.diceRollGenerator.roll(1, 12);
        rollValue = roll.getTotal() - 1;
        details.setPiety(CharacterDetailsTable.PIETY[rollValue]);

        roll = this.diceRollGenerator.roll(1, 6);
        columnValue = roll.getTotal();
        roll = this.diceRollGenerator.roll(1, 12);
        rollValue = roll.getTotal() - 1;

        if (columnValue < 4) {
            details.setInterests(CharacterDetailsTable.INTERESTS_1[rollValue]);
        }
        else {
            String collection = "";
            if (rollValue == 4 || rollValue == 5 || rollValue == 6 || rollValue == 7) {
                // Determine type of collection
                roll = this.diceRollGenerator.roll(1, 12);
                int collectionValue = roll.getTotal() - 1;
                collection = " (" + CharacterDetailsTable.COLLECTIONS[collectionValue] + ")";
            }
            details.setInterests(CharacterDetailsTable.INTERESTS_2[rollValue] + collection);
        }

        /* HEIGHT AND WEIGHT */

        double height;
        boolean heightUnder = false;
        boolean heightOver = false;
        boolean avgHeightUnder = false;
        boolean avgHeightOver = false;
        double weight;
        boolean weightUnder = false;
        boolean weightOver = false;
        boolean avgWeightUnder = false;
        boolean avgWeightOver = false;
        double adjustmentRoll;

        roll = this.diceRollGenerator.roll(1, 100);
        int heightRoll = roll.getTotal();
        roll = this.diceRollGenerator.roll(1, 100);
        int weightRoll = roll.getTotal();
        roll = this.diceRollGenerator.roll(1, 100);
        int avgRoll = roll.getTotal();

        if (race == CharacterDetailsTable.DWARF) {
            if (heightRoll < 16) {
                heightUnder = true;
            }
            else if (heightRoll > 80) {
                heightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgHeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgHeightOver = true;
                }
            }

            if (weightRoll < 21) {
                weightUnder = true;
            }
            else if (weightRoll > 65) {
                weightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgWeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgWeightOver = true;
                }
            }

            if (sex == CharacterDetailsTable.FEMALE) {
                height = CharacterDetailsTable.DWARF_FEMALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.DWARF_FEMALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(2, 8);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(2, 10);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
            else {
                height = CharacterDetailsTable.DWARF_MALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.DWARF_MALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(2, 8);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(2, 12);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
        }
        else if (race == CharacterDetailsTable.ELF) {
            if (heightRoll < 11) {
                heightUnder = true;
            }
            else if (heightRoll > 80) {
                heightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgHeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgHeightOver = true;
                }
            }

            if (weightRoll < 16) {
                weightUnder = true;
            }
            else if (weightRoll > 90) {
                weightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgWeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgWeightOver = true;
                }
            }

            if (sex == CharacterDetailsTable.FEMALE) {
                height = CharacterDetailsTable.ELF_FEMALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.ELF_FEMALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(1, 10);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(2, 6);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
            else {
                height = CharacterDetailsTable.ELF_MALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.ELF_MALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(1, 10);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(1, 20);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
        }
        else if (race == CharacterDetailsTable.GNOME) {
            if (heightRoll < 21) {
                heightUnder = true;
            }
            else if (heightRoll > 85) {
                heightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgHeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgHeightOver = true;
                }
            }

            if (weightRoll < 21) {
                weightUnder = true;
            }
            else if (weightRoll > 75) {
                weightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgWeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgWeightOver = true;
                }
            }

            if (sex == CharacterDetailsTable.FEMALE) {
                height = CharacterDetailsTable.GNOME_FEMALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.GNOME_FEMALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
            else {
                height = CharacterDetailsTable.GNOME_MALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.GNOME_MALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(2, 4);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(2, 6);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
        }
        else if (race == CharacterDetailsTable.HALF_ELF) {
            if (heightRoll < 36) {
                heightUnder = true;
            }
            else if (heightRoll > 90) {
                heightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgHeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgHeightOver = true;
                }
            }

            if (weightRoll < 21) {
                weightUnder = true;
            }
            else if (weightRoll > 85) {
                weightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgWeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgWeightOver = true;
                }
            }

            if (sex == CharacterDetailsTable.FEMALE) {
                height = CharacterDetailsTable.HALF_ELF_FEMALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HALF_ELF_FEMALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(1, 12);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(2, 8);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
            else {
                height = CharacterDetailsTable.HALF_ELF_MALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HALF_ELF_MALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(1, 20);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(1, 20);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
        }
        else if (race == CharacterDetailsTable.HALFLING) {
            if (heightRoll < 11) {
                heightUnder = true;
            }
            else if (heightRoll > 90) {
                heightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgHeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgHeightOver = true;
                }
            }

            if (weightRoll < 11) {
                weightUnder = true;
            }
            else if (weightRoll > 50) {
                weightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgWeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgWeightOver = true;
                }
            }

            if (sex == CharacterDetailsTable.FEMALE) {
                height = CharacterDetailsTable.HALFLING_FEMALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HALFLING_FEMALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(2, 4);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(2, 4);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
            else {
                height = CharacterDetailsTable.HALFLING_MALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HALFLING_MALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(2, 4);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(2, 6);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
        }
        else if (race == CharacterDetailsTable.HALF_ORC) {
            if (heightRoll < 46) {
                heightUnder = true;
            }
            else if (heightRoll > 75) {
                heightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgHeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgHeightOver = true;
                }
            }

            if (weightRoll < 31) {
                weightUnder = true;
            }
            else if (weightRoll > 55) {
                weightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgWeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgWeightOver = true;
                }
            }

            if (sex == CharacterDetailsTable.FEMALE) {
                height = CharacterDetailsTable.HALF_ORC_FEMALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HALF_ORC_FEMALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 3);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(3, 6);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(4, 8);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
            else {
                height = CharacterDetailsTable.HALF_ORC_MALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HALF_ORC_MALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 4);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(2, 8);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(4, 10);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
        }
        else {
            if (heightRoll < 21) {
                heightUnder = true;
            }
            else if (heightRoll > 80) {
                heightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgHeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgHeightOver = true;
                }
            }

            if (weightRoll < 26) {
                weightUnder = true;
            }
            else if (weightRoll > 75) {
                weightOver = true;
            }
            else {
                if (avgRoll < 31) {
                    avgWeightUnder = true;
                }
                else if (avgRoll > 70) {
                    avgWeightOver = true;
                }
            }

            if (sex == CharacterDetailsTable.FEMALE) {
                height = CharacterDetailsTable.HUMAN_FEMALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HUMAN_FEMALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 6);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(3, 10);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(4, 12);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
            else {
                height = CharacterDetailsTable.HUMAN_MALE_HEIGHT_INCHES;
                weight = CharacterDetailsTable.HUMAN_MALE_WEIGHT_POUNDS;

                if (heightUnder) {
                    roll = this.diceRollGenerator.roll(1, 12);
                    adjustmentRoll = roll.getTotal();

                    height = height - adjustmentRoll;
                }
                else if (heightOver) {
                    roll = this.diceRollGenerator.roll(1, 12);
                    adjustmentRoll = roll.getTotal();

                    height = height + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = 1 + ((roll.getTotal() - 1) * 0.5);

                    if (avgHeightUnder) {
                        height = height - adjustmentRoll;
                    }
                    else if (avgHeightOver) {
                        height = height + adjustmentRoll;
                    }
                }

                if (weightUnder) {
                    roll = this.diceRollGenerator.roll(3, 12);
                    adjustmentRoll = roll.getTotal();

                    weight = weight - adjustmentRoll;
                }
                else if (weightOver) {
                    roll = this.diceRollGenerator.roll(5, 12);
                    adjustmentRoll = roll.getTotal();

                    weight = weight + adjustmentRoll;
                }
                else {
                    roll = this.diceRollGenerator.roll(1, 8);
                    adjustmentRoll = roll.getTotal();

                    if (avgWeightUnder) {
                        weight = weight - adjustmentRoll;
                    }
                    else if (avgWeightOver) {
                        weight = weight + adjustmentRoll;
                    }
                }
            }
        }

        details.setHeight(height);
        details.setWeight(weight);

        List<String> secondarySkills = secondarySkills();
        details.setSecondarySkills(secondarySkills);

        return details;
    }

    private List<String> secondarySkills() {
        ArrayList<String> skills = new ArrayList<>();
        String skill = rollSecondarySkill();

        if (!skill.equals(CharacterDetailsTable.SECONDARY_SKILLS[22])) {
            skills.add(skill);
        }
        else {
            // Roll for two skills
            int count = 0;
            while (count < 2) {
                skill = rollSecondarySkill();
                if (!skill.equals(CharacterDetailsTable.SECONDARY_SKILLS[21]) && !skill.equals(CharacterDetailsTable.SECONDARY_SKILLS[22])) {
                    skills.add(skill);
                    count++;
                }
            }
        }

        return skills;
    }

    private String rollSecondarySkill() {
        String skill = "unknown";

        Roll roll = this.diceRollGenerator.roll(1, 100);
        int total = roll.getTotal();

        if (total < 3) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[0];
        }
        else if (total < 5) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[1];
        }
        else if (total < 11) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[2];
        }
        else if (total < 15) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[3];
        }
        else if (total < 21) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[4];
        }
        else if (total < 24) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[5];
        }
        else if (total < 28) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[6];
        }
        else if (total < 33) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[7];
        }
        else if (total < 35) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[8];
        }
        else if (total < 38) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[9];
        }
        else if (total < 40) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[10];
        }
        else if (total < 43) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[11];
        }
        else if (total < 45) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[12];
        }
        else if (total < 47) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[13];
        }
        else if (total < 50) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[14];
        }
        else if (total < 52) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[15];
        }
        else if (total < 55) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[16];
        }
        else if (total < 58) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[17];
        }
        else if (total < 61) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[18];
        }
        else if (total < 65) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[19];
        }
        else if (total < 68) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[20];
        }
        else if (total < 86) {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[21];
        }
        else {
            skill = CharacterDetailsTable.SECONDARY_SKILLS[22];
        }

        return skill;
    }
}
