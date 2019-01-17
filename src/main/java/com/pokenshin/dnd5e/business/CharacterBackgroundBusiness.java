package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterBackground;
import com.pokenshin.dnd5e.entity.Item;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.ArrayList;

public class CharacterBackgroundBusiness {
    public ArrayList<Item> getBackgroundStartingItems(CharacterBackground background){
        switch (background.getName()){
            case "Acolyte":
                return this.getStartingItemsAcolyte();
            case "Charlatan":
                return this.getStartingItemsCharlatan();
        }
        return null;
    }

    private ArrayList<Item> getStartingItemsAcolyte() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("holysymbol.json"));
        result.add(mapper.getMiscItem("book.json"));
        Item incense = mapper.getMiscItem("incense.json");
        incense.setQuantity(5);
        result.add(incense);
        result.add(mapper.getMiscItem("vestment.json"));
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsCharlatan() {
        ItemBusiness itemBusiness = new ItemBusiness();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("finecloth.json"));
        result.add(mapper.getTool("disguisekit.json"));
        result.add(mapper.getTool("thievestools.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }


}
