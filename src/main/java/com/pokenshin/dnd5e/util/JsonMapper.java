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
        Map<Integer, CharacterRace> result = new HashMap<>();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        String[] fileList = new File(Objects.requireNonNull(classLoader.getResource(basePath + racesPath)).getFile()).list();
        if (fileList != null){
            for (String fileName: fileList ) {
                CharacterRace race = this.getRace(fileName);
                result.put(race.getId(), race);
            }
        }
        return result;
    }
}
