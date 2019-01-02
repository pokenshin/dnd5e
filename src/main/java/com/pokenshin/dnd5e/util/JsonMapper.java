package com.pokenshin.dnd5e.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokenshin.dnd5e.entity.*;

import java.io.File;
import java.util.HashMap;
import java.util.Objects;

public class JsonMapper {
    private String basePath = "json/";
    private String racesPath = "races/";
    private String classPath = "classes/";
    private String backgroundPath = "backgrounds/";
    private String itemPath = "items/";
    private String weaponPath = "weapons/";
    private String armorPath = "armors/";
    private ObjectMapper mapper;

    private void init(){
        mapper = new ObjectMapper();
    }


    public Race getRace(String fileName){
        Race race = new Race();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        this.init();
        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + racesPath + fileName)).getFile());
        try {
            race = mapper.readValue(file, Race.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return race;
    }

    public CharacterClass getCharacterClass(String fileName){
        CharacterClass characterClass = new CharacterClass();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        this.init();
        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + classPath + fileName)).getFile());
        try {
            characterClass = mapper.readValue(file, CharacterClass.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return characterClass;
    }

    public CharacterBackground getCharacterBackground(String fileName) {
        CharacterBackground characterBackground = new CharacterBackground();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        this.init();
        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + backgroundPath + fileName)).getFile());
        try {
            characterBackground = mapper.readValue(file, CharacterBackground.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return characterBackground;
    }

    public Weapon getWeapon(String fileName) {
        Weapon result = new Weapon();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        this.init();
        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + itemPath + weaponPath + fileName)).getFile());
        try {
            result = mapper.readValue(file, Weapon.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Armor getArmor(String fileName) {
        Armor result = new Armor();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        this.init();
        File file;
        file = new File(Objects.requireNonNull(classLoader.getResource(basePath + itemPath + armorPath + fileName)).getFile());
        try {
            result = mapper.readValue(file, Armor.class);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public HashMap<Integer, Weapon> getAllWeapons(){
        HashMap<Integer, Weapon> result = new HashMap<>();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        String[] fileList = new File(Objects.requireNonNull(classLoader.getResource(basePath + itemPath + weaponPath)).getFile()).list();
        if (fileList != null){
            for (String fileName: fileList ) {
                Weapon weapon = this.getWeapon(fileName);
                result.put(weapon.getId(), weapon);
            }
        }
        return result;
    }

    public HashMap<Integer, Armor> getAllArmors(){
        HashMap<Integer, Armor> result = new HashMap<>();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        String[] fileList = new File(Objects.requireNonNull(classLoader.getResource(basePath + itemPath + armorPath)).getFile()).list();
        if (fileList != null){
            for (String fileName: fileList ) {
                Armor armor = this.getArmor(fileName);
                result.put(armor.getId(), armor);
            }
        }
        return result;
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
        String[] fileList = new File(Objects.requireNonNull(classLoader.getResource(basePath + classPath)).getFile()).list();
        if (fileList != null){
            for (String fileName: fileList ) {
                CharacterClass characterClass = this.getCharacterClass(fileName);
                result.put(characterClass.getId(), characterClass);
            }
        }
        return result;
    }

    public HashMap<Integer, CharacterBackground> getAllCharacterBackgrounds() {
        HashMap<Integer, CharacterBackground> result = new HashMap<>();
        ClassLoader classLoader = JsonMapper.class.getClassLoader();
        String[] fileList = new File(Objects.requireNonNull(classLoader.getResource(basePath + backgroundPath)).getFile()).list();
        if (fileList != null) {
            for (String fileName : fileList) {
                CharacterBackground characterBackground = this.getCharacterBackground(fileName);
                result.put(characterBackground.getId(), characterBackground);
            }
        }
        return result;
    }
}
