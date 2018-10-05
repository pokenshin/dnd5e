package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.character.CharacterCalculator;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pokenshin.dnd5e.character.Character;

@RestController
public class CharacterController {

    private CharacterCalculator calculator;
    @RequestMapping("/")
    public String index(){
        return "Test successful!!!";
    }

    @RequestMapping("/character")
    public Character generateCharacter(){
        return calculator.generateRandomCharacter();
    }
}
