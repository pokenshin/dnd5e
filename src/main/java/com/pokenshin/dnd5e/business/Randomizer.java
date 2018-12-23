package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterClass;
import com.pokenshin.dnd5e.entity.Dice;
import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {
    private Random rng;

    public Randomizer(){
        rng = new Random();
    }

    /**
     * Returns a random race from the json list of races in the resources folder.
     * @return Race object randomly built from the list of races in the resources folder.
     */
    public Race getRandomRace(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, Race> raceList = mapper.getAllRaces();
        Race race = raceList.get(ThreadLocalRandom.current().nextInt(1, raceList.size()));
        return race;
    }

    public CharacterClass getRandomClass(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, CharacterClass> classList = mapper.getAllCharacterClasses();
        CharacterClass characterClass = classList.get(ThreadLocalRandom.current().nextInt(1,classList.size()));
        return characterClass;
    }

    public int getRandomHeight(Race race){
        int result = race.getBaseHeight();
        DiceBusiness dice = new DiceBusiness(race.getHeightModifier());
        result = result + dice.getRoll();
        return result;
    }

    public int getRandomWeight(Race race){
        int result = race.getBaseWeight();
        DiceBusiness dice = new DiceBusiness(race.getWeightModifier());
        result = result + dice.getRoll();
        return result;
    }
}
