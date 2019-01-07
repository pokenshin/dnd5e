package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.Dice;

import java.util.concurrent.ThreadLocalRandom;

public class DiceBusiness {
    private Dice dice;

    public Dice getDice() {
        return dice;
    }

    public void setDice(Dice dice) {
        this.dice = dice;
    }

    public DiceBusiness(Dice dice){
        this.dice = dice;
    }

    public int getRoll(){
        if (this.dice != null){
            int result = 0;
            for (int i= 0; i<dice.getRolls(); i++){
                result = result + ThreadLocalRandom.current().nextInt(1,dice.getSides() + 1);
            }
            return result;
        }
        else return 0;
    }
}
