package com.pokenshin.dnd5e.entity;

import com.pokenshin.dnd5e.entity.*;

import java.util.ArrayList;
import java.util.List;

public class CharacterClass {
    private int id;
    private String name;
    private Dice hitDice;
    private int startingHP;
    private List<String> armorProficiency;
    private List<String> weaponProficiency;
    private List<String> tools;
    private CharacterSavingThrows savingThrows;
    private CharacterSkills skills;
    private List<Item> startingEquip;
    private CharacterCurrency startingMoney;
    private List<String> levelingPerks;

    public CharacterClass(int id, String name, Dice hitDice, int startingHP, List<String> armorProficiency, List<String> weaponProficiency, List<String> tools, CharacterSavingThrows savingThrows, CharacterSkills skills, List<Item> startingEquip, CharacterCurrency startingMoney, List<String> levelingPerks) {
        this.id = id;
        this.name = name;
        this.hitDice = hitDice;
        this.startingHP = startingHP;
        this.armorProficiency = armorProficiency;
        this.weaponProficiency = weaponProficiency;
        this.tools = tools;
        this.savingThrows = savingThrows;
        this.skills = skills;
        this.startingEquip = startingEquip;
        this.startingMoney = startingMoney;
        this.levelingPerks = levelingPerks;
    }

    public CharacterClass() {
        this.id = 0;
        this.name = "";
        this.hitDice = new Dice();
        this.startingHP = 0;
        this.armorProficiency = new ArrayList<>();
        this.weaponProficiency = new ArrayList<>();
        this.tools = new ArrayList<>();
        this.savingThrows = new CharacterSavingThrows();
        this.skills = new CharacterSkills();
        this.startingEquip = new ArrayList<>();
        this.startingMoney = new CharacterCurrency();
        this.levelingPerks = new ArrayList<>();
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

    public Dice getHitDice() {
        return hitDice;
    }

    public void setHitDice(Dice hitDice) {
        this.hitDice = hitDice;
    }

    public int getStartingHP() {
        return startingHP;
    }

    public void setStartingHP(int startingHP) {
        this.startingHP = startingHP;
    }

    public List<String> getArmorProficiency() {
        return armorProficiency;
    }

    public void setArmorProficiency(List<String> armorProficiency) {
        this.armorProficiency = armorProficiency;
    }

    public List<String> getWeaponProficiency() {
        return weaponProficiency;
    }

    public void setWeaponProficiency(List<String> weaponProficiency) {
        this.weaponProficiency = weaponProficiency;
    }

    public List<String> getTools() {
        return tools;
    }

    public void setTools(List<String> tools) {
        this.tools = tools;
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

    public List<Item> getStartingEquip() {
        return startingEquip;
    }

    public void setStartingEquip(List<Item> startingEquip) {
        this.startingEquip = startingEquip;
    }

    public CharacterCurrency getStartingMoney() {
        return startingMoney;
    }

    public void setStartingMoney(CharacterCurrency startingMoney) {
        this.startingMoney = startingMoney;
    }

    public List<String> getLevelingPerks() {
        return levelingPerks;
    }

    public void setLevelingPerks(List<String> levelingPerks) {
        this.levelingPerks = levelingPerks;
    }
}
