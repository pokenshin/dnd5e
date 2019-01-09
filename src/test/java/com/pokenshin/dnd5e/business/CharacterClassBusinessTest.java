package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterClass;
import com.pokenshin.dnd5e.entity.CharacterCurrency;
import com.pokenshin.dnd5e.entity.Item;
import com.pokenshin.dnd5e.entity.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterClassBusinessTest {
    CharacterClassBusiness business;
    @BeforeEach
    void setUp() {
        business = new CharacterClassBusiness();
    }

    @Test
    void getStartingMoney(){
        CharacterClass fighter = new CharacterClass();
        fighter.setName("Fighter");
        CharacterCurrency result = business.getStartingMoney(fighter);
        assertTrue(result.getGold() > 0);
    }

}