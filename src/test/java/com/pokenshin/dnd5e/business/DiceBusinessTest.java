package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.Dice;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceBusinessTest {
    DiceBusiness diceBusiness;
    Dice dice;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getRoll() {
        dice = new Dice(6, 2);
        diceBusiness = new DiceBusiness(dice);
        int result = diceBusiness.getRoll();
        assertTrue(result >= 2);
        assertTrue(result <= 12);
    }

    @Test
    void getRollZero(){
        diceBusiness = new DiceBusiness(null);
        assertTrue(diceBusiness.getRoll() == 0);
    }
}