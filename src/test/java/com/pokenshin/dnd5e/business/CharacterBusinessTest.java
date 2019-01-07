package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.entity.Character;
import com.pokenshin.dnd5e.util.JsonMapper;
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

    @Test
    void applyBackground(){
        JsonMapper mapper = new JsonMapper();
        CharacterBackground background = mapper.getCharacterBackground("outlander.json");
        character = new Character();
        character.setAlignment("Neutral Good");
        character = business.applyBackground(character, background);

        assertEquals("Outlander", character.getBackground());
        assertFalse(character.getSkills().getArcana().isAdvantage());
        assertTrue(character.getSkills().getAthletics().isAdvantage());
        assertTrue(character.getProficiencies().stream().anyMatch(str -> str.trim().equals("Musical Instrument")));
        assertEquals(10, character.getCurrency().getGold());
        assertTrue(character.getFeatures().stream().anyMatch(str -> str.trim().equals("Wanderer")));
        assertFalse(character.getTraits().isEmpty());
        assertFalse(character.getIdeals().isEmpty());
        assertFalse(character.getIdeals().stream().anyMatch(str -> str.trim().equals("Change. Life is like the seasons, in constant change, and we must change with it.")));
        assertFalse(character.getBonds().isEmpty());
        assertFalse(character.getFlaws().isEmpty());
    }

    @Test
    void calculateNewCharacter(){
        character = new Character();
        character.getStrength().setValue(10);
        character.getStrength().setModifier(0);
        character.getDexterity().setValue(12);
        character.getDexterity().setModifier(1);
        character.getConstitution().setValue(14);
        character.getConstitution().setModifier(2);
        character.getIntelligence().setValue(16);
        character.getIntelligence().setModifier(3);
        character.getWisdom().setValue(18);
        character.getWisdom().setModifier(4);
        character.getCharisma().setValue(8);
        character.getCharisma().setModifier(-1);
        character.setAlignment("True Neutral");
        character.setHitDice(new Dice("1d10"));
        character.getLanguages().add("Elvish");
        character.getLanguages().add("Dwarvish");
        character.getLanguages().add("Gnomish");
        character.getLanguages().add("Demon");
        character.getLanguages().add("English");

        character = business.calculateNewCharacter(character);

        assertEquals(1, character.getInitiative());
        assertEquals(14, character.getPerception());
        assertTrue(character.getHpMax() < 13);
        assertTrue(character.getHpMax() > 3);
        assertTrue(character.getHpMax() > 0);
        assertEquals(3, character.getLanguages().size());
    }

    @Test
    void calculateSkillValues(){
        JsonMapper mapper = new JsonMapper();
        CharacterSkills skills = mapper.getCharacterBackground("acolyte.json").getSkillProficiencies();
        character = new Character();
        character.getStrength().setValue(10);
        character.getStrength().setModifier(0);
        character.getDexterity().setValue(12);
        character.getDexterity().setModifier(1);
        character.getConstitution().setValue(14);
        character.getConstitution().setModifier(2);
        character.getIntelligence().setValue(16);
        character.getIntelligence().setModifier(3);
        character.getWisdom().setValue(18);
        character.getWisdom().setModifier(4);
        character.getCharisma().setValue(8);
        character.getCharisma().setModifier(-1);
        character.setSkills(skills);
        character.setProficiencyBonus(3);
        character = business.calculateSkillValues(character);

        assertTrue(character.getSkills().getReligion().isAdvantage());
        assertEquals(6, character.getSkills().getReligion().getValue());
        assertFalse(character.getSkills().getPersuasion().isAdvantage());
        assertEquals(-1, character.getSkills().getPersuasion().getValue());
    }

    @Test
    void calculateProficiencyBonus(){
        character = new Character();
        character.setLevel(1);
        character.setProficiencyBonus(business.calculateProficiencyBonus(character));
        assertEquals(2, character.getProficiencyBonus());
    }
}