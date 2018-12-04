package com.pokenshin.dnd5e.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokenshin.dnd5e.entity.CharacterClass;
import com.pokenshin.dnd5e.entity.Race;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class JsonMapper {
    private String basePath = "json/";
    private String racesPath = "races/";
    private String classPath = "classes/";

    public Race getRace(String fileName){
        Race race = new Race();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();

        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + racesPath + fileName)).getFile());
        try {
            race = objectMapper.readValue(file, Race.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return race;
    }

    public CharacterClass getCharacterClass(String fileName){
        CharacterClass characterClass = new CharacterClass();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();

        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + classPath + fileName)).getFile());
        try {
            characterClass = objectMapper.readValue(file, CharacterClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return characterClass;
    }

    public HashMap<Integer, Race> getAllRaces(){
        HashMap<Integer, Race> result = new HashMap<>();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        String[] fileList = new File(Objects.requireNonNull(classLoader.getResource(basePath + racesPath)).getFile()).list();
        if (fileList != null){
            for (String fileName: fileList ) {
                Race race = this.getRace(fileName);
                result.put(race.getId(), race);
            }
        }
        return result;
    }

    public HashMap<Integer,CharacterClass> getAllCharacterClasses() {
        HashMap<Integer, CharacterClass> result = new HashMap<>();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        String[] fileList = new File(Objects.requireNonNull(classLoader.getResource(basePath + racesPath)).getFile()).list();
        if (fileList != null){
            for (String fileName: fileList ) {
                CharacterClass characterClass = this.getCharacterClass(fileName);
                result.put(characterClass.getId(), characterClass);
            }
        }
        return result;
    }
}
