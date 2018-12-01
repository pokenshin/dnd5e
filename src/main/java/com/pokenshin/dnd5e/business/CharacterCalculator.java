package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterAbility;
import com.pokenshin.dnd5e.entity.Character;
import com.pokenshin.dnd5e.entity.Race;

import java.util.Random;

public class CharacterCalculator {
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
        character = resetAbilityScores(character);

        return character;
    }

    /**
     * Resets a character's ability scores to 12.
     * @param character The Character object that will have its ability scores reset to 12
     * @return A Character object with its ability scores set to 12
     */
    private Character resetAbilityScores(Character character) {
        int defaultAbility = 12;
        character.setStrength(defaultAbility);
        character.setDexterity(defaultAbility);
        character.setConstitution(defaultAbility);
        character.setIntelligence(defaultAbility);
        character.setWisdom(defaultAbility);
        character.setCharisma(defaultAbility);
        return character;
    }

    /**
     * Generates a random level 1 Character object.
     * @return A Character object with random values set to level 1.
     */
    public Character generateRandomCharacter(){
        Character result = new Character();
        Random rng = new Random();

        result.setLevel(1);
        result.setExperience(0);
        //TODO: Define a random Race and apply its bonuses
        //TODO: Define a random Class and apply its bonuses
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
     * Returns an ability score modifier according to the value
     * @param value The ability score value
     * @return An integer that represents the modifier score
     */
    public int getModifier(int value){
        //TODO: Figure out a better logic
        if (value == 1){
            return -5;
        } else if( value == 2 || value == 3){
            return -4;
        } else if( value == 4 || value == 5) {
            return -3;
        } else if( value == 6 || value == 7){
            return -2;
        } else if( value == 8 || value == 9){
            return -1;
        } else if( value == 10 || value == 11){
            return 0;
        } else if( value == 12 || value == 13){
            return 1;
        } else if( value == 14 || value == 15){
            return 2;
        } else if( value == 16 || value == 17){
            return 3;
        } else if( value == 18 || value == 19){
            return 4;
        } else if( value == 20 || value == 21){
            return 5;
        } else if( value == 22 || value == 23){
            return 6;
        } else if( value == 24 || value == 25){
            return 7;
        } else if( value == 26 || value == 27){
            return 8;
        } else if( value == 28 || value == 29){
            return 9;
        } else return 10;
    }

    public Character applyRace(Character character, Race race){
        character.setSpeed(race.getSpeed());
        character.setStrength(character.getStrength() + race.getAbilityIncrease().get(0));

        return character;
    }




}
