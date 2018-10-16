package com.pokenshin.dnd5e.dao;

import com.pokenshin.dnd5e.character.CharacterRace;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CharacterRaceDao implements Dao<CharacterRace> {
    private List<CharacterRace> races = new ArrayList<>();

    //TODO: get this data from a database instead of json files
    public CharacterRaceDao(){
        JsonMapper mapper = new JsonMapper();
        this.races.add(mapper.getRace("/races/human.json"));
        this.races.add(mapper.getRace("/races/elf.json"));
    }

    @Override
    public Optional<CharacterRace> get(long id) {
        if (races.size() > 0){
            return Optional.ofNullable(races.get((int) id - 1));
        } else {
            return Optional.ofNullable(new CharacterRace());
        }
    }

    @Override
    public List<CharacterRace> getAll() {
        return races;
    }

    @Override
    public void insert(CharacterRace characterRace) {
        //TODO: Implement insert logic
        races.add(characterRace);
    }

    @Override
    public void update(CharacterRace characterRace, String[] params) {
        //TODO: Implement update logic
        races.add(characterRace);
    }

    @Override
    public void delete(CharacterRace characterRace) {
        races.remove(characterRace);
    }
}
