package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.entity.Character;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomizerTest {
    Randomizer randomizer;

    @BeforeEach
    void setUp() {
        randomizer = new Randomizer();
    }

    @Test
    void getRandomRace() {
        assertNotNull(randomizer.getRandomRace());
    }

    @Test
    void getRandomClass() {
        assertNotNull(randomizer.getRandomClass());
    }

    @Test
    void getRandomHeight(){
        JsonMapper mapper = new JsonMapper();
        Race elf =  mapper.getRace("elf.json");
        int height = randomizer.getRandomHeight(elf);
        assertTrue(height > 140);
        assertTrue(height < 161);
    }

    @Test
    void getRandomWeight(){
        JsonMapper mapper = new JsonMapper();
        Race elf =  mapper.getRace("elf.json");
        int weight = randomizer.getRandomWeight(elf);
        assertTrue(weight > 40);
        assertTrue(weight < 45);
    }

    @Test
    void getRandomBackground() {
        assertNotNull(randomizer.getRandomBackground());
    }

    @Test
    void getRandomListItemString(){
        JsonMapper mapper = new JsonMapper();
        List<String> bonds = mapper.getCharacterBackground("acolyte.json").getBonds();
        assertNotNull(randomizer.getRandomListItemString(bonds));
    }

    @Test
    void getRandomAlignment(){
        assertNotNull(randomizer.getRandomAlignment());
    }

    @Test
    void generateBalancedAbilityScores(){
        Character character = new Character();
        character = randomizer.generateBalancedAbilityScores(72, character);
        assertTrue(character.getStrength().getValue() > 0);
        assertTrue(character.getDexterity().getValue() > 0);
        assertTrue(character.getIntelligence().getValue() > 0);
        assertTrue(character.getConstitution().getValue() > 0);
        assertTrue(character.getWisdom().getValue() > 0);
        assertTrue(character.getCharisma().getValue() > 0);
    }

    @Test
    void getRandomWeapon(){
        assertNotNull(randomizer.getRandomWeapon());
    }

    @Test
    void getRandomArmor(){
        assertNotNull(randomizer.getRandomArmor());
    }

    @Test
    void getRandomWeaponByCategory(){
        Weapon weapon = randomizer.getRandomWeaponByCategory("Martial Weapon");
        assertTrue(weapon.getCategory().equals("Martial Weapon"));
    }

    @Test
    void generateRandomCharacter() {
        Character character = randomizer.getRandomCharacter(72);
        assertNotNull(character);
        assertEquals(1, character.getLevel());
        assertEquals(0, character.getExperience());
        assertNotEquals("", character.getRace().getName());
        assertNotEquals("", character.getCharacterClass().getName());
        assertNotEquals("", character.getBackground());
        assertTrue(character.getStrength().getValue() > 0);
        assertTrue(character.getStrength().getValue() < 19);
        assertTrue(character.getDexterity().getValue() > 0);
        assertTrue(character.getDexterity().getValue() < 19);
        assertTrue(character.getConstitution().getValue() > 0);
        assertTrue(character.getConstitution().getValue() < 19);
        assertTrue(character.getIntelligence().getValue() > 0);
        assertTrue(character.getIntelligence().getValue() < 19);
        assertTrue(character.getWisdom().getValue() > 0);
        assertTrue(character.getWisdom().getValue() < 19);
        assertTrue(character.getCharisma().getValue() > 0);
        assertTrue(character.getCharisma().getValue() < 19);
    }

    @Test
    void getRandomStartingEquipment(){
        Character character = new Character();
        CharacterClass barbarian = new CharacterClass();
        barbarian.setName("Barbarian");
        character.setCharacterClass(barbarian);
        character.setEquipment(randomizer.getRandomStartingEquipment(character));
        assertTrue(character.getEquipment().size() > 0);

    }

    @Test
    void getRandomMusicalInstrument(){
        Item instrument = randomizer.getRandomToolItemByCategory("Musical Instrument");
        assertNotNull(instrument);
        assertTrue(instrument.getCategory().equals("Musical Instrument"));
    }
}