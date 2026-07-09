package org.mreposa.dmtools.generator.adnd;

import org.mreposa.dmtools.model.adnd.playerclass.PlayerCharacterClass;
import org.mreposa.dmtools.model.adnd.rollmethod.*;
import org.mreposa.dmtools.model.adnd.race.PlayerCharacterRace;

import java.util.Random;

public class StatGenerator implements org.mreposa.dmtools.generator.StatGenerator {
    private final Random rand;

    public StatGenerator() {
        super();
        this.rand = new Random(System.currentTimeMillis());
    }

    @Override
    public int[] generate(String selectedClass, String selectedRace, String selectedMethod, boolean sortScores) {
        int[] stats = new int[PlayerCharacterClass.AVAILABLE_STATS.length];

        if (selectedClass != null && selectedRace != null && selectedMethod != null && !selectedMethod.isBlank()) {
            PlayerCharacterClass pcClass = PlayerCharacterClass.getPlayerCharacterClass(selectedClass);
            PlayerCharacterRace pcRace = PlayerCharacterRace.getPlayerCharacterRace(selectedRace);

            int[] classMinimums = pcClass.getMinimums();
            int[] raceUpdates = pcRace.getUpdates();
            int[] raceMinimums = pcRace.getMinimums();

            int total = 0;
            StatMethod method;

            int[] preGenRolls = new int[12];

            if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[3])) {
                // Roll 3d6 twelve times, take best 6 scores
                for (int r = 0; r < 12; r++) {
                    for (int i = 0; i < 3; i++) {
                        total = total + rand.nextInt(6) + 1;
                    }
                    preGenRolls[r] = total;
                    total = 0;
                }

                java.util.Arrays.sort(preGenRolls);
            }

