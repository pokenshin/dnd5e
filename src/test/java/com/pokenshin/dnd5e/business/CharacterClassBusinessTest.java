package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterClass;
import com.pokenshin.dnd5e.entity.CharacterCurrency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CharacterClassBusinessTest {
    private CharacterClassBusiness business;
    @BeforeEach
    void setUp() {
        business = new CharacterClassBusiness();
    }

    @Test
    void getStartingMoneyFighter(){
        CharacterClass fighter = new CharacterClass();
        fighter.setName("Fighter");
        CharacterCurrency result = business.getStartingMoney(fighter);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 200);
    }

    @Test
    void getStartingMoneyBarbarian(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Barbarian");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 80);
    }

    @Test
    void getStartingMoneyBard(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Bard");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 200);
    }

    @Test
    void getStartingMoneyCleric(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Cleric");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 200);
    }

    @Test
    void getStartingMoneyDruid(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Druid");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 80);
    }

    @Test
    void getStartingMoneyMonk(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Monk");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 20);
    }

    @Test
    void getStartingMoneyPaladin(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Paladin");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 200);
    }

    @Test
    void getStartingMoneyRanger(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Ranger");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 200);
    }

    @Test
    void getStartingMoneyRogue(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Rogue");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 160);
    }

    @Test
    void getStartingMoneySorcerer(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Sorcerer");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 120);
    }

    @Test
    void getStartingMoneyWarlock(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Warlock");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 160);
    }

    @Test
    void getStartingMoneyWizard(){
        CharacterClass characterClass = new CharacterClass();
        characterClass.setName("Wizard");
        CharacterCurrency result = business.getStartingMoney(characterClass);
        assertTrue(result.getGold() > 0);
        assertTrue(result.getGold() < 160);
    }


}