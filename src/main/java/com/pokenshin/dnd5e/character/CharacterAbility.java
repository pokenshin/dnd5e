package com.pokenshin.dnd5e.character;

public class CharacterAbility {
    private int value;
    private int modifier;

    public CharacterAbility(int value, int modifier) {
        this.value = value;
        this.modifier = modifier;
    }

    public CharacterAbility(){
        this.value = 0;
        this.modifier = 0;
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
}
