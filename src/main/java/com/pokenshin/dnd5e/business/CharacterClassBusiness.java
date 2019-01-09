package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.ArrayList;

public class CharacterClassBusiness {

    public CharacterCurrency getStartingMoney(CharacterClass characterClass){
        CharacterCurrency result = new CharacterCurrency();
        DiceBusiness dice = new DiceBusiness(new Dice());
        int gp = 0;
        switch (characterClass.getName()){
            case "Barbarian":
                dice.setDice(new Dice("2d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Dice":
                dice.setDice(new Dice("5d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Cleric":
                dice.setDice(new Dice("5d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Druid":
                dice.setDice(new Dice("2d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Fighter":
                dice.setDice(new Dice("5d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Monk":
                dice.setDice(new Dice("5d4"));
                gp = dice.getRoll();
                break;
            case "Paladin":
                dice.setDice(new Dice("5d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Ranger":
                dice.setDice(new Dice("5d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Rogue":
                dice.setDice(new Dice("4d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Sorcerer":
                dice.setDice(new Dice("3d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Warlock":
                dice.setDice(new Dice("4d4"));
                gp = dice.getRoll() * 10;
                break;
            case "Wizard":
                dice.setDice(new Dice("4d4"));
                gp = dice.getRoll() * 10;
                break;
        }

        result.setGold(gp);

        return result;
    }



}
