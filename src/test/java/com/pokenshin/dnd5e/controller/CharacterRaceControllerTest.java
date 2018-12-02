package com.pokenshin.dnd5e.controller;

import com.pokenshin.dnd5e.business.CharacterBusiness;
import com.pokenshin.dnd5e.entity.Race;
import com.pokenshin.dnd5e.dao.CharacterRaceDao;
import com.pokenshin.dnd5e.util.JsonMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.junit.Rule;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CharacterRaceControllerTest {
    //Mocks
    @Mock
    private CharacterRaceDao dao = new CharacterRaceDao();
    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();
    private Map<Integer, Race> raceList;

    private CharacterRaceController controller;

    private CharacterBusiness calculator;
    @BeforeEach
    void setUp() throws IOException {
        createRaceList();
        prepareMock();
        controller = new CharacterRaceController(dao);
    }

    private void prepareMock() {
//        MockitoAnnotations.initMocks(this);
//        Mockito.when(dao.getAll()).thenReturn(this.raceList);
//        Mockito.when(dao.get(0)).thenReturn(this.raceList.get(0));
    }

    private void createRaceList(){
        JsonMapper mapper = new JsonMapper();
        raceList = mapper.getAllRaces();
    }

    @Test
    void generateHuman() {
        Race result = controller.get(1);
        assertEquals(1, result.getId());
        assertEquals("Human", result.getName());
    }
}