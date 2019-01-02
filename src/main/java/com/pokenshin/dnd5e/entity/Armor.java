package com.pokenshin.dnd5e.entity;

public class Armor extends Item {
    private int armorClass;
    private int minStrength;
    private boolean stealthDisavantage;

    public Armor() {
        super();
        this.armorClass = 0;
        this.minStrength = 0;
        this.stealthDisavantage = false;
    }

    public Armor(int armorClass, int minStrength, boolean stealthDisavantage) {
        super();
        this.armorClass = armorClass;
        this.minStrength = minStrength;
        this.stealthDisavantage = stealthDisavantage;
    }

    public Armor(int id, String nome, String category, CharacterCurrency cost, int weight, int armorClass, int minStrength, boolean stealthDisavantage) {
        super(id, nome, category, cost, weight);
        this.armorClass = armorClass;
        this.minStrength = minStrength;
        this.stealthDisavantage = stealthDisavantage;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public void setMinStrength(int minStrength) {
        this.minStrength = minStrength;
    }

    public boolean isStealthDisavantage() {
        return stealthDisavantage;
    }

    public void setStealthDisavantage(boolean stealthDisavantage) {
        this.stealthDisavantage = stealthDisavantage;
    }
}
