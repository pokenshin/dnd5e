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
            case "Criminal":
                return this.getStartingItemsCriminal();
            case "Entertainer":
                return this.getStartingItemsEntertainer();
            case "Folk Hero":
                return this.getStartingItemsFolkHero();
            case "Guild Artisan":
                return this.getStartingItemsGuildArtisan();
            case "Hermit":
                return this.getStartingItemsHermit();
            case "Noble":
                return this.getStartingItemsNoble();
            case "Outlander":
                return this.getStartingItemsOutlander();
            case "Sage":
                return this.getStartingItemsSage();
            case "Sailor":
                return this.getStartingItemsSailor();
            case "Soldier":
                return this.getStartingItemsSoldier();
            case "Urchin":
                return this.getStartingItemsUrchin();
        }
        return null;
    }

    private ArrayList<Item> getStartingItemsUrchin() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsSoldier() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getTool("gamingset.json"));
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsSailor() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("belayingpin.json"));
        result.add(mapper.getMiscItem("silkrope.json"));
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsSage() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("inkbottle.json"));
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsOutlander() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("staff.json"));
        result.add(mapper.getMiscItem("huntingtrap.json"));
        result.add(mapper.getMiscItem("travellercloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsNoble() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("finecloth.json"));
        result.add(mapper.getMiscItem("signetring.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsHermit() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("case.json"));
        result.add(mapper.getMiscItem("blanket.json"));
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getTool("herbalismkit.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsGuildArtisan() {
        Randomizer rng = new Randomizer();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(rng.getRandomToolItemByCategory("Artisan's Tools"));
        result.add(mapper.getMiscItem("travellercloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsFolkHero() {
        Randomizer rng = new Randomizer();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(rng.getRandomToolItemByCategory("Artisan's Tools"));
        result.add(mapper.getMiscItem("shovel.json"));
        result.add(mapper.getMiscItem("ironpot.json"));
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsEntertainer() {
        Randomizer rng = new Randomizer();
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(rng.getRandomToolItemByCategory("Musical Instrument"));
        result.add(mapper.getMiscItem("costume.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsCriminal() {
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("crowbar.json"));
        result.add(mapper.getMiscItem("commoncloth.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }

    private ArrayList<Item> getStartingItemsAcolyte() {
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
        ArrayList<Item> result = new ArrayList<>();
        JsonMapper mapper = new JsonMapper();
        result.add(mapper.getMiscItem("finecloth.json"));
        result.add(mapper.getTool("disguisekit.json"));
        result.add(mapper.getTool("thievestools.json"));
        result.add(mapper.getMiscItem("pouch.json"));
        return result;
    }


}
