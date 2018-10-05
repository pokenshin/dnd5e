package com.pokenshin.dnd5e.character;

public class ValueAdvantage {
    public int value;
    public boolean advantage;

    public ValueAdvantage(int value, boolean advantage) {
        this.value = value;
        this.advantage = advantage;
    }

    public ValueAdvantage(){
        this.value = 0;
        this.advantage = false;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public boolean isAdvantage() {
        return advantage;
    }

    public void setAdvantage(boolean advantage) {
        this.advantage = advantage;
    }
}
