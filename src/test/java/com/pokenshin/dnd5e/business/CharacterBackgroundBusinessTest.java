package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterBackground;
import com.pokenshin.dnd5e.entity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CharacterBackgroundBusinessTest {
    private CharacterBackgroundBusiness business;

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

    @Test
    void getBackgroundStartingItemsCharlatan() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Charlatan");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemCriminal() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Criminal");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemEntertainer() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Entertainer");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemFolkHero() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Folk Hero");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }
}