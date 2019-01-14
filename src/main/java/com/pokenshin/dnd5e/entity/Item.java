package com.pokenshin.dnd5e.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Item {
    private int id;
    private String name;
    private String category;
    private CharacterCurrency cost;
    private int weight;
    private int quantity;

    public Item() {
        this.id = 0;
        this.name = "";
        this.category = "";
        this.cost = new CharacterCurrency();
        this.weight = 0;
        this.quantity = 1;
    }

    public Item(int id, String name, String category, CharacterCurrency cost, int weight, int quantity) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.cost = cost;
        this.weight = weight;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public CharacterCurrency getCost() {
        return cost;
    }

    public void setCost(CharacterCurrency cost) {
        this.cost = cost;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
