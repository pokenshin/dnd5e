package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterAbility;
import com.pokenshin.dnd5e.entity.Character;

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
        CharacterAbility defaultAbility = new CharacterAbility(12, 1);
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

        return result;
    }




}
