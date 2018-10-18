package com.pokenshin.dnd5e.character;

public class CharacterSavingThrows {
    private boolean strength;
    private boolean dexterity;
    private boolean constitution;
    private boolean intelligence;
    private boolean wisdom;
    private boolean charisma;

    public CharacterSavingThrows(boolean strength, boolean dexterity, boolean constitution, boolean intelligence, boolean wisdom, boolean charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public CharacterSavingThrows(){
        this.strength = false;
        this.dexterity = false;
        this.constitution = false;
        this.intelligence = false;
        this.wisdom = false;
        this.charisma = false;
    }

    public boolean isStrength() {
        return strength;
    }

    public void setStrength(boolean strength) {
        this.strength = strength;
    }

    public boolean isDexterity() {
        return dexterity;
    }

    public void setDexterity(boolean dexterity) {
        this.dexterity = dexterity;
    }

    public boolean isConstitution() {
        return constitution;
    }

    public void setConstitution(boolean constitution) {
        this.constitution = constitution;
    }

    public boolean isIntelligence() {
        return intelligence;
    }

    public void setIntelligence(boolean intelligence) {
        this.intelligence = intelligence;
    }

    public boolean isWisdom() {
        return wisdom;
    }

    public void setWisdom(boolean wisdom) {
        this.wisdom = wisdom;
    }

    public boolean isCharisma() {
        return charisma;
    }

    public void setCharisma(boolean charisma) {
        this.charisma = charisma;
    }
}
