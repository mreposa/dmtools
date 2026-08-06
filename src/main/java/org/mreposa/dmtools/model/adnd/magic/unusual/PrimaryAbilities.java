package org.mreposa.dmtools.model.adnd.magic.unusual;

import org.mreposa.dmtools.model.adnd.magic.unusual.primary.PrimaryAbility;

import java.util.HashSet;
import java.util.Set;

public class PrimaryAbilities {
    private final Set<PrimaryAbility> primaryAbilityList = new HashSet<>();
    private int extraordinaryPowerCount;

    public Set<PrimaryAbility> getPrimaryAbilityList() {
        return primaryAbilityList;
    }

    public void setPrimaryAbilityList(Set<PrimaryAbility> primaryAbilityList) {
        this.primaryAbilityList.addAll(primaryAbilityList);
    }

    public int getExtraordinaryPowerCount() {
        return extraordinaryPowerCount;
    }

    public void setExtraordinaryPowerCount(int extraordinaryPowerCount) {
        this.extraordinaryPowerCount = extraordinaryPowerCount;
    }
}
