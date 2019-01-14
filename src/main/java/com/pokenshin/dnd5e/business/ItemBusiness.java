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
                Item torchExplorer = mapper.getMiscItem("torch.json");
                torchExplorer.setQuantity(10);
                result.add(torchExplorer);
                Item rationExplorer = mapper.getMiscItem("ration.json");
                rationExplorer.setQuantity(10);
                result.add(rationExplorer);
                result.add(mapper.getMiscItem("waterskin.json"));
                result.add(mapper.getMiscItem("hempenrope.json"));
                break;

            case "Diplomat":
                result.add(mapper.getMiscItem("chest.json"));
                Item caseDiplomat = mapper.getMiscItem("case.json");
                caseDiplomat.setQuantity(2);
                result.add(caseDiplomat);
                result.add(mapper.getMiscItem("finecloth.json"));
                result.add(mapper.getMiscItem("inkbottle.json"));
                result.add(mapper.getMiscItem("inkpen.json"));
                result.add(mapper.getMiscItem("lamp.json"));
                Item oilDiplomat = mapper.getMiscItem("oilflask.json");
                oilDiplomat.setQuantity(2);
                result.add(oilDiplomat);
                Item paperDiplomat = mapper.getMiscItem("paper.json");
                paperDiplomat.setQuantity(5);
                result.add(paperDiplomat);
                result.add(mapper.getMiscItem("perfume.json"));
                result.add(mapper.getMiscItem("sealingwax.json"));
                break;

            case "Entertainer":
                result.add(mapper.getMiscItem("backpack.json"));
                result.add(mapper.getMiscItem("bedroll.json"));
                Item costume = mapper.getMiscItem("costume.json");
                costume.setQuantity(2);
                Item rationEntertainer = mapper.getMiscItem("ration.json");
                rationEntertainer.setQuantity(5);
                result.add(rationEntertainer);
                result.add(mapper.getMiscItem("waterskin.json"));
                result.add(mapper.getTool("disguisekit.json"));
                break;

            case "Priest":
                result.add(mapper.getMiscItem("backpack.json"));
                result.add(mapper.getMiscItem("blanket.json"));
                Item candle = mapper.getMiscItem("candle.json");
                candle.setQuantity(10);
                result.add(candle);
                result.add(mapper.getMiscItem("tinderbox.json"));
                Item rationPriest = mapper.getMiscItem("ration.json");
                rationPriest.setQuantity(2);
                result.add(rationPriest);
                result.add(mapper.getMiscItem("waterskin.json"));
                break;
        }

        return result;
    }
}
