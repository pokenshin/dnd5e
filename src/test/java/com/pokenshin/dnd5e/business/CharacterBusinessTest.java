package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterAbility;
import com.pokenshin.dnd5e.entity.Character;
import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterBusinessTest {
    CharacterBusiness business;

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
}