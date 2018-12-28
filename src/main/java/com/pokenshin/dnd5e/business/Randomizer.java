package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.entity.Character;
import com.pokenshin.dnd5e.util.JsonMapper;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.prefs.BackingStoreException;

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

    public CharacterBackground getRandomBackground(){
        JsonMapper mapper = new JsonMapper();
        Map<Integer, CharacterBackground> bgList = mapper.getAllCharacterBackgrounds();
        CharacterBackground background = bgList.get(ThreadLocalRandom.current().nextInt(1, bgList.size()));
        return background;
    }

    public String getRandomListItemString(List<String> list){
        if (list.size() > 0){
            return list.get(ThreadLocalRandom.current().nextInt(0, list.size()));
        } else return null;
    }

    public String getRandomAlignment() {
        List<String> possibleAligments = Arrays.asList("Lawful Good", "Lawful Neutral", "Lawful Evil", "Neutral Good", "True Neutral", "Neutral Evil", "Chaotic Good", "Chaotic Neutral", "Chaotic Evil");
        return this.getRandomListItemString(possibleAligments);
    }

    public Character generateBalancedAbilityScores(int totalPoints, Character character){
        if (totalPoints < 6)
            totalPoints = 6;
        totalPoints -= 6;
        List<Integer> values = Arrays.asList(1,1,1,1,1,1);
        int iteration = 0;

        while(iteration < totalPoints){
            int position = ThreadLocalRandom.current().nextInt(0, 6);
            values.set(position, values.get(position) + 1);
            iteration += 1;
        }
        character.getStrength().setValue(values.get(0));
        character.getDexterity().setValue(values.get(1));
        character.getConstitution().setValue(values.get(2));
        character.getIntelligence().setValue(values.get(3));
        character.getWisdom().setValue(values.get(4));
        character.getCharisma().setValue(values.get(5));

        return character;
    }
}
