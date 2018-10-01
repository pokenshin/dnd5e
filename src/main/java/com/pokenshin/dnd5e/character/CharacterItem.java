package com.pokenshin.dnd5e.character;

import com.pokenshin.dnd5e.Dice;

import java.util.ArrayList;
import java.util.List;

public class CharacterItem {
    private int id;
    private String nome;
    private String description;
    private int weight;
    private String rarity;
    private int value;
    private List<String> properties;
    private List<String> modifiers;
    private boolean isCursed;
    private int armorClass;
    private String slot;
    private String type;
    private boolean stealthAdvantage;
    private int minStrength;
    private Dice damage;
    private String damageType;
    private int range;

    public CharacterItem(int id, String nome, String description, int weight, String rarity, int value, List<String> properties, List<String> modifiers, boolean isCursed, int armorClass, String slot, String type, boolean stealthAdvantage, int minStrength, Dice damage, String damageType, int range) {
        this.id = id;
        this.nome = nome;
        this.description = description;
        this.weight = weight;
        this.rarity = rarity;
        this.value = value;
        this.properties = properties;
        this.modifiers = modifiers;
        this.isCursed = isCursed;
        this.armorClass = armorClass;
        this.slot = slot;
        this.type = type;
        this.stealthAdvantage = stealthAdvantage;
        this.minStrength = minStrength;
        this.damage = damage;
        this.damageType = damageType;
        this.range = range;
    }

    public CharacterItem(){
        this.id = 0;
        this.nome = "";
        this.description = "";
        this.weight = 0;
        this.rarity = "";
        this.value = 0;
        this.properties = new ArrayList<>();
        this.modifiers =  new ArrayList<>();
        this.isCursed = false;
        this.armorClass = 0;
        this.slot = "";
        this.type = "";
        this.stealthAdvantage = false;
        this.minStrength = 0;
        this.damage = new Dice();
        this.damageType = "";
        this.range = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }

    public List<String> getModifiers() {
        return modifiers;
    }

    public void setModifiers(List<String> modifiers) {
        this.modifiers = modifiers;
    }

    public boolean isCursed() {
        return isCursed;
    }

    public void setCursed(boolean cursed) {
        isCursed = cursed;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isStealthAdvantage() {
        return stealthAdvantage;
    }

    public void setStealthAdvantage(boolean stealthAdvantage) {
        this.stealthAdvantage = stealthAdvantage;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public void setMinStrength(int minStrength) {
        this.minStrength = minStrength;
    }

    public Dice getDamage() {
        return damage;
    }

    public void setDamage(Dice damage) {
        this.damage = damage;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }
}
