package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.entity.Character;

import java.lang.reflect.Field;

public class CharacterBusiness {
    /**
     * Resets a Character to its initial values
     * @param character The Character object that will be reset.
     * @return A character reset to its initial values.
     */
    public Character resetCharacter(Character character){
        //Set Level to 1
        character.setLevel(1);
        character.setExperience(0);

        //Set all ability scores to 12
        //character = resetAbilityScores(character);

        return character;
    }

    /**
     * Resets a character's ability scores to 12.
     * @param character The Character object that will have its ability scores reset to 12
     * @return A Character object with its ability scores set to 12
     */
    public Character resetAbilityScores(Character character) {
        CharacterAbility baseAbilityScore = new CharacterAbility(12, 1);
        character.setStrength(baseAbilityScore);
        character.setDexterity(baseAbilityScore);
        character.setConstitution(baseAbilityScore);
        character.setIntelligence(baseAbilityScore);
        character.setWisdom(baseAbilityScore);
        character.setCharisma(baseAbilityScore);
        return character;
    }

    /**
     * Generates a random level 1 Character object.
     * @return A Character object with random values set to level 1.
     */
    public Character generateRandomCharacter(){
        Character result = new Character();
        Randomizer randomizer = new Randomizer();

        result.setLevel(1);
        result.setExperience(0);
        this.applyRace(result, randomizer.getRandomRace());
        this.applyCharacterClass(result, randomizer.getRandomClass());
        this.applyBackground(result, randomizer.getRandomBackground());
        //TODO: Define a random background and apply its bonuses
        //TODO: Roll Ability Scores and assign them according to the class
        //TODO: Define initiative (dex modifier)
        //TODO: Define Passive Wisdom (10 + wis modifier)
        //TODO: Define HP (Roll Hit dice + con modifier)
        //TODO: Define languages (common + int modifier), restricted by race.
        //TODO: Define starting equipment from class/background
        //TODO: Define Armor Class (armor rating + dex mod if light armor, +2 dex bonus if medium, 0 dex bonus if heavy)
        //TODO: Define attack bonus (str mod (melee) or dex mod (ranged) + proficiency bonus). Damage = weapon + str or dex mod
        //TODO: Define spells if applicable. Based on class. Spell attack bonus = primary spellcasting stat + proficiency bonus.
        //TODO: Define Name, Alignment, Personality, Goals, Bonds, Flaws

        return result;
    }

    /**
     * Applies a predetermined CharacterBackground to a Character
     * @param character The character that will have a CharacterBackground applied.
     * @param background The background that will be applied to the character;
     * @return Character object with the CharacterObject applied to it
     */

    private void applyBackground(Character character, CharacterBackground background) {
        character.setBackground(background.getName());
        character = this.addCharacterSkillAdvantages(character, background.getSkillProficiencies());
        character.getProficiencies().addAll(background.getToolProficiencies());
        character.getLanguages().addAll(background.getLanguages());
        character.getEquipment().addAll(background.getEquipment());
        //this.addMoney(character, background.getStartingMoney());
        character.getFeatures().addAll(background.getFeatures());
        //TODO: create a getRandomPersonalityTrait in Randomizer and call it here.
        //TODO: create a getRandomAdditionalTrait in Randomizer and call it here.
        //TODO: create a getRandomIdeal in Randomizer and call it here.
        //TODO: create a getRandomBond in Randomizer and call it here.
        //TODO: create a getRandomFlaw in Randomizer and call it here.


    }

