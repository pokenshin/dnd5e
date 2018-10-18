package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.character.CharacterCalculator;
import com.pokenshin.dnd5e.character.CharacterRace;
import com.pokenshin.dnd5e.dao.CharacterRaceDao;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class CharacterControllerTest {
    //Mocks
    @Mock
    private CharacterRaceDao dao = new CharacterRaceDao();
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private ArrayList<CharacterRace> raceList;

    private CharacterRaceController controller;

    private CharacterCalculator calculator;
    @BeforeEach
    void setUp() {
        createRaceList();
        prepareMock();
        controller = new CharacterRaceController(dao);
    }

    private void prepareMock() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(dao.getAll()).thenReturn(this.raceList);
        Mockito.when(dao.get(0)).thenReturn(this.raceList.get(0));
    }

    private void createRaceList() {
        JsonMapper mapper = new JsonMapper();
        raceList = new ArrayList<>();
        raceList.add(mapper.getRace("races/human.json"));
    }

    @Test
    void generateHuman() {
        CharacterRace result = controller.get(1);
        assertEquals(1, result.getId());
        assertEquals("Human", result.getName());
    }
}