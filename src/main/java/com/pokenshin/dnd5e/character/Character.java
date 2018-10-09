package com.pokenshin.dnd5e.character;

import java.util.ArrayList;
import java.util.List;

public class Character {
    private int id;
    private String characterName;
    private int level;
    private String background;
    private String playerName;
    private CharacterRace race;
    private String alignment;
    private int experience;
    private CharacterAbility strength;
    private CharacterAbility dexterity;
    private CharacterAbility constitution;
    private CharacterAbility intelligence;
    private CharacterAbility wisdom;
    private CharacterAbility charisma;
    private int inspiration;
    private int proficiencyBonus;
    private CharacterSavingThrows savingThrows;
    private CharacterSkills skills;
    private int perception;
    private List<String> proficiencies;
    private int armorClass;
    private int initiative;
    private int speed;
    private int hpCurrent;
    private int hpMax;
    private int hpTemporary;
    private Dice hitDice;
    private int totalHitDice;
    private int deathSavesSuccess;
    private int deathSavesFailures;
    private List<CharacterAttack> attacks;
    private CharacterCurrency currency;
    private List<CharacterItem> equipment;
    private List<String> traits;
    private List<String> ideals;
    private List<String> bonds;
    private List<String> flaws;
    private List<String> features;
    private int age;
    private int height;
    private int weight;
    private String eyes;
    private String skin;
    private String hair;
    private String appearance;
    private List<String> allies;
    private String backstory;
    private List<CharacterItem> treasure;
    private CharacterSpellcastingClass spellcasting;

    public Character(int id, String characterName, int level, String background, String playerName, CharacterRace race, String alignment, int experience, CharacterAbility strength, CharacterAbility dexterity, CharacterAbility constitution, CharacterAbility intelligence, CharacterAbility wisdom, CharacterAbility charisma, int inspiration, int proficiencyBonus, CharacterSavingThrows savingThrows, CharacterSkills skills, int perception, List<String> proficiencies, int armorClass, int initiative, int speed, int hpCurrent, int hpMax, int hpTemporary, Dice hitDice, int totalHitDice, int deathSavesSuccess, int deathSavesFailures, List<CharacterAttack> attacks, CharacterCurrency currency, List<CharacterItem> equipment, List<String> traits, List<String> ideals, List<String> bonds, List<String> flaws, List<String> features, int age, int height, int weight, String eyes, String skin, String hair, String appearance, List<String> allies, String backstory, List<CharacterItem> treasure, CharacterSpellcastingClass spellcasting) {
        this.id = id;
        this.characterName = characterName;
        this.level = level;
        this.background = background;
        this.playerName = playerName;
        this.race = race;
        this.alignment = alignment;
        this.experience = experience;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.charisma = charisma;
        this.inspiration = inspiration;
        this.proficiencyBonus = proficiencyBonus;
        this.savingThrows = savingThrows;
        this.skills = skills;
        this.perception = perception;
        this.proficiencies = proficiencies;
        this.armorClass = armorClass;
        this.initiative = initiative;
        this.speed = speed;
        this.hpCurrent = hpCurrent;
        this.hpMax = hpMax;
        this.hpTemporary = hpTemporary;
        this.hitDice = hitDice;
        this.totalHitDice = totalHitDice;
        this.deathSavesSuccess = deathSavesSuccess;
        this.deathSavesFailures = deathSavesFailures;
        this.attacks = attacks;
        this.currency = currency;
        this.equipment = equipment;
        this.traits = traits;
        this.ideals = ideals;
        this.bonds = bonds;
        this.flaws = flaws;
        this.features = features;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.eyes = eyes;
        this.skin = skin;
        this.hair = hair;
        this.appearance = appearance;
        this.allies = allies;
        this.backstory = backstory;
        this.treasure = treasure;
        this.spellcasting = spellcasting;
    }

