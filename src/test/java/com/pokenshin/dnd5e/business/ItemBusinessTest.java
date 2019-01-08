package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ItemBusinessTest {
    ItemBusiness business;

    @BeforeEach
    void setUp() {
        business = new ItemBusiness();
    }

    @Test
    void getExplorerPack(){
        ArrayList<Item> result = business.getItemPack("Explorer");
        assertTrue(result.size() > 0);
    }

    @Test
    void getDiplomatPack(){
        ArrayList<Item> result = business.getItemPack("Diplomat");
        assertTrue(result.size() > 0);
    }

    @Test
    void getEntertainerPack(){
        ArrayList<Item> result = business.getItemPack("Entertainer");
        assertTrue(result.size() > 0);
    }
}