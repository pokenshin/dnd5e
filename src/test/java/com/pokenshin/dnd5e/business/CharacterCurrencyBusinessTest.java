package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterCurrency;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterCurrencyBusinessTest {
    CharacterCurrencyBusiness business;

    @BeforeEach
    void setUp() {
         business = new CharacterCurrencyBusiness();
    }

    @Test
    void addMoney() {
        CharacterCurrency current = new CharacterCurrency(10,10,10,10, 10);
        CharacterCurrency addAmount = new CharacterCurrency(20, 20, 20, 20, 20);
        CharacterCurrency finalAmount = business.addMoney(current, addAmount);

        assertEquals(30, finalAmount.getCopper());
        assertEquals(30, finalAmount.getSilver());
        assertEquals(30, finalAmount.getGold());
        assertEquals(30, finalAmount.getPlatinum());
        assertEquals(30, finalAmount.getElectrum());
    }

    @Test
    void subtractMoney() {
        CharacterCurrency subtractAmount = new CharacterCurrency(10,10,10,10, 10);
        CharacterCurrency current = new CharacterCurrency(20, 20, 20, 20, 20);
        CharacterCurrency finalAmount = business.subtractAmount(current, subtractAmount);

        assertEquals(10, finalAmount.getCopper());
        assertEquals(10, finalAmount.getSilver());
        assertEquals(10, finalAmount.getGold());
        assertEquals(10, finalAmount.getPlatinum());
        assertEquals(10, finalAmount.getElectrum());
    }
}