package org.mreposa.dmtools.model.adnd.magic.unusual;

import org.mreposa.dmtools.model.adnd.magic.unusual.extraordinary.ExtraordinaryPower;

import java.util.HashSet;
import java.util.Set;

public class ExtraordinaryPowers {
    private final Set<ExtraordinaryPower> extraordinaryPowerList = new HashSet<>();
    private boolean isSpecialPurpose;

    public Set<ExtraordinaryPower> getExtraordinaryPowerList() {
        return extraordinaryPowerList;
    }

    public void setExtraordinaryPowerList(Set<ExtraordinaryPower> extraordinaryPowerList) {
        this.extraordinaryPowerList.addAll(extraordinaryPowerList);
    }

    public boolean isSpecialPurpose() {
        return isSpecialPurpose;
    }

    public void setSpecialPurpose(boolean isSpecialPurpose) {
        this.isSpecialPurpose = isSpecialPurpose;
    }
}
