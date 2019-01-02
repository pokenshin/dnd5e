package com.pokenshin.dnd5e.entity;

public class Item {
    private int id;
    private String nome;
    private String category;
    private CharacterCurrency cost;
    private int weight;

    public Item() {
        this.id = 0;
        this.nome = "";
        this.category = "";
        this.cost = new CharacterCurrency();
        this.weight = 0;
    }

    public Item(int id, String nome, String category, CharacterCurrency cost, int weight) {
        this.id = id;
        this.nome = nome;
        this.category = category;
        this.cost = cost;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
}
