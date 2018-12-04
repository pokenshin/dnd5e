package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterClass;
import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.Map;
import java.util.Random;

public class Randomizer {
    private Random rng;

    public Randomizer(){
        initRandom();
    }

    /**
     * Initializes the RNG variable.
     */
    private void initRandom(){
        rng = new Random();
    }

    /**
     * Returns a random race from the json list of races in the resources folder.
     * @return Race object randomly built from the list of races in the resources folder.
     */
    public Race getRandomRace(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, Race> raceList = mapper.getAllRaces();
        return raceList.get(rng.nextInt(raceList.size()));
    }

    public CharacterClass getRandomClass(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, CharacterClass> raceList = mapper.getAllCharacterClasses();
        return raceList.get(rng.nextInt(raceList.size()));
    }
}
