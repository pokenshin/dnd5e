package com.pokenshin.dnd5e.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokenshin.dnd5e.character.CharacterRace;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonMapper {
    private String basePath = "json/";
    private String racesPath = "races/";

    public CharacterRace getRace(String fileName){
        CharacterRace race = new CharacterRace();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();

        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + racesPath + fileName)).getFile());
        try {
            race = objectMapper.readValue(file, CharacterRace.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return race;
    }

    public Map<Integer, CharacterRace> getAllRaces(){
        //TODO: Make this dynamically get all files in the /races folder and transform them into stuff
        Map<Integer, CharacterRace> result = new HashMap<>();
        result.put(1, this.getRace("human.json"));
        result.put(2, this.getRace("elf.json"));
        return result;
    }
}
