package com.pokenshin.dnd5e.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokenshin.dnd5e.character.CharacterRace;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonMapper {
    private String jsonPath = "json/";

    public CharacterRace getRace(String filePath){
        CharacterRace race = new CharacterRace();
        ObjectMapper objectMapper = new ObjectMapper();
        ClassLoader classLoader = new JsonMapper().getClass().getClassLoader();
        File file = new File(classLoader.getResource(jsonPath + filePath).getFile());
        try {
            race = objectMapper.readValue(file, CharacterRace.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return race;
    }
}
