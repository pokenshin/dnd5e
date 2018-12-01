package com.pokenshin.dnd5e.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokenshin.dnd5e.entity.Race;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class JsonMapper {
    private String basePath = "json/";
    private String racesPath = "races/";

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
}
