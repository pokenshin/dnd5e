package com.pokenshin.dnd5e.entity;

public class CharacterAbility {
    private int value;
    private int modifier;

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public CharacterAbility(int value, int modifier) {
        this.value = value;
        this.modifier = modifier;
    }

    public CharacterAbility(int value){
        this.value = value;
    }

    public CharacterAbility(){
        this.value = 1;
        this.modifier = -5;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
