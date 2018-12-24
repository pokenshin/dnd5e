package com.pokenshin.dnd5e.entity;

import java.util.ArrayList;
import java.util.List;

public class CharacterBackground {
    private int id;
    private String name;
    private CharacterSkills skillProficiencies;
    private List<String> toolProficiencies;
    private List<String> languages;
    private List<String> equipment;
    private CharacterCurrency startingMoney;
    private List<String> features;
    private List<String> additionalTraits;
    private List<String> personalityTraits;
    private String idealGood;
    private String idealEvil;
    private String idealLawful;
    private String idealChaotic;
    private String idealNeutral;
    private String idealAny;
    private List<String> bonds;
    private List<String> flaws;

    public CharacterBackground(int id, String name, CharacterSkills skillProficiencies, List<String> toolProficiencies, List<String> languages, List<String> equipment, CharacterCurrency startingMoney, List<String> features, List<String> additionalTraits, List<String> personalityTraits, String idealGood, String idealEvil, String idealLawful, String idealChaotic, String idealNeutral, String idealAny, List<String> bonds, List<String> flaws) {
        this.id = id;
        this.name = name;
        this.skillProficiencies = skillProficiencies;
        this.toolProficiencies = toolProficiencies;
        this.languages = languages;
        this.equipment = equipment;
        this.startingMoney = startingMoney;
        this.features = features;
        this.additionalTraits = additionalTraits;
        this.personalityTraits = personalityTraits;
        this.idealGood = idealGood;
        this.idealEvil = idealEvil;
        this.idealLawful = idealLawful;
        this.idealChaotic = idealChaotic;
        this.idealNeutral = idealNeutral;
        this.idealAny = idealAny;
        this.bonds = bonds;
        this.flaws = flaws;
    }

    public CharacterBackground() {
        this.id = 0;
        this.name = "";
        this.skillProficiencies = new CharacterSkills();
        this.toolProficiencies = new ArrayList<>();
        this.languages = new ArrayList<>();
        this.equipment = new ArrayList<>();
        this.startingMoney = new CharacterCurrency();
        this.features = new ArrayList<>();
        this.additionalTraits = new ArrayList<>();
        this.personalityTraits = new ArrayList<>();
        this.idealGood = "";
        this.idealEvil = "";
        this.idealLawful = "";
        this.idealChaotic = "";
        this.idealNeutral = "";
        this.idealAny = "";
        this.bonds = new ArrayList<>();
        this.flaws = new ArrayList<>();
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterSkills getSkillProficiencies() {
        return skillProficiencies;
    }

    public void setSkillProficiencies(CharacterSkills skillProficiencies) {
        this.skillProficiencies = skillProficiencies;
    }

    public List<String> getToolProficiencies() {
        return toolProficiencies;
    }

    public void setToolProficiencies(List<String> toolProficiencies) {
        this.toolProficiencies = toolProficiencies;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public List<String> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<String> equipment) {
        this.equipment = equipment;
    }

    public CharacterCurrency getStartingMoney() {
        return startingMoney;
    }

    public void setStartingMoney(CharacterCurrency startingMoney) {
        this.startingMoney = startingMoney;
    }

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public List<String> getAdditionalTraits() {
        return additionalTraits;
    }

    public void setAdditionalTraits(List<String> additionalTraits) {
        this.additionalTraits = additionalTraits;
    }

    public List<String> getPersonalityTraits() {
        return personalityTraits;
    }

    public void setPersonalityTraits(List<String> personalityTraits) {
        this.personalityTraits = personalityTraits;
    }

    public String getIdealGood() {
        return idealGood;
    }

    public void setIdealGood(String idealGood) {
        this.idealGood = idealGood;
    }

    public String getIdealEvil() {
        return idealEvil;
    }

    public void setIdealEvil(String idealEvil) {
        this.idealEvil = idealEvil;
    }

    public String getIdealLawful() {
        return idealLawful;
    }

    public void setIdealLawful(String idealLawful) {
        this.idealLawful = idealLawful;
    }

    public String getIdealChaotic() {
        return idealChaotic;
    }

    public void setIdealChaotic(String idealChaotic) {
        this.idealChaotic = idealChaotic;
    }

    public String getIdealNeutral() {
        return idealNeutral;
    }

    public void setIdealNeutral(String idealNeutral) {
        this.idealNeutral = idealNeutral;
    }

    public String getIdealAny() {
        return idealAny;
    }

    public void setIdealAny(String idealAny) {
        this.idealAny = idealAny;
    }

    public List<String> getBonds() {
        return bonds;
    }

    public void setBonds(List<String> bonds) {
        this.bonds = bonds;
    }

    public List<String> getFlaws() {
        return flaws;
    }

    public void setFlaws(List<String> flaws) {
        this.flaws = flaws;
    }
}
