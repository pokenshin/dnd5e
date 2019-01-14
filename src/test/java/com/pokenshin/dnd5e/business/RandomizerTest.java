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
    void getRandomListItemStringNull(){
        assertNull(randomizer.getRandomListItemString(new ArrayList<>()));
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
    void getRandomStartingEquipmentBarbarian(){
        CharacterClass barbarian = new CharacterClass();
        barbarian.setName("Barbarian");
        ArrayList<Item> result = randomizer.getRandomStartingEquipment(barbarian);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getRandomMusicalInstrument(){
        Item instrument = randomizer.getRandomToolItemByCategory("Musical Instrument");
        assertNotNull(instrument);
        assertTrue(instrument.getCategory().equals("Musical Instrument"));
    }

    @Test
    void getRandomStartingEquipmentBard(){
        CharacterClass bard = new CharacterClass();
        bard.setName("Bard");
        ArrayList<Item> result = randomizer.getRandomStartingEquipment(bard);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void generateBalancedAbilityScoresWithLessThanSix(){
        Character character = new Character();
        character = randomizer.generateBalancedAbilityScores(2, character);
        assertEquals(1, character.getStrength().getValue());
        assertEquals(1, character.getDexterity().getValue());
        assertEquals(1, character.getIntelligence().getValue());
        assertEquals(1, character.getConstitution().getValue());
        assertEquals(1, character.getWisdom().getValue());
        assertEquals(1, character.getCharisma().getValue());
    }

    @Test
    void generateBalancedAbilityScoresWithAHighValue(){
        Character character = new Character();
        character = randomizer.generateBalancedAbilityScores(150, character);
        assertTrue(character.getStrength().getValue() > 0 );
        assertTrue(character.getDexterity().getValue() > 0 );
        assertTrue(character.getIntelligence().getValue() > 0 );
        assertTrue(character.getConstitution().getValue() > 0 );
        assertTrue(character.getWisdom().getValue() > 0 );
        assertTrue(character.getCharisma().getValue() > 0 );
    }

    @Test
    void getRandomStartingEquipmentCleric(){
        CharacterClass cleric = new CharacterClass();
        cleric.setName("Cleric");
        ArrayList<Item> result = randomizer.getRandomStartingEquipment(cleric);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getRandomStartingEquipmentDruid(){
        CharacterClass druid = new CharacterClass();
        druid.setName("Druid");
        ArrayList<Item> result = randomizer.getRandomStartingEquipment(druid);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getRandomStartingEquipmentFighter(){
        CharacterClass fighter = new CharacterClass();
        fighter.setName("Fighter");
        ArrayList<Item> result = randomizer.getRandomStartingEquipment(fighter);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getRandomStartingEquipmentMonk(){
        CharacterClass monk = new CharacterClass();
        monk.setName("Monk");
        ArrayList<Item> result = randomizer.getRandomStartingEquipment(monk);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getRandomStartingEquipmentPaladin(){
        CharacterClass paladin = new CharacterClass();
        paladin.setName("Paladin");
        ArrayList<Item> result = randomizer.getRandomStartingEquipment(paladin);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}