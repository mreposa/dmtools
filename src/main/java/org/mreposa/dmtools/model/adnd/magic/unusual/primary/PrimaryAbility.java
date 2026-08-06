package org.mreposa.dmtools.model.adnd.magic.unusual.primary;

public abstract class PrimaryAbility {
    private final String text;
    private final int baseRange;
    private int range;

    public PrimaryAbility(String text, int baseRange) {
        this.text = text;
        this.baseRange = baseRange;
        this.range = baseRange;
    }

    public String getText() {
        return text;
    }

    public int getBaseRange() {
        return baseRange;
    }

    public int getRange() {
        return range;
    }

    public void incrementRange() {
        this.range = this.range + this.baseRange;
    }

    @Override
    public boolean equals(Object obj) {
        // 1. Check for identity (same memory address)
        if (this == obj) return true;

        // 2. Check for null and ensure exact class match
        if (obj == null || this.getClass() != obj.getClass()) return false;

        // 3. Cast obj to the correct type
        PrimaryAbility other = (PrimaryAbility) obj;

        // 4. Compare relevant fields
        // Use Objects.equals() for objects, == for primitives
        return java.util.Objects.equals(this.text, other.getText()) && this.baseRange == other.getBaseRange();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.text, this.baseRange);
    }
}
