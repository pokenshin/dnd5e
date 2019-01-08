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

    public ArrayList<ArrayList<Item>> getStartingEquipmentOptions(CharacterClass characterClass){
        switch (characterClass.getName()){
            case "Barbarian":
                return getStartingEquipmentBarbarian();
            case "Bard":

            default:
                return new ArrayList<>();
        }
    }




    private ArrayList<ArrayList<Item>> getStartingEquipmentBarbarian() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<ArrayList<Item>> options = new ArrayList<>();
        ArrayList<Item> optionA = new ArrayList<>();
        ArrayList<Item> optionB = new ArrayList<>();
        Randomizer rng = new Randomizer();
        JsonMapper mapper = new JsonMapper();
        Weapon greataxe = mapper.getWeapon("greataxe.json");
        Weapon handaxe = mapper.getWeapon("handaxe.json");
        Weapon randomMartial = rng.getRandomWeaponByCategory("Martial Weapon");
        Weapon randomSimple = rng.getRandomWeaponByCategory("Simple Weapon");
        Weapon javelin = mapper.getWeapon("javelin.json");
        //Option A (1 Great Axe + 2 Hand Axes)
        optionA.add(greataxe);
        for(int i = 0; i< 2; i++){
            optionA.add(handaxe);
        }
        //Option B (1 Random Martial + 1 Random Simple)
        optionB.add(randomMartial);
        optionB.add(randomSimple);
        //All options (Explorer's Pack)
        optionA.addAll(itemBusiness.getItemPack("Explorer"));
        optionB.addAll(itemBusiness.getItemPack("Explorer"));
        for(int i = 0; i< 4; i++){
            optionA.add(javelin);
            optionB.add(javelin);
        }

        options.add(optionA);
        options.add(optionB);

        return options;
    }


}
