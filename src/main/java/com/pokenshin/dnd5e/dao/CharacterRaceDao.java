package com.pokenshin.dnd5e.dao;

import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.*;

public class CharacterRaceDao implements Dao<Race> {
    private HashMap<Integer, Race> racesMap;

    //TODO: get this data from a database instead of json files
    public CharacterRaceDao(){
        this.racesMap = new HashMap<Integer, Race>();
        JsonMapper mapper = new JsonMapper();
        this.racesMap = mapper.getAllRaces();
    }

    @Override
    public Race get(int id) {
        if (racesMap.size() > 0){
            return (Race)racesMap.get(id);
        } else {
            return null;
        }
    }

    @Override
    public Map<Integer, Race> getAll() {
        return racesMap;
    }

    @Override
    public void insert(Race race) {
        //TODO: Implement insert logic
    }

    @Override
    public void update(Race race, String[] params) {
        //TODO: Implement update logic
    }

    @Override
    public void delete(Race race) {
        //TODO: Implement delete logic
    }
}