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

    public Weapon(int id, String nome, String category, CharacterCurrency cost, int weight, Dice damage, String damageType, List<String> properties) {
        super(id, nome, category, cost, weight);
        this.damage = damage;
        this.damageType = damageType;
        this.properties = properties;
    }
}
