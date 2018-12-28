package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RandomizerTest {
    Randomizer randomizer;

    @BeforeEach
    void setUp() {
        randomizer = new Randomizer();
    }

    @Test
    void getRandomRace() {
        assertNotNull(randomizer.getRandomRace());
    }

    @Test
    void getRandomClass() {
        assertNotNull(randomizer.getRandomClass());
    }

    @Test
    void getRandomHeight(){
        JsonMapper mapper = new JsonMapper();
        Race elf =  mapper.getRace("elf.json");
        int height = randomizer.getRandomHeight(elf);
        assertTrue(height > 140);
        assertTrue(height < 161);
    }

    @Test
    void getRandomWeight(){
        JsonMapper mapper = new JsonMapper();
        Race elf =  mapper.getRace("elf.json");
        int weight = randomizer.getRandomWeight(elf);
        assertTrue(weight > 40);
        assertTrue(weight < 45);
    }

    @Test
    void getRandomBackground() {
        assertNotNull(randomizer.getRandomBackground());
    }

    @Test
    void getRandomListItemString(){
        JsonMapper mapper = new JsonMapper();
        List<String> bonds = mapper.getCharacterBackground("acolyte.json").getBonds();
        assertNotNull(randomizer.getRandomListItemString(bonds));
    }

    @Test
    void getRandomAlignment(){
        assertNotNull(randomizer.getRandomAlignment());
    }
}