    public Character() {
        this.id = 0;
        this.characterName = "";
        this.level = 0;
        this.background = "";
        this.playerName = "";
        this.race = null;
        this.alignment = "";
        this.experience = 0;
        this.strength = new CharacterAbility();
        this.dexterity = new CharacterAbility();
        this.constitution = new CharacterAbility();
        this.intelligence = new CharacterAbility();
        this.wisdom = new CharacterAbility();
        this.charisma = new CharacterAbility();
        this.inspiration = 0;
        this.proficiencyBonus = 0;
        this.savingThrows = new CharacterSavingThrows();
        this.skills = new CharacterSkills();
        this.perception = 0;
        this.proficiencies = new ArrayList<>();
        this.armorClass = 0;
        this.initiative = 0;
        this.speed = 0;
        this.hpCurrent = 0;
        this.hpMax = 0;
        this.hpTemporary = 0;
        this.hitDice = new Dice();
        this.totalHitDice = 0;
        this.deathSavesSuccess = 0;
        this.deathSavesFailures = 0;
        this.attacks = new ArrayList<>();
        this.currency = new CharacterCurrency();
        this.equipment = new ArrayList<>();
        this.traits = new ArrayList<>();
        this.ideals = new ArrayList<>();
        this.bonds = new ArrayList<>();
        this.flaws = new ArrayList<>();
        this.features = new ArrayList<>();
        this.age = 0;
        this.height = 0;
        this.weight = 0;
        this.eyes = "";
        this.skin = "";
        this.hair = "";
        this.appearance = "";
        this.allies = new ArrayList<>();
        this.backstory = "";
        this.treasure = new ArrayList<>();
        this.spellcasting = new CharacterSpellcastingClass();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public CharacterRace getRace() {
        return race;
    }

    public void setRace(CharacterRace race) {
        this.race = race;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public CharacterAbility getStrength() {
        return strength;
    }

    public void setStrength(CharacterAbility strength) {
        this.strength = strength;
    }

    public CharacterAbility getDexterity() {
        return dexterity;
    }

    public void setDexterity(CharacterAbility dexterity) {
        this.dexterity = dexterity;
    }

    public CharacterAbility getConstitution() {
        return constitution;
    }

    public void setConstitution(CharacterAbility constitution) {
        this.constitution = constitution;
    }

    public CharacterAbility getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(CharacterAbility intelligence) {
        this.intelligence = intelligence;
    }

    public CharacterAbility getWisdom() {
        return wisdom;
    }

    public void setWisdom(CharacterAbility wisdom) {
        this.wisdom = wisdom;
    }

    public CharacterAbility getCharisma() {
        return charisma;
    }

    public void setCharisma(CharacterAbility charisma) {
        this.charisma = charisma;
    }

    public int getInspiration() {
        return inspiration;
    }

    public void setInspiration(int inspiration) {
        this.inspiration = inspiration;
    }

    public int getProficiencyBonus() {
        return proficiencyBonus;
    }

    public void setProficiencyBonus(int proficiencyBonus) {
        this.proficiencyBonus = proficiencyBonus;
    }

    public CharacterSavingThrows getSavingThrows() {
        return savingThrows;
    }

    public void setSavingThrows(CharacterSavingThrows savingThrows) {
        this.savingThrows = savingThrows;
    }

    public CharacterSkills getSkills() {
        return skills;
    }

    public void setSkills(CharacterSkills skills) {
        this.skills = skills;
    }

    public int getPerception() {
        return perception;
    }

    public void setPerception(int perception) {
        this.perception = perception;
    }

    public List<String> getProficiencies() {
        return proficiencies;
    }

    public void setProficiencies(List<String> proficiencies) {
        this.proficiencies = proficiencies;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getInitiative() {
        return initiative;
    }

    public void setInitiative(int initiative) {
        this.initiative = initiative;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHpCurrent() {
        return hpCurrent;
    }

    public void setHpCurrent(int hpCurrent) {
        this.hpCurrent = hpCurrent;
    }

    public int getHpMax() {
        return hpMax;
    }

    public void setHpMax(int hpMax) {
        this.hpMax = hpMax;
    }

    public int getHpTemporary() {
        return hpTemporary;
    }

    public void setHpTemporary(int hpTemporary) {
        this.hpTemporary = hpTemporary;
    }

    public Dice getHitDice() {
        return hitDice;
    }

    public void setHitDice(Dice hitDice) {
        this.hitDice = hitDice;
    }

    public int getTotalHitDice() {
        return totalHitDice;
    }

    public void setTotalHitDice(int totalHitDice) {
        this.totalHitDice = totalHitDice;
    }

    public int getDeathSavesSuccess() {
        return deathSavesSuccess;
    }

    public void setDeathSavesSuccess(int deathSavesSuccess) {
        this.deathSavesSuccess = deathSavesSuccess;
    }

    public int getDeathSavesFailures() {
        return deathSavesFailures;
    }

    public void setDeathSavesFailures(int deathSavesFailures) {
        this.deathSavesFailures = deathSavesFailures;
    }

    public List<CharacterAttack> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<CharacterAttack> attacks) {
        this.attacks = attacks;
    }

    public CharacterCurrency getCurrency() {
        return currency;
    }

    public void setCurrency(CharacterCurrency currency) {
        this.currency = currency;
    }

    public List<CharacterItem> getEquipment() {
        return equipment;
    }

    public void setEquipment(List<CharacterItem> equipment) {
        this.equipment = equipment;
    }

    public List<String> getTraits() {
        return traits;
    }

    public void setTraits(List<String> traits) {
        this.traits = traits;
    }

    public List<String> getIdeals() {
        return ideals;
    }

    public void setIdeals(List<String> ideals) {
        this.ideals = ideals;
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

    public List<String> getFeatures() {
        return features;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getEyes() {
        return eyes;
    }

    public void setEyes(String eyes) {
        this.eyes = eyes;
    }

    public String getSkin() {
        return skin;
    }

    public void setSkin(String skin) {
        this.skin = skin;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public List<String> getAllies() {
        return allies;
    }

    public void setAllies(List<String> allies) {
        this.allies = allies;
    }

    public String getBackstory() {
        return backstory;
    }

    public void setBackstory(String backstory) {
        this.backstory = backstory;
    }

    public List<CharacterItem> getTreasure() {
        return treasure;
    }

    public void setTreasure(List<CharacterItem> treasure) {
        this.treasure = treasure;
    }

    public CharacterSpellcastingClass getSpellcasting() {
        return spellcasting;
    }

    public void setSpellcasting(CharacterSpellcastingClass spellcasting) {
        this.spellcasting = spellcasting;
    }
}