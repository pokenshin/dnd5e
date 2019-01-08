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

            case "Diplomat":
                result.add(mapper.getMiscItem("chest.json"));
                for (int i = 0; i < 2; i++){
                    result.add(mapper.getMiscItem("case.json"));
                }
                result.add(mapper.getMiscItem("finecloth.json"));
                result.add(mapper.getMiscItem("inkbottle.json"));
                result.add(mapper.getMiscItem("inkpen.json"));
                result.add(mapper.getMiscItem("lamp.json"));
                for (int i=0; i< 2; i++){
                    result.add(mapper.getMiscItem("oilflask.json"));
                }
                for (int i=0; i<5; i++){
                    result.add(mapper.getMiscItem("paper.json"));
                }
                result.add(mapper.getMiscItem("perfume.json"));
                result.add(mapper.getMiscItem("sealingwax.json"));
                break;
        }

        return result;
    }
}
