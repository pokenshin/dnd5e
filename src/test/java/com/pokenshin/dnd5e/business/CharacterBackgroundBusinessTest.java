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

    @Test
    void getBackgroundStartingItemGuildArtisan() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Guild Artisan");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemGuildHermit() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Hermit");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemNoble() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Noble");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemOutlander() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Outlander");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemSage() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Sage");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemSailor() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Sailor");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemSoldier() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Soldier");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

    @Test
    void getBackgroundStartingItemUrchin() {
        CharacterBackground background = new CharacterBackground();
        background.setName("Urchin");
        ArrayList<Item> result = business.getBackgroundStartingItems(background);
        assertNotNull(result);
        assertTrue(result.size() > 0);
    }

}