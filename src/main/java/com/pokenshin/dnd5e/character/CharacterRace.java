package com.pokenshin.dnd5e.character;

import java.util.ArrayList;
import java.util.List;

public class CharacterRace {
    private int id;
    private String name;
    private List<Integer> abilityIncrease;
    private int ageMax;
    private String size;
    private int speed;



    private List<String> otherTraits;
    private List<String> languages;

    public CharacterRace(int id, List<Integer> abilityIncrease, String name, int ageMax, String size, int speed, List<String> otherTraits, List<String> languages) {
        this.id = id;
        this.name = name;
        this.abilityIncrease = abilityIncrease;
        this.ageMax = ageMax;
        this.size = size;
        this.speed = speed;
        this.otherTraits = otherTraits;
        this.languages = languages;
    }

    public CharacterRace(){
        this.id = 0;
        this.name = "";
        this.abilityIncrease = new ArrayList<>();
        this.ageMax = 0;
        this.size = "";
        this.speed = 0;
        this.otherTraits = new ArrayList<>();
        this.languages = new ArrayList<>();
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

    public List<Integer> getAbilityIncrease() {
        return abilityIncrease;
    }

    public void setAbilityIncrease(List<Integer> abilityIncrease) {
        this.abilityIncrease = abilityIncrease;
    }

    public int getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(int ageMax) {
        this.ageMax = ageMax;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public List<String> getOtherTraits() {
        return otherTraits;
    }

    public void setOtherTraits(List<String> otherTraits) {
        this.otherTraits = otherTraits;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }
}
