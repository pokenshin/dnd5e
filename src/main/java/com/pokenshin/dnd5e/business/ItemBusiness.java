package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.Item;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.ArrayList;

public class ItemBusiness {

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
