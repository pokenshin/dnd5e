package com.pokenshin.dnd5e.character.races;

import java.util.ArrayList;
import java.util.List;

public abstract class CharacterRace {
    private int id;
    private List<Integer> abilityIncrease;
    private int ageMax;
    private List<String> alignments;
    private String size;
    private int speed;
    private List<String> otherTraits;
    private List<String> languages;

    public CharacterRace(int id, List<Integer> abilityIncrease, int ageMax, List<String> alignments, String size, int speed, List<String> otherTraits, List<String> languages) {
        this.id = id;
        this.abilityIncrease = abilityIncrease;
        this.ageMax = ageMax;
        this.alignments = alignments;
        this.size = size;
        this.speed = speed;
        this.otherTraits = otherTraits;
        this.languages = languages;
    }

    public CharacterRace(){
        this.id = 0;
        this.abilityIncrease = new ArrayList<>();
        this.ageMax = 0;
        this.alignments = new ArrayList<>();
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

    public List<String> getAlignments() {
        return alignments;
    }

    public void setAlignments(List<String> alignments) {
        this.alignments = alignments;
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
