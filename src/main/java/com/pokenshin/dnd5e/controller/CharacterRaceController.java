package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.character.CharacterRace;
import com.pokenshin.dnd5e.dao.CharacterRaceDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CharacterRaceController {
    private CharacterRaceDao dao;

    @RequestMapping("/race/{id}")
    CharacterRace get(@PathVariable("id") int id){
        dao = new CharacterRaceDao();
        return dao.get(id);
    }

    public CharacterRaceDao getDao() {
        return dao;
    }

    public void setDao(CharacterRaceDao dao) {
        this.dao = dao;
    }

    CharacterRaceController(CharacterRaceDao dao) {
        this.dao = dao;
    }

    public CharacterRaceController(){
        this.dao = new CharacterRaceDao();
    }
}