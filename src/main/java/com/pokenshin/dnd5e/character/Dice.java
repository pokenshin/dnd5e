package com.pokenshin.dnd5e.character;

public class Dice {
    private int sides;
    private int rolls;

    public Dice(int value, int rolls) {
        this.sides = value;
        this.rolls = rolls;
    }

    public Dice() {
        this.sides = 0;
        this.rolls = 0;
    }

    public int getSides() {
        return sides;
    }

    public void setSides(int sides) {
        this.sides = sides;
    }

    public int getRolls() {
        return rolls;
    }

    public void setRolls(int rolls) {
        this.rolls = rolls;
    }

    public String toString(){
        return this.rolls + "d" + this.sides;
    }
}
