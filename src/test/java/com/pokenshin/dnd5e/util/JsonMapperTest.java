package com.pokenshin.dnd5e.util;

import com.pokenshin.dnd5e.entity.Race;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JsonMapperTest {
    @Test
    void getRace() {
        JsonMapper mapper = new JsonMapper();
        Race human = mapper.getRace("races/human.json");
        assertEquals(1, human.getId());
        assertEquals("Human", human.getName());
    }
}