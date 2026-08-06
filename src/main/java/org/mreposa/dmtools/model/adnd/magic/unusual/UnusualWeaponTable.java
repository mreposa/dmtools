package org.mreposa.dmtools.model.adnd.magic.unusual;

import org.mreposa.dmtools.generator.adnd.DiceRollGenerator;
import org.mreposa.dmtools.model.adnd.magic.unusual.extraordinary.*;
import org.mreposa.dmtools.model.adnd.magic.unusual.primary.*;
import org.mreposa.dmtools.model.roll.Roll;

import java.util.Set;

public class UnusualWeaponTable {
    private final DiceRollGenerator diceRollGenerator;

    public UnusualWeaponTable(DiceRollGenerator diceRollGenerator) {
        this.diceRollGenerator = diceRollGenerator;
    }

    public UnusualWeapon generateUnusualWeapon() {
        UnusualWeapon weapon = new UnusualWeapon();
        int primaryAbilityCount;
        int extraordinaryPowerCount = 0;

        Roll roll = this.diceRollGenerator.roll(1, 100);
        int value = roll.getTotal();

        if (value > 75) {
            weapon.setUnusual(true);
            weapon.setAlignment(getAlignment());
            weapon.setLanguages(getLanguages(false));

            if (value < 84) {
                weapon.setIntelligenceScore(12);
                weapon.setCommunication("semi-empathy");
                primaryAbilityCount = 1;
            }
            else if (value < 90) {
                weapon.setIntelligenceScore(13);
                weapon.setCommunication("empathy");
                primaryAbilityCount = 2;
            }
            else if (value < 95) {
                weapon.setIntelligenceScore(14);
                weapon.setCommunication("speech");
                primaryAbilityCount = 2;
            }
            else if (value < 98) {
                weapon.setIntelligenceScore(15);
                weapon.setCommunication("speech");
                primaryAbilityCount = 3;
            }
            else if (value < 100) {
                weapon.setIntelligenceScore(16);
                weapon.setCommunication("speech (read languages and non-magical maps)");
                primaryAbilityCount = 3;
            }
            else {
                weapon.setIntelligenceScore(17);
                weapon.setCommunication("speech and telepathy (read languages and magical writings)");
                primaryAbilityCount = 3;
                extraordinaryPowerCount = 1;
            }

            PrimaryAbilities primaryAbilities = getPrimaryAbilities(primaryAbilityCount, extraordinaryPowerCount);
            weapon.setPrimaryAbilities(primaryAbilities.getPrimaryAbilityList());

            extraordinaryPowerCount = primaryAbilities.getExtraordinaryPowerCount();
            ExtraordinaryPowers extraordinaryPowers = getExtraordinaryPowers(extraordinaryPowerCount);
            weapon.setExtraordinaryPowers(extraordinaryPowers.getExtraordinaryPowerList());

            if (extraordinaryPowers.isSpecialPurpose()) {
                String specialPurpose = getSpecialPurpose();
                String specialPurposePower = getSpecialPurposePower();

                weapon.setSpecialPurpose(true);
                weapon.setSpecialPurpose(specialPurpose);
                weapon.setSpecialPurposePower(specialPurposePower);
            }
        }

        return weapon;
    }

    private String getAlignment() {
        String alignment;

        Roll roll = this.diceRollGenerator.roll(1, 100);
        int value = roll.getTotal();

        if (value < 6) {
            alignment = "chaotic good";
        }
        else if (value < 16) {
            alignment = "chaotic neutral";
        }
        else if (value < 21) {
            alignment = "chaotic evil";
        }
        else if (value < 26) {
            alignment = "neutral evil";
        }
        else if (value < 31) {
            alignment = "lawful evil";
        }
        else if (value < 56) {
            alignment = "lawful good";
        }
        else if (value < 61) {
            alignment = "lawful neutral";
        }
        else if (value < 81) {
            alignment = "neutral";
        }
        else {
            alignment = "neutral good";
        }

        return alignment;
    }

    /* Recursive function */
    private int getLanguages(boolean ignore) {
        int languages = 0;

        Roll roll = this.diceRollGenerator.roll(1, 100);
        int value = roll.getTotal();

        if (value < 41) {
            languages = 1;
        }
        else if (value < 71) {
            languages = 2;
        }
        else if (value < 86) {
            languages = 3;
        }
        else if (value < 96) {
            languages = 4;
        }
        else if (value < 100) {
            languages = 5;
        }
        else {
            if (!ignore) {
                languages = 6;
                int rollTwice = 0;

                int rollCount = 0;
                while (rollCount < 2) {
                    int v = getLanguages(true);
                    rollTwice = rollTwice + v;
                    rollCount++;
                }

                if (rollTwice > languages) {
                    languages = rollTwice;
                }
            }
        }

        return languages;
    }

