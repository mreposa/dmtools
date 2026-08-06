package org.mreposa.dmtools.model.adnd.magic.unusual;

import org.mreposa.dmtools.model.adnd.magic.unusual.extraordinary.ExtraordinaryPower;
import org.mreposa.dmtools.model.adnd.magic.unusual.primary.PrimaryAbility;

import java.util.HashSet;
import java.util.Set;

public class UnusualWeapon {
    private boolean isUnusual = false;
    private int intelligenceScore = 0;
    private String communication;
    private String alignment;
    private int languages;
    private final Set<PrimaryAbility> primaryAbilities = new HashSet<>();
    private final Set<ExtraordinaryPower> extraordinaryPowers = new HashSet<>();
    private boolean isSpecialPurpose = false;
    private String specialPurpose;
    private String specialPurposePower;

    public boolean isUnusual() {
        return isUnusual;
    }

    public void setUnusual(boolean unusual) {
        isUnusual = unusual;
    }

    public int getIntelligenceScore() {
        return intelligenceScore;
    }

    public void setIntelligenceScore(int intelligenceScore) {
        this.intelligenceScore = intelligenceScore;
    }

    public String getCommunication() {
        return communication;
    }

    public void setCommunication(String communication) {
        this.communication = communication;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getLanguages() {
        return languages;
    }

    public void setLanguages(int languages) {
        this.languages = languages;
    }

    public Set<PrimaryAbility> getPrimaryAbilities() {
        return primaryAbilities;
    }

    public void setPrimaryAbilities(Set<PrimaryAbility> primaryAbilities) {
        this.primaryAbilities.addAll(primaryAbilities);
    }

    public Set<ExtraordinaryPower> getExtraordinaryPowers() {
        return extraordinaryPowers;
    }

    public void setExtraordinaryPowers(Set<ExtraordinaryPower> extraordinaryPowers) {
        this.extraordinaryPowers.addAll(extraordinaryPowers);
    }

    public boolean isSpecialPurpose() {
        return isSpecialPurpose;
    }

    public void setSpecialPurpose(boolean specialPurpose) {
        isSpecialPurpose = specialPurpose;
    }

    public String getSpecialPurpose() {
        return specialPurpose;
    }

    public void setSpecialPurpose(String specialPurpose) {
        this.specialPurpose = specialPurpose;
    }

    public String getSpecialPurposePower() {
        return specialPurposePower;
    }

    public void setSpecialPurposePower(String specialPurposePower) {
        this.specialPurposePower = specialPurposePower;
    }
}
