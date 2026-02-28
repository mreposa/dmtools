package org.mreposa.dmtools.model.adnd.details;

public class CharacterDetails {
    private double height;
    private double weight;
    private String alignment;
    private String wealth;
    private String age;
    private String appearance;
    private String sanity;
    private String[] tendencies;
    private String personality;
    private String disposition;
    private String intellect;
    private String nature;
    private String materialism;
    private String honesty;
    private String bravery;
    private String energy;
    private String thrift;
    private String morals;
    private String piety;
    private String interests;

    public CharacterDetails() {
        this.tendencies = new String[3];
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public String getWealth() {
        return wealth;
    }

    public void setWealth(String wealth) {
        this.wealth = wealth;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getSanity() {
        return sanity;
    }

    public void setSanity(String sanity) {
        this.sanity = sanity;
    }

    public String[] getTendencies() {
        return tendencies;
    }

    public void setTendencies(String[] tendencies) {
        this.tendencies = tendencies;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public String getDisposition() {
        return disposition;
    }

    public void setDisposition(String disposition) {
        this.disposition = disposition;
    }

    public String getIntellect() {
        return intellect;
    }

    public void setIntellect(String intellect) {
        this.intellect = intellect;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getMaterialism() {
        return materialism;
    }

    public void setMaterialism(String materialism) {
        this.materialism = materialism;
    }

    public String getHonesty() {
        return honesty;
    }

    public void setHonesty(String honesty) {
        this.honesty = honesty;
    }

    public String getBravery() {
        return bravery;
    }

    public void setBravery(String bravery) {
        this.bravery = bravery;
    }

    public String getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = energy;
    }

    public String getThrift() {
        return thrift;
    }

    public void setThrift(String thrift) {
        this.thrift = thrift;
    }

    public String getMorals() {
        return morals;
    }

    public void setMorals(String morals) {
        this.morals = morals;
    }

    public String getPiety() {
        return piety;
    }

    public void setPiety(String piety) {
        this.piety = piety;
    }

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }
}
