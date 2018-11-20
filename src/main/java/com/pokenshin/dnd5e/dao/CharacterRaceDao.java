package com.pokenshin.dnd5e.dao;

import com.pokenshin.dnd5e.character.CharacterRace;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.*;

public class CharacterRaceDao implements Dao<CharacterRace> {
    private HashMap<Integer, CharacterRace> racesMap;

    //TODO: get this data from a database instead of json files
    public CharacterRaceDao(){
        this.racesMap = new HashMap<Integer, CharacterRace>();
        JsonMapper mapper = new JsonMapper();
        this.racesMap = mapper.getAllRaces();
    }

    @Override
    public CharacterRace get(int id) {
        if (racesMap.size() > 0){
            return (CharacterRace)racesMap.get(id);
        } else {
            return null;
        }
    }

    @Override
    public Map<Integer, CharacterRace> getAll() {
        return racesMap;
    }

    @Override
    public void insert(CharacterRace characterRace) {
        //TODO: Implement insert logic
    }

    @Override
    public void update(CharacterRace characterRace, String[] params) {
        //TODO: Implement update logic
    }

    @Override
    public void delete(CharacterRace characterRace) {
        //TODO: Implement delete logic
    }
}