    public Character addCharacterSkillAdvantages(Character character, CharacterSkills skillProficiencies){
        //TODO: do this more gracefully
        character.getSkills().getAcrobatics().setAdvantage(skillProficiencies.getAcrobatics().isAdvantage());
        character.getSkills().getAnimalHandling().setAdvantage(skillProficiencies.getAnimalHandling().isAdvantage());
        character.getSkills().getArcana().setAdvantage(skillProficiencies.getArcana().isAdvantage());
        character.getSkills().getAthletics().setAdvantage((skillProficiencies.getAthletics().isAdvantage()));
        character.getSkills().getDeception().setAdvantage(skillProficiencies.getDeception().isAdvantage());
        character.getSkills().getHistory().setAdvantage(skillProficiencies.getHistory().isAdvantage());
        character.getSkills().getInsight().setAdvantage(skillProficiencies.getInsight().isAdvantage());
        character.getSkills().getIntimidation().setAdvantage(skillProficiencies.getInsight().isAdvantage());
        character.getSkills().getInvestigation().setAdvantage(skillProficiencies.getInsight().isAdvantage());
        character.getSkills().getMedicine().setAdvantage(skillProficiencies.getMedicine().isAdvantage());
        character.getSkills().getNature().setAdvantage(skillProficiencies.getNature().isAdvantage());
        character.getSkills().getPerception().setAdvantage(skillProficiencies.getPerception().isAdvantage());
        character.getSkills().getPerformance().setAdvantage(skillProficiencies.getPerformance().isAdvantage());
        character.getSkills().getPersuasion().setAdvantage(skillProficiencies.getPersuasion().isAdvantage());
        character.getSkills().getReligion().setAdvantage(skillProficiencies.getReligion().isAdvantage());
        character.getSkills().getSleightOfHand().setAdvantage(skillProficiencies.getSleightOfHand().isAdvantage());
        character.getSkills().getStealth().setAdvantage(skillProficiencies.getStealth().isAdvantage());
        character.getSkills().getSurvival().setAdvantage(skillProficiencies.getSurvival().isAdvantage());

        return character;
    }

    /**
     * Applies a random race into a Character object
     * @param character The character that will have a random race applied.
     * @return Character object with a random race applied
     */
    public Character applyRandomRace(Character character){
        Randomizer randomizer = new Randomizer();
        Race randomRace = randomizer.getRandomRace();
        character = this.applyRace(character, randomRace);
        return character;
    }

    /**
     * Returns an ability score modifier according to the value
     * @param value The ability score value
     * @return An integer that represents the modifier score
     */
    public int getModifier(int value){
        if (value >= 10)
            return (value - 10) / 2;
        else
            return (value / 2) - 5;
    }

    /**
     * Applies a race with its modifiers and traits to a Character object
     * @param character The Character object that will get a new race
     * @param race The Race object that will be applied to the Character object
     * @return A Character object with the race applied to it.
     */
    public Character applyRace(Character character, Race race){
        character.setRace(race);
        character.setSpeed(race.getSpeed());
        character.getStrength().setValue(character.getStrength().getValue() + race.getAbilityIncrease().get(0));
        character.getStrength().setModifier(this.getModifier(race.getAbilityIncrease().get(0)));
        character.getDexterity().setValue(character.getDexterity().getValue() + race.getAbilityIncrease().get(1));
        character.getDexterity().setModifier(this.getModifier(race.getAbilityIncrease().get(1)));
        character.getConstitution().setValue(character.getConstitution().getValue() + race.getAbilityIncrease().get(2));
        character.getConstitution().setModifier(this.getModifier(race.getAbilityIncrease().get(2)));
        character.getIntelligence().setValue(character.getIntelligence().getValue() + race.getAbilityIncrease().get(3));
        character.getIntelligence().setModifier(this.getModifier(race.getAbilityIncrease().get(3)));
        character.getWisdom().setValue(character.getWisdom().getValue() + race.getAbilityIncrease().get(4));
        character.getWisdom().setModifier(this.getModifier(race.getAbilityIncrease().get(4)));
        character.getCharisma().setValue(character.getCharisma().getValue() + race.getAbilityIncrease().get(5));
        character.getCharisma().setModifier(this.getModifier(race.getAbilityIncrease().get(5)));
        character.setSize(race.getSize());
        character.getTraits().addAll(race.getOtherTraits());
        character.getLanguages().addAll(race.getLanguages());

        return character;
    }

    /**
     * Applies a CharacterClass object to a Character object
     * @param character The Character object that will be affected
     * @param characterClass The CharacterClass that will be applied to the Character object
     * @return A Character object with the CharacterClass applied to it
     */
    public Character applyCharacterClass(Character character, CharacterClass characterClass){
        character.setCharacterClass(characterClass);
        character.setHitDice(characterClass.getHitDice());
        character.setHpMax(characterClass.getStartingHP());
        character.getProficiencies().addAll(characterClass.getArmorProficiency());
        character.getProficiencies().addAll(characterClass.getWeaponProficiency());
        character.getProficiencies().addAll(characterClass.getTools());
        character.setSavingThrows(characterClass.getSavingThrows());
        return character;
   }
}
