package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterAbility;
import com.pokenshin.dnd5e.entity.Character;
import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterBusinessTest {
    private CharacterBusiness business;

    @BeforeEach
    void SetUp(){
         business = new CharacterBusiness();
    }

    @Test
    void resetAbilityScores() {
        Character character = new Character();

        character = business.resetAbilityScores(character);

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
        Character character = new Character();
        JsonMapper mapper = new JsonMapper();
        Race human = mapper.getRace("human.json");

        character = business.applyRace(character, human);

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
}