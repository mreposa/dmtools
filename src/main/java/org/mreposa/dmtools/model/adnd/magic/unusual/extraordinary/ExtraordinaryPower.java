package org.mreposa.dmtools.model.adnd.magic.unusual.extraordinary;

public abstract class ExtraordinaryPower {
    private final String text;
    private final int baseUses;
    private int uses;
    private final String frequency;
    private final String duration;

    public ExtraordinaryPower(String text, int baseUses, String frequency, String duration) {
        this.text = text;
        this.baseUses = baseUses;
        this.uses = baseUses;
        this.frequency = frequency;
        this.duration = duration;
    }

    public String getText() {
        return text;
    }

    public int getBaseUses() {
        return baseUses;
    }

    public int getUses() {
        return uses;
    }

    public void incrementUses() {
        this.uses = this.uses + this.baseUses;
    }

    public String getFrequency() { return frequency; }

    public String getDuration() { return duration; }

    @Override
    public boolean equals(Object obj) {
        // 1. Check for identity (same memory address)
        if (this == obj) return true;

        // 2. Check for null and ensure exact class match
        if (obj == null || this.getClass() != obj.getClass()) return false;

        // 3. Cast obj to the correct type
        ExtraordinaryPower other = (ExtraordinaryPower) obj;

        // 4. Compare relevant fields
        // Use Objects.equals() for objects, == for primitives
        return java.util.Objects.equals(this.text, other.getText()) &&
                this.baseUses == other.getBaseUses() &&
                java.util.Objects.equals(this.frequency, other.getFrequency()) &&
                java.util.Objects.equals(this.duration, other.getDuration());
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(this.text, this.baseUses, this.frequency, this.duration);
    }
}
