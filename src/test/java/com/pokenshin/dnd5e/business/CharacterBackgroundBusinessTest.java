package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterBackground;
import com.pokenshin.dnd5e.entity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterBackgroundBusinessTest {
    CharacterBackgroundBusiness business;

    @BeforeEach
    void setUp() {
        business = new CharacterBackgroundBusiness();
    }

    @Test
    void getBackgroundStartingItemsAcolyte() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Acolyte");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}