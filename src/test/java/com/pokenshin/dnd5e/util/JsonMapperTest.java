package com.pokenshin.dnd5e.util;

import com.pokenshin.dnd5e.entity.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonMapperTest {
    JsonMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new JsonMapper();
    }

    @Test
    void getRace() {
        Race human = mapper.getRace("human.json");
        assertEquals(8, human.getId());
        assertEquals("Human", human.getName());
    }

    @Test
    void getCharacterBackground() {
        CharacterBackground soldier = mapper.getCharacterBackground("soldier.json");
        assertEquals(11, soldier.getId());
        assertEquals("Soldier", soldier.getName());
    }

    @Test
    void getAllCharacterBackgrounds() {
        assertTrue(mapper.getAllCharacterBackgrounds().size() > 0);
    }

    @Test
    void getCharacterClass() {
        CharacterClass barbarian = mapper.getCharacterClass("barbarian.json");
        assertEquals(1, barbarian.getId());
        assertEquals("Barbarian", barbarian.getName());
    }

    @Test
    void getWeapon(){
        Weapon longsword = mapper.getWeapon("longsword.json");
        assertEquals(36, longsword.getId());
        assertEquals("Longsword", longsword.getName());
    }

    @Test
    void getArmor(){
        Armor plateMail = mapper.getArmor("plate.json");
        assertEquals(12, plateMail.getId());
        assertEquals("Plate Mail", plateMail.getName());
    }

    @Test
    void getAllWeapons(){
        assertTrue(mapper.getAllWeapons().size() > 0);
    }

    @Test
    void getAllArmors(){
        assertTrue(mapper.getAllArmors().size() > 0);
    }

    @Test
    void getAllRaces() {
        assertTrue(mapper.getAllRaces().size() > 0);
    }

    @Test
    void getAllCharacterClasses() {
        assertTrue(mapper.getAllCharacterClasses().size() > 0);
    }

    @Test
    void getAllWeaponsByCategory(){
        assertTrue(mapper.getAllWeaponsByCategory("Martial Weapon").size() > 0);
    }
}