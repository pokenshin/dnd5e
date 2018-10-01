package com.pokenshin.dnd5e.character;

public class CharacterAbility {
    private int id;
    private String name;
    private int value;
    private int modifier;
    private int savingThrow;
    private boolean proficient;

    public CharacterAbility(int id, String name, int value, int modifier, int savingThrow, boolean proficient) {
        this.id = id;
        this.name = name;
        this.value = value;
        this.modifier = modifier;
        this.savingThrow = savingThrow;
        this.proficient = proficient;
    }

    public CharacterAbility(){
        this.id = 0;
        this.name = "";
        this.value = 0;
        this.modifier = 0;
        this.savingThrow = 0;
        this.proficient = false;
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public int getSavingThrow() {
        return savingThrow;
    }

    public void setSavingThrow(int savingThrow) {
        this.savingThrow = savingThrow;
    }

    public boolean isProficient() {
        return proficient;
    }

    public void setProficient(boolean proficient) {
        this.proficient = proficient;
    }
}
