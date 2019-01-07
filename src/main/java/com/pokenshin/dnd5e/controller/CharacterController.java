package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.business.CharacterBusiness;
import com.pokenshin.dnd5e.business.Randomizer;
import com.pokenshin.dnd5e.entity.Character;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterController {
    @RequestMapping("/character/random")
    public Character getRandom(){
        Randomizer randomizer = new Randomizer();
        return randomizer.getRandomCharacter(72);
    }
}
