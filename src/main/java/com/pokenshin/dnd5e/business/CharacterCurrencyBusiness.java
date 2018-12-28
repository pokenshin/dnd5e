package com.pokenshin.dnd5e.business;

import com.pokenshin.dnd5e.entity.CharacterCurrency;

public class CharacterCurrencyBusiness {
    public CharacterCurrencyBusiness() {
    }

    public CharacterCurrency addMoney(CharacterCurrency current, CharacterCurrency amount){
        current.setCopper(current.getCopper() + amount.getCopper());
        current.setSilver(current.getSilver() + amount.getSilver());
        current.setGold(current.getGold() + amount.getGold());
        current.setPlatinum(current.getPlatinum() + amount.getPlatinum());
        current.setElectrum(current.getElectrum() + amount.getElectrum());

        return current;
    }

    public CharacterCurrency subtractAmount(CharacterCurrency current, CharacterCurrency amount){
        current.setCopper(current.getCopper() - amount.getCopper());
        current.setSilver(current.getSilver() - amount.getSilver());
        current.setGold(current.getGold() - amount.getGold());
        current.setPlatinum(current.getPlatinum() - amount.getPlatinum());
        current.setElectrum(current.getElectrum() - amount.getElectrum());

        return current;
    }
}
