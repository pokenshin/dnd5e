package com.pokenshin.dnd5e.business;

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
}