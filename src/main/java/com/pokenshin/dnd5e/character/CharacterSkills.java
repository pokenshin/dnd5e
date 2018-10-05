package com.pokenshin.dnd5e.character;

public class CharacterSkills {
    private ValueAdvantage acrobatics;
    private ValueAdvantage animalHandling;
    private ValueAdvantage arcana;
    private ValueAdvantage athletics;
    private ValueAdvantage deception;
    private ValueAdvantage history;
    private ValueAdvantage insight;
    private ValueAdvantage intimidation;
    private ValueAdvantage investigation;
    private ValueAdvantage medicine;
    private ValueAdvantage nature;
    private ValueAdvantage perception;
    private ValueAdvantage performance;
    private ValueAdvantage persuasion;
    private ValueAdvantage religion;
    private ValueAdvantage sleightOfHand;
    private ValueAdvantage stealth;
    private ValueAdvantage survival;

    public CharacterSkills(ValueAdvantage acrobatics, ValueAdvantage animalHandling, ValueAdvantage arcana, ValueAdvantage athletics, ValueAdvantage deception, ValueAdvantage history, ValueAdvantage insight, ValueAdvantage intimidation, ValueAdvantage investigation, ValueAdvantage medicine, ValueAdvantage nature, ValueAdvantage perception, ValueAdvantage performance, ValueAdvantage persuasion, ValueAdvantage religion, ValueAdvantage sleightOfHand, ValueAdvantage stealth, ValueAdvantage survival) {
        this.acrobatics = acrobatics;
        this.animalHandling = animalHandling;
        this.arcana = arcana;
        this.athletics = athletics;
        this.deception = deception;
        this.history = history;
        this.insight = insight;
        this.intimidation = intimidation;
        this.investigation = investigation;
        this.medicine = medicine;
        this.nature = nature;
        this.perception = perception;
        this.performance = performance;
        this.persuasion = persuasion;
        this.religion = religion;
        this.sleightOfHand = sleightOfHand;
        this.stealth = stealth;
        this.survival = survival;
    }

    public CharacterSkills() {
        this.acrobatics = new ValueAdvantage();
        this.animalHandling = new ValueAdvantage();
        this.arcana = new ValueAdvantage();
        this.athletics = new ValueAdvantage();
        this.deception = new ValueAdvantage();
        this.history = new ValueAdvantage();
        this.insight = new ValueAdvantage();
        this.intimidation = new ValueAdvantage();
        this.investigation = new ValueAdvantage();
        this.medicine = new ValueAdvantage();
        this.nature = new ValueAdvantage();
        this.perception = new ValueAdvantage();
        this.performance = new ValueAdvantage();
        this.persuasion = new ValueAdvantage();
        this.religion = new ValueAdvantage();
        this.sleightOfHand = new ValueAdvantage();
        this.stealth = new ValueAdvantage();
        this.survival = new ValueAdvantage();
    }

    public ValueAdvantage getAcrobatics() {
        return acrobatics;
    }

    public void setAcrobatics(ValueAdvantage acrobatics) {
        this.acrobatics = acrobatics;
    }

    public ValueAdvantage getAnimalHandling() {
        return animalHandling;
    }

    public void setAnimalHandling(ValueAdvantage animalHandling) {
        this.animalHandling = animalHandling;
    }

    public ValueAdvantage getArcana() {
        return arcana;
    }

    public void setArcana(ValueAdvantage arcana) {
        this.arcana = arcana;
    }

    public ValueAdvantage getAthletics() {
        return athletics;
    }

    public void setAthletics(ValueAdvantage athletics) {
        this.athletics = athletics;
    }

    public ValueAdvantage getDeception() {
        return deception;
    }

    public void setDeception(ValueAdvantage deception) {
        this.deception = deception;
    }

    public ValueAdvantage getHistory() {
        return history;
    }

    public void setHistory(ValueAdvantage history) {
        this.history = history;
    }

    public ValueAdvantage getInsight() {
        return insight;
    }

    public void setInsight(ValueAdvantage insight) {
        this.insight = insight;
    }

    public ValueAdvantage getIntimidation() {
        return intimidation;
    }

    public void setIntimidation(ValueAdvantage intimidation) {
        this.intimidation = intimidation;
    }

    public ValueAdvantage getInvestigation() {
        return investigation;
    }

    public void setInvestigation(ValueAdvantage investigation) {
        this.investigation = investigation;
    }

    public ValueAdvantage getMedicine() {
        return medicine;
    }

    public void setMedicine(ValueAdvantage medicine) {
        this.medicine = medicine;
    }

    public ValueAdvantage getNature() {
        return nature;
    }

    public void setNature(ValueAdvantage nature) {
        this.nature = nature;
    }

    public ValueAdvantage getPerception() {
        return perception;
    }

    public void setPerception(ValueAdvantage perception) {
        this.perception = perception;
    }

    public ValueAdvantage getPerformance() {
        return performance;
    }

    public void setPerformance(ValueAdvantage performance) {
        this.performance = performance;
    }

    public ValueAdvantage getPersuasion() {
        return persuasion;
    }

    public void setPersuasion(ValueAdvantage persuasion) {
        this.persuasion = persuasion;
    }

    public ValueAdvantage getReligion() {
        return religion;
    }

    public void setReligion(ValueAdvantage religion) {
        this.religion = religion;
    }

    public ValueAdvantage getSleightOfHand() {
        return sleightOfHand;
    }

    public void setSleightOfHand(ValueAdvantage sleightOfHand) {
        this.sleightOfHand = sleightOfHand;
    }

    public ValueAdvantage getStealth() {
        return stealth;
    }

    public void setStealth(ValueAdvantage stealth) {
        this.stealth = stealth;
    }

    public ValueAdvantage getSurvival() {
        return survival;
    }

    public void setSurvival(ValueAdvantage survival) {
        this.survival = survival;
    }
}
