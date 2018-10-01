package com.pokenshin.dnd5e.character;

import com.pokenshin.dnd5e.ValueAdvantage;

public class CharacterSavingThrows {
    private ValueAdvantage strength;
    private ValueAdvantage dexterity;
    private ValueAdvantage constitution;
    private ValueAdvantage intelligence;
    private ValueAdvantage wisdom;
    private ValueAdvantage charisma;

    public CharacterSavingThrows(ValueAdvantage strength, ValueAdvantage dexterity, ValueAdvantage constitution, ValueAdvantage intelligence, ValueAdvantage wisdom, ValueAdvantage charisma) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
    }

    public CharacterSavingThrows(){
        this.strength = new ValueAdvantage();
        this.dexterity = new ValueAdvantage();
        this.constitution = new ValueAdvantage();
        this.intelligence = new ValueAdvantage();
        this.wisdom = new ValueAdvantage();
        this.charisma = new ValueAdvantage();
    }

    public ValueAdvantage getStrength() {
        return strength;
    }

    public void setStrength(ValueAdvantage strength) {
        this.strength = strength;
    }

    public ValueAdvantage getDexterity() {
        return dexterity;
    }

    public void setDexterity(ValueAdvantage dexterity) {
        this.dexterity = dexterity;
    }

    public ValueAdvantage getConstitution() {
        return constitution;
    }

    public void setConstitution(ValueAdvantage constitution) {
        this.constitution = constitution;
    }

    public ValueAdvantage getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(ValueAdvantage intelligence) {
        this.intelligence = intelligence;
    }

    public ValueAdvantage getWisdom() {
        return wisdom;
    }

    public void setWisdom(ValueAdvantage wisdom) {
        this.wisdom = wisdom;
    }

    public ValueAdvantage getCharisma() {
        return charisma;
    }

    public void setCharisma(ValueAdvantage charisma) {
        this.charisma = charisma;
    }
}
