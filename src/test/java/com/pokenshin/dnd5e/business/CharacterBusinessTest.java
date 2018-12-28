package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.controller.CharacterRaceController;
import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.entity.Character;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterBusinessTest {
    private CharacterBusiness business;
    private Character character;

    @BeforeEach
    void SetUp(){
        business = new CharacterBusiness();
    }

    @Test
    void resetAbilityScores() {
        character = business.resetAbilityScores(new Character());

        assertEquals(12, character.getStrength().getValue());
        assertEquals(12, character.getDexterity().getValue());
        assertEquals(12, character.getConstitution().getValue());
        assertEquals(12, character.getIntelligence().getValue());
        assertEquals(12, character.getWisdom().getValue());
        assertEquals(12, character.getCharisma().getValue());
    }

    @Test
    void getModifier() {
        assertEquals(2, business.getModifier(14));
        assertEquals(10, business.getModifier(30));
        assertEquals(-2, business.getModifier(7));
        assertEquals(-5, business.getModifier(1));
    }

    @Test
    void applyRace() {
        JsonMapper mapper = new JsonMapper();
        Race human = mapper.getRace("human.json");

        character = business.applyRace(new Character(), human);

        assertEquals("Human", character.getRace().getName());
        assertEquals(13, character.getStrength().getValue());
        assertEquals(13, character.getDexterity().getValue());
        assertEquals(13, character.getConstitution().getValue());
        assertEquals(13, character.getWisdom().getValue());
        assertEquals(13, character.getIntelligence().getValue());
        assertEquals(13, character.getCharisma().getValue());
        assertEquals("Medium", character.getSize());
        assertEquals(30, character.getSpeed());
        assertEquals(1, character.getTraits().size());
        assertEquals(1, character.getLanguages().size());
    }

    @Test
    void resetCharacter() {
        character = business.resetCharacter(new Character());
        assertEquals(1, character.getLevel());
        assertEquals(0, character.getExperience());
    }


    @Test
    void generateRandomCharacter() {
        character = business.generateRandomCharacter();
        assertNotNull(character);
        assertEquals(1, character.getLevel());
        assertEquals(0, character.getExperience());
        assertNotEquals("", character.getRace().getName());
        assertNotEquals("", character.getCharacterClass().getName());
    }

    @Test
    void applyRandomRace() {
        character = business.applyRandomRace(new Character());
        assertNotEquals(0, character.getRace().getId());
    }

    @Test
    void applyCharacterClass() {
        JsonMapper mapper = new JsonMapper();
        CharacterClass fighter = mapper.getCharacterClass("fighter.json");
        character = business.applyCharacterClass(new Character(), fighter);
        assertEquals("Fighter", character.getCharacterClass().getName());
        assertEquals("1d10", character.getHitDice().toString());
    }

    @Test
    void addCharacterSkillAdvantages(){
        JsonMapper mapper = new JsonMapper();
        CharacterSkills skills = mapper.getCharacterBackground("criminal.json").getSkillProficiencies();
        character = business.addCharacterSkillAdvantages(new Character(), skills);
        assertFalse(character.getSkills().getHistory().isAdvantage());
        assertTrue(character.getSkills().getStealth().isAdvantage());
    }
}