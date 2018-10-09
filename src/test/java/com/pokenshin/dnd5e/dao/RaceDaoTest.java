package com.pokenshin.dnd5e.dao;

import com.pokenshin.dnd5e.character.CharacterRace;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Optional;

import static org.mockito.Mockito.*;

class RaceDaoTest {
    @Mock
    private RaceDao raceDao;
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    private void prepareMock(){
        ArrayList<CharacterRace> mockList = new ArrayList<>();
        Optional<CharacterRace> mockCharacterRace = Optional.ofNullable(new CharacterRace());
        when(raceDao.getAll()).thenReturn(mockList);
        when(raceDao.get(anyInt())).thenReturn(mockCharacterRace);
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