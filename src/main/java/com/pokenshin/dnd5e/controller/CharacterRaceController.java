package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.dao.CharacterRaceDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CharacterRaceController {
    private CharacterRaceDao dao;

    @RequestMapping("/race/{id}")
    Race get(@PathVariable("id") int id){
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