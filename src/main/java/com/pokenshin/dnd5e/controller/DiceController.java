package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.business.DiceBusiness;
import com.pokenshin.dnd5e.entity.Dice;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DiceController {
    private Dice dice;
    private DiceBusiness diceBusiness;

    @RequestMapping("/dice/{diceType}")
    Dice get(@PathVariable("diceType") String diceType){
        if (diceType.contains("d")) {
            int sides = Integer.parseInt(diceType.split("d")[0]);
            int rolls = Integer.parseInt(diceType.split("d")[1]);
            this.dice = new Dice(sides, rolls);
            return this.dice;
        } else
            return new Dice();
    }

    @RequestMapping("/dice/roll/{diceType}")
    int getRoll(@PathVariable("diceType") String diceType){
        if (diceType.contains("d")) {
            int sides = Integer.parseInt(diceType.split("d")[0]);
            int rolls = Integer.parseInt(diceType.split("d")[1]);
            this.dice = new Dice(rolls, sides);
            this.diceBusiness = new DiceBusiness(this.dice);
            return this.diceBusiness.getRoll();
        } else
            return 0;
    }
}
