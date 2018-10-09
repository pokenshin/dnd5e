package com.pokenshin.dnd5e.dao;

import com.pokenshin.dnd5e.character.CharacterRace;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RaceDao implements Dao<CharacterRace> {
    private List<CharacterRace> races = new ArrayList<>();

    public RaceDao(){
        //TODO: populate the races property with data from a database
    }

    @Override
    public Optional<CharacterRace> get(long id) {
        return Optional.ofNullable(races.get((int) id));
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
