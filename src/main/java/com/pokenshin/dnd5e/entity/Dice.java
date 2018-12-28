package com.pokenshin.dnd5e.entity;

import java.util.Random;

public class Dice {
    private int sides;
    private int rolls;

    public Dice(String dice){
        this.rolls = Integer.parseInt(dice.split("d")[0]);
        this.sides = Integer.parseInt(dice.split("d")[1]);
    }

    public Dice(int sides, int rolls) {
        this.sides = sides;
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