            if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[5])) {
                int[][] multiCharRolls = new int[8][12];
                int[] columnTotals = new int[12];

                // Roll 3d6 for 12 characters
                for (int c = 0; c < 12; c++) {
                    for (int r = 0; r < 8; r++) {
                        for (int i = 0; i < 3; i++) {
                            total = total + rand.nextInt(6) + 1;
                        }
                        multiCharRolls[r][c] = total;
                        total = 0;
                    }
                }

                // Add up each character's scores
                for (int c = 0; c < 12; c++) {
                    for (int r = 0; r < 8; r++) {
                        if (r != 1) {
                            total = total + multiCharRolls[r][c];
                        }
                    }
                    columnTotals[c] = total;
                    total = 0;
                }

                // Find the character with the highest score
                int highestColumn = 0;
                int highestValue = columnTotals[0];

                for (int c = 1; c < 12; c++) {
                    if (columnTotals[c] > highestValue) {
                        highestValue = columnTotals[c];
                        highestColumn = c;
                    }
                }

                for (int r = 0; r < 8; r++) {
                    preGenRolls[r] = multiCharRolls[r][highestColumn];
                }
            }

            for (int statSlot = 0; statSlot < PlayerCharacterClass.AVAILABLE_STATS.length; statSlot++) {
                // Generate base stat value
                if (statSlot == PlayerCharacterClass.STAT_EX_STR) {
                    // Generate Exceptional ST value (1 - 100)
                    total = this.rand.nextInt(100) + 1;
                }
                else {
                    if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[1])) {
                        method = new FiveDSixBestThree();
                        total = method.generate(this.rand);
                    } else if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[2])) {
                        method = new FourDSixDropLowest();
                        total = method.generate(this.rand);
                    } else if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[3])) {
                        total = preGenRolls[11 - statSlot];
                    } else if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[4])) {
                        method = new ThreeDSixSixTimes();
                        total = method.generate(this.rand);
                    } else if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[5])) {
                        total = preGenRolls[statSlot];
                    } else {
                        method = new ThreeDSix();
                        total = method.generate(this.rand);
                    }

                    if (total > PlayerCharacterClass.MAX_STAT_VALUE) {
                        total = PlayerCharacterClass.MAX_STAT_VALUE;
                    }
                }

                stats[statSlot] = total;
            }

            if (sortScores) {
                if (selectedMethod.equals(StatMethod.AVAILABLE_METHODS[3])) {
                    int[] prioritizedStats = assignStatsByPriority(selectedClass, stats);
                    System.arraycopy(prioritizedStats, 0, stats, 0, prioritizedStats.length);
                }
                else
                {
                    int[] sortedStats = new int[PlayerCharacterClass.AVAILABLE_STATS.length];
                    sortedStats[0] = stats[0];
                    sortedStats[1] = stats[2];
                    sortedStats[2] = stats[3];
                    sortedStats[3] = stats[4];
                    sortedStats[4] = stats[5];
                    sortedStats[5] = stats[6];
                    sortedStats[6] = stats[7];
                    sortedStats[7] = 0;

                    java.util.Arrays.sort(sortedStats);

                    stats[0] = sortedStats[7];
                    stats[2] = sortedStats[6];
                    stats[3] = sortedStats[5];
                    stats[4] = sortedStats[4];
                    stats[5] = sortedStats[3];
                    stats[6] = sortedStats[2];
                    stats[7] = sortedStats[1];

                    int[] prioritizedStats = assignStatsByPriority(selectedClass, stats);
                    System.arraycopy(prioritizedStats, 0, stats, 0, prioritizedStats.length);
                }
            }

            for (int statSlot = 0; statSlot < PlayerCharacterClass.AVAILABLE_STATS.length; statSlot++) {
                if (statSlot != PlayerCharacterClass.STAT_EX_STR) {
                    total = stats[statSlot];

                    // Adjust stat for race (allows for stat to be higher than PlayerCharacterClass.MAX_STAT_VALUE)
                    total = total + raceUpdates[statSlot];
                    if (total < raceMinimums[statSlot]) {
                        total = raceMinimums[statSlot];
                    }

                    switch (statSlot) {
                        case PlayerCharacterClass.STAT_WIS: {
                            // Cap Wisdom for Barbarian
                            if (selectedClass.equals(PlayerCharacterClass.AVAILABLE_CLASSES[PlayerCharacterClass.CLASS_BARBARIAN]) && total > PlayerCharacterClass.MAX_WIS_STAT_BARBARIAN) {
                                total = PlayerCharacterClass.MAX_WIS_STAT_BARBARIAN;
                            }
                            break;
                        }
                        case PlayerCharacterClass.STAT_COM: {
                            // Adjust Comeliness for Charisma
                            if (stats[PlayerCharacterClass.STAT_CHA] < 3) {
                                total = total - 8;
                            }
                            else if (stats[PlayerCharacterClass.STAT_CHA] == 3) {
                                total = total - 5;
                            }
                            else if (stats[PlayerCharacterClass.STAT_CHA] == 4 || stats[PlayerCharacterClass.STAT_CHA] == 5) {
                                total = total - 3;
                            }
                            else if (stats[PlayerCharacterClass.STAT_CHA] == 6 || stats[PlayerCharacterClass.STAT_CHA] == 7 || stats[PlayerCharacterClass.STAT_CHA] == 8) {
                                total = total - 1;
                            }
                            else if (stats[PlayerCharacterClass.STAT_CHA] == 13 || stats[PlayerCharacterClass.STAT_CHA] == 14 || stats[PlayerCharacterClass.STAT_CHA] == 15) {
                                total = total + 1;
                            }
                            else if (stats[PlayerCharacterClass.STAT_CHA] == 16 || stats[PlayerCharacterClass.STAT_CHA] == 17) {
                                total = total + 2;
                            }
                            else if (stats[PlayerCharacterClass.STAT_CHA] == 18) {
                                total = total + 3;
                            }
                            else if (stats[PlayerCharacterClass.STAT_CHA] > 18) {
                                total = total + 5;
                            }

                            // Cap Comeliness for character from the Prime Material Plane
                            if (total > PlayerCharacterClass.MAX_COM_STAT_VALUE) {
                                total = PlayerCharacterClass.MAX_COM_STAT_VALUE;
                            }
                            break;
                        }
                        default: {
                            break;
                        }
                    }

                    // Adjust minimum stats for class to ensure selected class minimums are met
                    if (total < classMinimums[statSlot]) {
                        total = classMinimums[statSlot];
                    }

                    stats[statSlot] = total;
                }
            }
        }

        return stats;
    }

    private int[] assignStatsByPriority(String selectedClass, int[] stats) {
        int[] prioritizedStats = new int[PlayerCharacterClass.AVAILABLE_STATS.length];

        PlayerCharacterClass pcClass = PlayerCharacterClass.getPlayerCharacterClass(selectedClass);
        int[] priorities = pcClass.getPriorities();

        prioritizedStats[priorities[0]] = stats[0];
        prioritizedStats[1] = stats[1];
        prioritizedStats[priorities[1]] = stats[2];
        prioritizedStats[priorities[2]] = stats[3];
        prioritizedStats[priorities[3]] = stats[4];
        prioritizedStats[priorities[4]] = stats[5];
        prioritizedStats[priorities[5]] = stats[6];
        prioritizedStats[priorities[6]] = stats[7];

        return prioritizedStats;
    }
}
