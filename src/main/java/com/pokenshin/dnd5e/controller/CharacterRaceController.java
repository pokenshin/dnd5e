package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.character.CharacterRace;
import com.pokenshin.dnd5e.dao.CharacterRaceDao;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;

@RestController
public class CharacterRaceController {
    public CharacterRaceDao dao;

    //TODO: Transform this into a generate(int index)
    @RequestMapping("/race/{id}")
    public Optional<CharacterRace> get(@PathVariable("id") int id){
        return dao.get(id);
    }

    @RequestMapping("/race/getElf")
    public Optional<CharacterRace> getElf(){
        return dao.get(1);
    }

    public CharacterRaceDao getDao() {
        return dao;
    }

    public void setDao(CharacterRaceDao dao) {
        this.dao = dao;
    }

    public CharacterRaceController(CharacterRaceDao dao) {
        this.dao = dao;
    }

    public CharacterRaceController(){
        this.dao = new CharacterRaceDao();
    }
}