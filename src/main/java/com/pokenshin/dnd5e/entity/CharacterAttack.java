package com.pokenshin.dnd5e.entity;

public class CharacterAttack {
    private String name;
    private int attackBonus;
    private String damageType;

    public CharacterAttack(String name, int attackBonus, String damageType) {
        this.name = name;
        this.attackBonus = attackBonus;
        this.damageType = damageType;
    }

    public CharacterAttack() {
        this.name = "";
        this.attackBonus = 0;
        this.damageType = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackBonus() {
        return attackBonus;
    }

    public void setAttackBonus(int attackBonus) {
        this.attackBonus = attackBonus;
    }

    public String getDamageType() {
        return damageType;
    }

    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }
}
