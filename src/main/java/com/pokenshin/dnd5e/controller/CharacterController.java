package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.character.CharacterCalculator;
import com.pokenshin.dnd5e.character.CharacterRace;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class CharacterController {

    private CharacterCalculator calculator;
    @RequestMapping("/race")
    public CharacterRace generateRace(){
        return new CharacterRace() ;
    }

    @RequestMapping("/race/human")
    public CharacterRace generateHuman(){
        return new CharacterRace() ;
    }
}
