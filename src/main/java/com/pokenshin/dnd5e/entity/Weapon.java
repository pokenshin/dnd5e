package com.pokenshin.dnd5e.entity;

import java.util.ArrayList;
import java.util.List;

public class Weapon extends Item {
    private Dice damage;
    private String damageType;
    private List<String> properties;

    public Weapon(){
        super();
        this.damage = new Dice();
        this.damageType = "";
        this.properties = new ArrayList<>();
    }

    public Weapon(Dice damage, String damageType, List<String> properties) {
        super();
        this.damage = damage;
        this.damageType = damageType;
        this.properties = properties;
    }

    public Weapon(int id, String nome, String category, CharacterCurrency cost, int weight, Dice damage, String damageType, List<String> properties, int quantity) {
        super(id, nome, category, cost, weight, quantity);
        this.damage = damage;
        this.damageType = damageType;
        this.properties = properties;
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

    public List<String> getProperties() {
        return properties;
    }

    public void setProperties(List<String> properties) {
        this.properties = properties;
    }
}
