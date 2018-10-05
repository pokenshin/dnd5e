package com.pokenshin.dnd5e.character.races;

import java.util.ArrayList;
import java.util.List;

public class Human extends CharacterRace {

    public Human(){
        this.setId(1);
        this.setAbilityIncrease(new ArrayList<Integer>());
        while (this.getAbilityIncrease().size() < 6){
            this.getAbilityIncrease().add(1);
        }
        this.setAgeMax(100);
        this.setAlignments(new ArrayList<>());
        this.getAlignments().add("Lawful Good");
        this.getAlignments().add("Neutral Good");
        this.getAlignments().add("Chaotic Good");
        this.getAlignments().add("Lawful Neutral");
        this.getAlignments().add("True Neutral");
        this.getAlignments().add("Chaotic Neutral");
        this.getAlignments().add("Lawful Evil");
        this.getAlignments().add("Neutral Evil");
        this.getAlignments().add("Chaotic Evil");
        this.setLanguages(new ArrayList());
        this.getLanguages().add("Common");
        this.getLanguages().add("Custom");
        this.setOtherTraits(new ArrayList<>());
        this.setSize("Medium");
        this.setSpeed(40);
    }

}
