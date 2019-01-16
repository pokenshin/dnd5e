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
                dice = new DiceBusiness((new Dice("2d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Bard":
                dice = new DiceBusiness((new Dice("5d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Cleric":
                dice =  new DiceBusiness((new Dice("5d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Druid":
                dice =  new DiceBusiness((new Dice("2d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Fighter":
                dice =  new DiceBusiness((new Dice("5d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Monk":
                dice =  new DiceBusiness((new Dice("5d4")));
                gp = dice.getRoll();
                break;
            case "Paladin":
                dice =  new DiceBusiness((new Dice("5d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Ranger":
                dice =  new DiceBusiness((new Dice("5d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Rogue":
                dice  = new DiceBusiness((new Dice("4d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Sorcerer":
                dice =  new DiceBusiness((new Dice("3d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Warlock":
                dice =  new DiceBusiness((new Dice("4d4")));
                gp = dice.getRoll() * 10;
                break;
            case "Wizard":
                dice =  new DiceBusiness((new Dice("4d4")));
                gp = dice.getRoll() * 10;
                break;
        }

        result.setGold(gp);

        return result;
    }

    //TODO: create a function that defines the rules for the starting equipament options for each class, probably with a ArrayList<ArrayList<ArrayList<Item>>>
}
