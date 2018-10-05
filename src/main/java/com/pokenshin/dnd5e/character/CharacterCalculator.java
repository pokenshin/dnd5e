package com.pokenshin.dnd5e.character;

public class CharacterCalculator {
    public Character resetCharacter(Character character){
        //Set Level to 1
        character.setLevel(1);
        character.setExperience(0);

        //Set all ability scores to 12
        character = resetAbilityScores(character);


        return character;
    }

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

    public Character generateRandomCharacter(){
        Character result = new Character();

        return result;
    }




}
