package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.character.CharacterCalculator;
import com.pokenshin.dnd5e.character.CharacterRace;
import com.pokenshin.dnd5e.dao.CharacterRaceDao;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CharacterController {

    CharacterRaceDao dao = new CharacterRaceDao();

    @RequestMapping("/race/human")
    public CharacterRace generateHuman(){
        Optional<CharacterRace> result = dao.get(1);
        return result.get() ;
    }
}
