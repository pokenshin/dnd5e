package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}