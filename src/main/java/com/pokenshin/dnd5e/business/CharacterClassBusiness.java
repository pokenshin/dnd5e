package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterClass;
import com.pokenshin.dnd5e.entity.Item;
import com.pokenshin.dnd5e.entity.Weapon;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.ArrayList;

public class CharacterClassBusiness {
    public ArrayList<ArrayList<Item>> getStartingEquipmentOptions(CharacterClass characterClass){
        switch (characterClass.getName()){
            case "Barbarian":
                return getStartingEquipmentBarbarian();
            default:
                return new ArrayList<>();
        }
    }

    private ArrayList<ArrayList<Item>> getStartingEquipmentBarbarian() {
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
        //All options
        optionA.addAll(this.getItemPack("Explorer"));
        optionB.addAll(this.getItemPack("Explorer"));
        for(int i = 0; i< 4; i++){
            optionA.add(javelin);
            optionB.add(javelin);
        }

        options.add(optionA);
        options.add(optionB);

        return options;
    }

    public ArrayList<Item> getItemPack(String packName){
        JsonMapper mapper = new JsonMapper();
        ArrayList<Item> result = new ArrayList<>();

        switch (packName){
            case "Explorer":
                result.add(mapper.getMiscItem("backpack.json"));
                result.add(mapper.getMiscItem("bedroll.json"));
                result.add(mapper.getMiscItem("messkit.json"));
                result.add(mapper.getMiscItem("tinderbox.json"));
                Item torch = mapper.getMiscItem("torch.json");
                for (int i = 0; i < 10; i++){
                    result.add(torch);
                }
                Item ration = mapper.getMiscItem("ration.json");
                for (int i = 0; i < 10; i++){
                    result.add(ration);
                }
                result.add(mapper.getMiscItem("waterskin.json"));
                result.add(mapper.getMiscItem("hempenrope.json"));
                break;
        }

        return result;
    }
}
