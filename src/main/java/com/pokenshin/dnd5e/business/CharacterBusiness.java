package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.*;
import com.pokenshin.dnd5e.entity.Character;

import java.util.ArrayList;
import java.util.List;

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
        int totalAbilityValues = 72;

        result.setLevel(1);
        result.setExperience(0);
        result.setAlignment(randomizer.getRandomAlignment());
        result.setCharacterName("Random Character");
        result.setPlayerName("The Computer");
        result = randomizer.generateBalancedAbilityScores(totalAbilityValues, result);
        result.getStrength().setModifier(this.getModifier(result.getStrength().getValue()));
        result.getDexterity().setModifier(this.getModifier(result.getDexterity().getValue()));
        result.getConstitution().setModifier(this.getModifier(result.getConstitution().getValue()));
        result.getIntelligence().setModifier(this.getModifier(result.getIntelligence().getValue()));
        result.getWisdom().setModifier(this.getModifier(result.getWisdom().getValue()));
        result.getCharisma().setModifier(this.getModifier(result.getCharisma().getValue()));
        this.applyRace(result, randomizer.getRandomRace());
        this.applyCharacterClass(result, randomizer.getRandomClass());
        this.applyBackground(result, randomizer.getRandomBackground());
        result.setHeight(randomizer.getRandomHeight(result.getRace()));
        result.setWeight(randomizer.getRandomWeight(result.getRace()));

        result = this.calculateNewCharacter(result);
        //TODO: Define spells if applicable. Based on class. Spell attack bonus = primary spellcasting stat + proficiency bonus.

        return result;
    }

    public Character calculateNewCharacter(Character character){
        List<String> baseLanguages = character.getLanguages();

        //Initiative = dex modifier
        character.setInitiative(character.getDexterity().getModifier());
        //Passive Perception = 10 + wis modifier
        character.setPerception(10 + character.getWisdom().getModifier());
        //HP = Hit Dice + con modifier
        character.setHpMax(character.getHitDice().getSides() + character.getConstitution().getModifier());
        character.setHpCurrent(character.getHpMax());
        character.setTotalHitDice(character.getHitDice().getRolls());
        //Languages = Common + Int Modifier
        character.setLanguages(new ArrayList<>());
        character.getLanguages().add("Common");
        while(character.getLanguages().size() < character.getIntelligence().getModifier()){
            int i = 0;
            if (i + 1 < baseLanguages.size()) {
                character.getLanguages().add(baseLanguages.get(i));
            } else{
                character.getLanguages().add("Any");
            }
            i += 1;
        }
        character.setProficiencyBonus(this.calculateProficiencyBonus(character));
        character = this.calculateSkillValues(character);

        //TODO: Define Armor Class (armors rating + dex mod if light armors, +2 dex bonus if medium, 0 dex bonus if heavy)
        //TODO: Attack bonus (str mod (melee) or dex mod (ranged) + proficiency bonus). Damage = weapon + str or dex mod
        return character;
    }

    public int calculateProficiencyBonus(Character character) {
        int bonus = (character.getLevel() / 4) + 2;

        return bonus;
    }

    public Character calculateSkillValues(Character character){
        character.getSkills().getAcrobatics().setValue((character.getSkills().getAcrobatics().isAdvantage()) ? character.getDexterity().getModifier() + character.getProficiencyBonus() : character.getDexterity().getModifier());
        character.getSkills().getAnimalHandling().setValue((character.getSkills().getAnimalHandling().isAdvantage()) ? character.getWisdom().getModifier() + character.getProficiencyBonus() : character.getWisdom().getModifier());
        character.getSkills().getArcana().setValue((character.getSkills().getArcana().isAdvantage()) ? character.getIntelligence().getModifier() + character.getProficiencyBonus() : character.getIntelligence().getModifier());
        character.getSkills().getAthletics().setValue((character.getSkills().getAthletics().isAdvantage()) ? character.getStrength().getModifier() + character.getProficiencyBonus() : character.getStrength().getModifier());
        character.getSkills().getDeception().setValue((character.getSkills().getDeception().isAdvantage()) ? character.getCharisma().getModifier() + character.getProficiencyBonus() : character.getCharisma().getModifier());
        character.getSkills().getHistory().setValue((character.getSkills().getHistory().isAdvantage()) ? character.getIntelligence().getModifier() + character.getProficiencyBonus() : character.getIntelligence().getModifier());
        character.getSkills().getInsight().setValue((character.getSkills().getInsight().isAdvantage()) ? character.getWisdom().getModifier() + character.getProficiencyBonus() : character.getWisdom().getModifier());
        character.getSkills().getIntimidation().setValue((character.getSkills().getIntimidation().isAdvantage()) ? character.getCharisma().getModifier() + character.getProficiencyBonus() : character.getCharisma().getModifier());
        character.getSkills().getInvestigation().setValue((character.getSkills().getInvestigation().isAdvantage()) ? character.getIntelligence().getModifier() + character.getProficiencyBonus() : character.getIntelligence().getModifier());
        character.getSkills().getMedicine().setValue((character.getSkills().getMedicine().isAdvantage()) ? character.getWisdom().getModifier() + character.getProficiencyBonus() : character.getWisdom().getModifier());
        character.getSkills().getNature().setValue((character.getSkills().getNature().isAdvantage()) ? character.getIntelligence().getModifier() + character.getProficiencyBonus() : character.getIntelligence().getModifier());
        character.getSkills().getPerception().setValue((character.getSkills().getPerception().isAdvantage()) ? character.getWisdom().getModifier() + character.getProficiencyBonus() : character.getWisdom().getModifier());
        character.getSkills().getPersuasion().setValue((character.getSkills().getPersuasion().isAdvantage()) ? character.getCharisma().getModifier() + character.getProficiencyBonus() : character.getCharisma().getModifier());
        character.getSkills().getReligion().setValue((character.getSkills().getReligion().isAdvantage()) ? character.getIntelligence().getModifier() + character.getProficiencyBonus() : character.getIntelligence().getModifier());
        character.getSkills().getSleightOfHand().setValue((character.getSkills().getSleightOfHand().isAdvantage()) ? character.getDexterity().getModifier() + character.getProficiencyBonus() : character.getDexterity().getModifier());
        character.getSkills().getStealth().setValue((character.getSkills().getStealth().isAdvantage()) ? character.getDexterity().getModifier() + character.getProficiencyBonus() : character.getDexterity().getModifier());
        character.getSkills().getSurvival().setValue((character.getSkills().getSurvival().isAdvantage()) ? character.getWisdom().getModifier() + character.getProficiencyBonus() : character.getWisdom().getModifier());

        return character;
    }


    /**
     * Applies a predetermined CharacterBackground to a Character
     * @param character The character that will have a CharacterBackground applied.
     * @param background The background that will be applied to the character;
     * @return Character object with the CharacterObject applied to it
     */

    public Character applyBackground(Character character, CharacterBackground background) {
        CharacterCurrencyBusiness characterCurrencyBusiness = new CharacterCurrencyBusiness();
        Randomizer rng = new Randomizer();
        List<String> possibleIdeals = new ArrayList<>();

        character.setBackground(background.getName());
        character = this.addCharacterSkillAdvantages(character, background.getSkillProficiencies());
        character.getProficiencies().addAll(background.getToolProficiencies());
        character.getLanguages().addAll(background.getLanguages());
        character.getEquipment().addAll(background.getEquipment());
        character.setCurrency(characterCurrencyBusiness.addMoney(character.getCurrency(), background.getStartingMoney()));
        character.getFeatures().addAll(background.getFeatures());
        character.getTraits().add(rng.getRandomListItemString(background.getPersonalityTraits()));
        character.getTraits().add(rng.getRandomListItemString(background.getAdditionalTraits()));

        if (character.getAlignment().contains("Lawful"))
            possibleIdeals.add((background.getIdealLawful()));

        if (character.getAlignment().contains("Good"))
            possibleIdeals.add(background.getIdealGood());

        if (character.getAlignment().contains("Chaotic"))
            possibleIdeals.add(background.getIdealChaotic());

        if (character.getAlignment().contains("Evil"))
            possibleIdeals.add(background.getIdealEvil());

        if (character.getAlignment().contains("Neutral"))
            possibleIdeals.add(background.getIdealNeutral());

        possibleIdeals.add(background.getIdealAny());
        character.getIdeals().add(rng.getRandomListItemString(possibleIdeals));
        character.getFlaws().add(rng.getRandomListItemString(background.getFlaws()));
        character.getBonds().add(rng.getRandomListItemString(background.getBonds()));

        return character;
    }

    /**
     * Adds Skill advantages to a Character
     * @param character
     * @param skillProficiencies
     * @return an updated Character Object
     */
    public Character addCharacterSkillAdvantages(Character character, CharacterSkills skillProficiencies){
        //TODO: do this more gracefully
        if (!character.getSkills().getAcrobatics().isAdvantage() && skillProficiencies.getAcrobatics().isAdvantage())
            character.getSkills().getAcrobatics().setAdvantage(true);
        if (!character.getSkills().getAnimalHandling().isAdvantage() && skillProficiencies.getAnimalHandling().isAdvantage())
            character.getSkills().getAnimalHandling().setAdvantage(true);
        if (!character.getSkills().getArcana().isAdvantage() && skillProficiencies.getArcana().isAdvantage())
            character.getSkills().getArcana().setAdvantage(true);
        if (!character.getSkills().getAthletics().isAdvantage() && skillProficiencies.getAthletics().isAdvantage())
            character.getSkills().getAthletics().setAdvantage(true);
        if (!character.getSkills().getDeception().isAdvantage() && skillProficiencies.getDeception().isAdvantage())
            character.getSkills().getDeception().setAdvantage(true);
        if (!character.getSkills().getAcrobatics().isAdvantage() && skillProficiencies.getAcrobatics().isAdvantage())
            character.getSkills().getAcrobatics().setAdvantage(true);
        if (!character.getSkills().getHistory().isAdvantage() && skillProficiencies.getHistory().isAdvantage())
            character.getSkills().getHistory().setAdvantage(true);
        if (!character.getSkills().getInsight().isAdvantage() && skillProficiencies.getInsight().isAdvantage())
            character.getSkills().getInsight().setAdvantage(true);
        if (!character.getSkills().getIntimidation().isAdvantage() && skillProficiencies.getIntimidation().isAdvantage())
            character.getSkills().getIntimidation().setAdvantage(true);
        if (!character.getSkills().getInvestigation().isAdvantage() && skillProficiencies.getInvestigation().isAdvantage())
            character.getSkills().getInvestigation().setAdvantage(true);
        if (!character.getSkills().getMedicine().isAdvantage() && skillProficiencies.getMedicine().isAdvantage())
            character.getSkills().getMedicine().setAdvantage(true);
        if (!character.getSkills().getNature().isAdvantage() && skillProficiencies.getNature().isAdvantage())
            character.getSkills().getNature().setAdvantage(true);
        if (!character.getSkills().getPerception().isAdvantage() && skillProficiencies.getPerception().isAdvantage())
            character.getSkills().getPerception().setAdvantage(true);
        if (!character.getSkills().getPerformance().isAdvantage() && skillProficiencies.getPerformance().isAdvantage())
            character.getSkills().getPerformance().setAdvantage(true);
        if (!character.getSkills().getPersuasion().isAdvantage() && skillProficiencies.getPersuasion().isAdvantage())
            character.getSkills().getPersuasion().setAdvantage(true);
        if (!character.getSkills().getReligion().isAdvantage() && skillProficiencies.getReligion().isAdvantage())
            character.getSkills().getReligion().setAdvantage(true);
        if (!character.getSkills().getSleightOfHand().isAdvantage() && skillProficiencies.getSleightOfHand().isAdvantage())
            character.getSkills().getSleightOfHand().setAdvantage(true);
        if (!character.getSkills().getStealth().isAdvantage() && skillProficiencies.getStealth().isAdvantage())
            character.getSkills().getStealth().setAdvantage(true);
        if (!character.getSkills().getSurvival().isAdvantage() && skillProficiencies.getSurvival().isAdvantage())
            character.getSkills().getSurvival().setAdvantage(true);

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
        character.getStrength().setModifier(this.getModifier(character.getStrength().getValue()));
        character.getDexterity().setValue(character.getDexterity().getValue() + race.getAbilityIncrease().get(1));
        character.getDexterity().setModifier(this.getModifier(character.getDexterity().getValue()));
        character.getConstitution().setValue(character.getConstitution().getValue() + race.getAbilityIncrease().get(2));
        character.getConstitution().setModifier(this.getModifier(character.getConstitution().getValue()));
        character.getIntelligence().setValue(character.getIntelligence().getValue() + race.getAbilityIncrease().get(3));
        character.getIntelligence().setModifier(this.getModifier(character.getIntelligence().getValue()));
        character.getWisdom().setValue(character.getWisdom().getValue() + race.getAbilityIncrease().get(4));
        character.getWisdom().setModifier(this.getModifier(character.getWisdom().getValue()));
        character.getCharisma().setValue(character.getCharisma().getValue() + race.getAbilityIncrease().get(5));
        character.getCharisma().setModifier(this.getModifier(character.getCharisma().getValue()));
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