    private PrimaryAbilities getPrimaryAbilities(int primaryAbilityCount, int extraordinaryPowerCount) {
        PrimaryAbilities primaryAbilities = new PrimaryAbilities();
        Set<PrimaryAbility> primaryAbilityList = primaryAbilities.getPrimaryAbilityList();
        PrimaryAbility primaryAbility;

        for  (int i = 0; i < primaryAbilityCount; i++) {
            primaryAbility = getPrimaryAbility(false);

            if (primaryAbility instanceof AddExtraordinary) {
                extraordinaryPowerCount++;
            }
            else if (primaryAbility instanceof RollTwice) {
                primaryAbility = getPrimaryAbility(true);
                primaryAddIncrement(primaryAbility, primaryAbilityList);

                primaryAbility = getPrimaryAbility(true);
                primaryAddIncrement(primaryAbility, primaryAbilityList);
            }
            else {
                primaryAddIncrement(primaryAbility, primaryAbilityList);
            }
        }

        primaryAbilities.setPrimaryAbilityList(primaryAbilityList);
        primaryAbilities.setExtraordinaryPowerCount(extraordinaryPowerCount);

        return primaryAbilities;
    }

    private void primaryAddIncrement(PrimaryAbility primaryAbility, Set<PrimaryAbility> primaryAbilityList) {
        if (primaryAbility == null) {
            throw new IllegalArgumentException("primaryAbility is null");
        }

        if (primaryAbilityList == null) {
            throw new IllegalArgumentException("primaryAbilityList is null");
        }

        if (!primaryAbilityList.contains(primaryAbility)) {
            primaryAbilityList.add(primaryAbility);
        }
        else {
            for (PrimaryAbility ability : primaryAbilityList) {
                if (ability.equals(primaryAbility)) {
                    ability.incrementRange();
                }
            }
        }
    }

    private PrimaryAbility getPrimaryAbility(boolean ignore) {
        PrimaryAbility primaryAbility = null;

        while (primaryAbility == null) {
            Roll roll = this.diceRollGenerator.roll(1, 100);
            int value = roll.getTotal();

            if (value < 12) {
                primaryAbility = new DetectShifting();
            } else if (value < 23) {
                primaryAbility = new DetectSloping();
            } else if (value < 34) {
                primaryAbility = new DetectTraps();
            } else if (value < 45) {
                primaryAbility = new DetectAlignment();
            } else if (value < 56) {
                primaryAbility = new DetectMetals();
            } else if (value < 67) {
                primaryAbility = new DetectGems();
            } else if (value < 78) {
                primaryAbility = new DetectMagic();
            } else if (value < 83) {
                primaryAbility = new DetectSecret();
            } else if (value < 88) {
                primaryAbility = new DetectInvisible();
            } else if (value < 93) {
                primaryAbility = new LocateObject();
            } else if (value < 99) {
                if (!ignore) {
                    primaryAbility = new RollTwice();
                }
            } else {
                if (!ignore) {
                    primaryAbility = new AddExtraordinary();
                }
            }
        }

        return primaryAbility;
    }

    private ExtraordinaryPowers getExtraordinaryPowers(int extraordinaryPowerCount) {
        ExtraordinaryPowers extraordinaryPowers = new ExtraordinaryPowers();
        Set<ExtraordinaryPower> extraordinaryPowerList = extraordinaryPowers.getExtraordinaryPowerList();
        ExtraordinaryPower extraordinaryPower;

        for  (int i = 0; i < extraordinaryPowerCount; i++) {
            extraordinaryPower = getExtraordinaryPower(false);

            if (extraordinaryPower instanceof ChoosePower) {
                // Roll a new power instead of choosing one
                extraordinaryPower = getExtraordinaryPower(true);
                extraordinaryAddIncrement(extraordinaryPower, extraordinaryPowerList);
            }
            else if (extraordinaryPower instanceof ChooseSpecial) {
                // Roll a new power instead of choosing one
                extraordinaryPower = getExtraordinaryPower(true);
                extraordinaryAddIncrement(extraordinaryPower, extraordinaryPowerList);
                extraordinaryPowers.setSpecialPurpose(true);
            }
            else if (extraordinaryPower instanceof RollTwiceEx) {
                extraordinaryPower = getExtraordinaryPower(true);
                extraordinaryAddIncrement(extraordinaryPower, extraordinaryPowerList);

                extraordinaryPower = getExtraordinaryPower(true);
                extraordinaryAddIncrement(extraordinaryPower, extraordinaryPowerList);
            }
            else {
                extraordinaryAddIncrement(extraordinaryPower, extraordinaryPowerList);
            }
        }

        extraordinaryPowers.setExtraordinaryPowerList(extraordinaryPowerList);

        return extraordinaryPowers;
    }

