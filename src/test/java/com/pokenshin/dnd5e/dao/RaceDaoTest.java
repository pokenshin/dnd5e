package com.pokenshin.dnd5e.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pokenshin.dnd5e.character.CharacterRace;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

class RaceDaoTest {
    //TODO: Maybe move Mocks to RaceDao
    @Mock
    private RaceDao raceDao;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private ArrayList<CharacterRace> raceList;

    @Before
    private void prepareTests(){
        this.raceDao = new RaceDao();
        createRaceList();
        prepareMock();
    }

    private void prepareMock(){
        when(raceDao.getAll()).thenReturn(this.raceList);
        when(raceDao.get(1)).thenReturn(Optional.ofNullable(this.raceList.get(0)));
    }

    private void createRaceList(){
        JsonMapper mapper = new JsonMapper();
        ArrayList<CharacterRace> raceList = new ArrayList<>();
        raceList.add(mapper.getRace("races/human.json"));
    }

    @Test
    void get() {

    }

    @Test
    void getAll() {
    }

    @Test
    void insert() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
}