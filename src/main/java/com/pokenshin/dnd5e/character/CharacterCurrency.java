package com.pokenshin.dnd5e.character;

public class CharacterCurrency {
    private int copper;
    private int silver;
    private int electrum;
    private int gold;
    private int platinum;

    public CharacterCurrency(int copper, int silver, int electrum, int gold, int platinum) {
        this.copper = copper;
        this.silver = silver;
        this.electrum = electrum;
        this.gold = gold;
        this.platinum = platinum;
    }

    public CharacterCurrency(){
        this.copper = 0;
        this.silver = 0;
        this.electrum = 0;
        this.gold = 0;
        this.platinum = 0;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getElectrum() {
        return electrum;
    }

    public void setElectrum(int electrum) {
        this.electrum = electrum;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPlatinum() {
        return platinum;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }
}
