package com.pokenshin.dnd5e.entity;

public class CharacterAbility {
    private int value;

    public CharacterAbility(int value) {
        this.value = value;
    }

    public CharacterAbility(){
        this.value = 0;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
