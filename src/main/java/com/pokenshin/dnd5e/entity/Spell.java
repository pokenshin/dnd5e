package com.pokenshin.dnd5e.entity;

import com.pokenshin.dnd5e.entity.CharacterClass;

import java.util.ArrayList;
import java.util.List;

public class Spell {
    private String name;
    private int level;
    private String school;
    private int castTime;
    private int range;
    private List<String> components;
    private int duration;
    private List<CharacterClass> classes;
    private String description;

    public Spell(String name, int level, String school, int castTime, int range, List<String> components, int duration, List<CharacterClass> classes, String description) {
        this.name = name;
        this.level = level;
        this.school = school;
        this.castTime = castTime;
        this.range = range;
        this.components = components;
        this.duration = duration;
        this.classes = classes;
        this.description = description;
    }

    public Spell() {
        this.name = "";
        this.level = 0;
        this.school = "";
        this.castTime = 0;
        this.range = 0;
        this.components = new ArrayList<>();
        this.duration = 0;
        this.classes = new ArrayList<>();
        this.description = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getCastTime() {
        return castTime;
    }

    public void setCastTime(int castTime) {
        this.castTime = castTime;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public List<String> getComponents() {
        return components;
    }

    public void setComponents(List<String> components) {
        this.components = components;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<CharacterClass> getClasses() {
        return classes;
    }

    public void setClasses(List<CharacterClass> classes) {
        this.classes = classes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
