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
    void addCharacterSkillAdvantagesTrue(){
        CharacterSkills skills = new CharacterSkills();
        character = new Character();
        skills.getAcrobatics().setAdvantage(true);
        skills.getPersuasion().setAdvantage(true);
        skills.getReligion().setAdvantage(true);
        skills.getArcana().setAdvantage(true);
        skills.getAthletics().setAdvantage(true);
        skills.getHistory().setAdvantage(true);
        skills.getStealth().setAdvantage(true);
        skills.getAnimalHandling().setAdvantage(true);
        skills.getDeception().setAdvantage(true);
        skills.getInsight().setAdvantage(true);
        skills.getIntimidation().setAdvantage(true);
        skills.getInvestigation().setAdvantage(true);
        skills.getMedicine().setAdvantage(true);
        skills.getNature().setAdvantage(true);
        skills.getPerception().setAdvantage(true);
        skills.getSleightOfHand().setAdvantage(true);
        skills.getSurvival().setAdvantage(true);
        skills.getPerformance().setAdvantage(true);
        character = business.addCharacterSkillAdvantages(new Character(), skills);
        assertTrue(character.getSkills().getAcrobatics().isAdvantage());
        assertTrue(character.getSkills().getPersuasion().isAdvantage());
        assertTrue(character.getSkills().getReligion().isAdvantage());
        assertTrue(character.getSkills().getArcana().isAdvantage());
        assertTrue(character.getSkills().getAthletics().isAdvantage());
        assertTrue(character.getSkills().getHistory().isAdvantage());
        assertTrue(character.getSkills().getStealth().isAdvantage());
        assertTrue(character.getSkills().getAnimalHandling().isAdvantage());
        assertTrue(character.getSkills().getDeception().isAdvantage());
        assertTrue(character.getSkills().getInsight().isAdvantage());
        assertTrue(character.getSkills().getIntimidation().isAdvantage());
        assertTrue(character.getSkills().getInvestigation().isAdvantage());
        assertTrue(character.getSkills().getMedicine().isAdvantage());
        assertTrue(character.getSkills().getNature().isAdvantage());
        assertTrue(character.getSkills().getPerception().isAdvantage());
        assertTrue(character.getSkills().getSleightOfHand().isAdvantage());
        assertTrue(character.getSkills().getSurvival().isAdvantage());
        assertTrue(character.getSkills().getPerformance().isAdvantage());
    }

    @Test
    void addCharacterSkillAdvantagesFalse(){
        CharacterSkills skills = new CharacterSkills();
        character = new Character();
        skills.getAcrobatics().setAdvantage(false);
        skills.getPersuasion().setAdvantage(false);
        skills.getReligion().setAdvantage(false);
        skills.getArcana().setAdvantage(false);
        skills.getAthletics().setAdvantage(false);
        skills.getHistory().setAdvantage(false);
        skills.getStealth().setAdvantage(false);
        skills.getAnimalHandling().setAdvantage(false);
        skills.getDeception().setAdvantage(false);
        skills.getInsight().setAdvantage(false);
        skills.getIntimidation().setAdvantage(false);
        skills.getInvestigation().setAdvantage(false);
        skills.getMedicine().setAdvantage(false);
        skills.getNature().setAdvantage(false);
        skills.getPerception().setAdvantage(false);
        skills.getSleightOfHand().setAdvantage(false);
        skills.getSurvival().setAdvantage(false);
        skills.getPerformance().setAdvantage(false);
        character = business.addCharacterSkillAdvantages(new Character(), skills);
        assertFalse(character.getSkills().getAcrobatics().isAdvantage());
        assertFalse(character.getSkills().getPersuasion().isAdvantage());
        assertFalse(character.getSkills().getReligion().isAdvantage());
        assertFalse(character.getSkills().getArcana().isAdvantage());
        assertFalse(character.getSkills().getAthletics().isAdvantage());
        assertFalse(character.getSkills().getHistory().isAdvantage());
        assertFalse(character.getSkills().getStealth().isAdvantage());
        assertFalse(character.getSkills().getAnimalHandling().isAdvantage());
        assertFalse(character.getSkills().getDeception().isAdvantage());
        assertFalse(character.getSkills().getInsight().isAdvantage());
        assertFalse(character.getSkills().getIntimidation().isAdvantage());
        assertFalse(character.getSkills().getInvestigation().isAdvantage());
        assertFalse(character.getSkills().getMedicine().isAdvantage());
        assertFalse(character.getSkills().getNature().isAdvantage());
        assertFalse(character.getSkills().getPerception().isAdvantage());
        assertFalse(character.getSkills().getSleightOfHand().isAdvantage());
        assertFalse(character.getSkills().getSurvival().isAdvantage());
        assertFalse(character.getSkills().getPerformance().isAdvantage());
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
    void applyBackgroundLawfulEvil() {
        JsonMapper mapper = new JsonMapper();
        CharacterBackground background = mapper.getCharacterBackground("outlander.json");
        character = new Character();
        character.setAlignment("Lawful Evil");
        character = business.applyBackground(character, background);
        assertTrue(character.getIdeals().size() > 0);
    }

    @Test
    void applyBackgroundChaoticEvil() {
        JsonMapper mapper = new JsonMapper();
        CharacterBackground background = mapper.getCharacterBackground("outlander.json");
        character = new Character();
        character.setAlignment("ChaoticEvil");
        character = business.applyBackground(character, background);
        assertTrue(character.getIdeals().size() > 0);
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

    @Test
    void calculateNewCharacterAddAnyLanguage(){
        Character character = new Character();
        character.getLanguages().add("Placeholder");
        CharacterAbility intelligence = new CharacterAbility();
        intelligence.setModifier(4);
        character.setIntelligence(intelligence);
        business.calculateNewCharacter(character);
        assertEquals(4, character.getLanguages().size());
    }
}