    private void extraordinaryAddIncrement(ExtraordinaryPower extraordinaryPower, Set<ExtraordinaryPower> extraordinaryPowerList) {
        if (extraordinaryPower == null) {
            throw new IllegalArgumentException("extraordinaryPower is null");
        }

        if (extraordinaryPowerList == null) {
            throw new IllegalArgumentException("extraordinaryPowerList is null");
        }

        if (!extraordinaryPowerList.contains(extraordinaryPower)) {
            extraordinaryPowerList.add(extraordinaryPower);
        }
        else {
            for (ExtraordinaryPower power : extraordinaryPowerList) {
                if (power.equals(extraordinaryPower)) {
                    power.incrementUses();
                }
            }
        }
    }

    private ExtraordinaryPower getExtraordinaryPower(boolean ignore) {
        ExtraordinaryPower extraordinaryPower = null;

        while (extraordinaryPower == null) {
            Roll roll = this.diceRollGenerator.roll(1, 100);
            int value = roll.getTotal();

            if (value < 8) {
                extraordinaryPower = new CharmPerson();
            } else if (value < 16) {
                extraordinaryPower = new Clairaudience();
            } else if (value < 23) {
                extraordinaryPower = new Clairvoyance();
            } else if (value < 29) {
                extraordinaryPower = new DirectionDepth();
            } else if (value < 35) {
                extraordinaryPower = new ESP();
            } else if (value < 42) {
                extraordinaryPower = new Flying();
            } else if (value < 48) {
                extraordinaryPower = new Heal();
            } else if (value < 55) {
                extraordinaryPower = new Illusion();
            } else if (value < 62) {
                extraordinaryPower = new Levitation();
            } else if (value < 68) {
                extraordinaryPower = new Strength();
            } else if (value < 76) {
                extraordinaryPower = new Telekinesis();
            } else if (value < 82) {
                extraordinaryPower = new Telepathy();
            } else if (value < 89) {
                extraordinaryPower = new Teleportation();
            } else if (value < 95) {
                extraordinaryPower = new XrayVision();
            } else if (value < 98) {
                if (!ignore) {
                    extraordinaryPower = new RollTwiceEx();
                }
            } else if (value < 99) {
                if (!ignore) {
                    extraordinaryPower = new ChoosePower();
                }
            } else {
                if (!ignore) {
                    extraordinaryPower = new ChooseSpecial();
                }
            }
        }

        return extraordinaryPower;
    }

    private String getSpecialPurpose() {
        String purpose;

        Roll roll = this.diceRollGenerator.roll(1, 100);
        int value = roll.getTotal();

        if (value < 11) {
            purpose = "defeat/slay diametrically opposed alignment";
        }
        else if (value < 21) {
            purpose = "kill clerics";
        }
        else if (value < 31) {
            purpose = "kill fighters";
        }
        else if (value < 41) {
            purpose = "kill magic-users";
        }
        else if (value < 51) {
            purpose = "kill thieves";
        }
        else if (value < 56) {
            purpose = "kill bards/monks";
        }
        else if (value < 66) {
            purpose = "overthrow law and/or chaos";
        }
        else if (value < 76) {
            purpose = "slay good and/or evil";
        }
        else {
            purpose = "slay non-human monsters";
        }

        return purpose;
    }

    private String getSpecialPurposePower() {
        String purposePower;

        Roll roll = this.diceRollGenerator.roll(1, 100);
        int value = roll.getTotal();

        if (value < 11) {
            purposePower = "blindness for 2-12 rounds";
        }
        else if (value < 21) {
            purposePower = "confusion for 2-12 rounds";
        }
        else if (value < 26) {
            purposePower = "disintegrate";
        }
        else if (value < 56) {
            purposePower = "fear for 1-4 rounds";
        }
        else if (value < 66) {
            purposePower = "insanity for 1-4 rounds";
        }
        else if (value < 81) {
            purposePower = "paralysis for 1-4 rounds";
        }
        else {
            purposePower = "+2 on all saving throws, -1 on each die of damage sustained";
        }

        return purposePower;
    }
}
