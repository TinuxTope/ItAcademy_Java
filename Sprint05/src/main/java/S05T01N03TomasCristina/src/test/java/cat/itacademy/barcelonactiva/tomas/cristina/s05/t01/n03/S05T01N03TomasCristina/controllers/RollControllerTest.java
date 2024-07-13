package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.controllers;


import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.dto.RollDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.infrastructure.unified.UnifiedRollService;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.utils.DTOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(RollControllerTest.class)
public class RollControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UnifiedRollService rollService;

    @Autowired
    private ObjectMapper objectMapper;

    private RollDTO rollDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        rollDTO = new RollDTO(1, 3, 4, true, 1);
    }

    @Test
    void performRoll() throws Exception {
        when(rollService.saveRoll(anyInt(), anyBoolean())).thenReturn(DTOUtils.toRollEntity(rollDTO));

        mockMvc.perform(post("/players/{playerId}/games", rollDTO.getPlayerId())
                        .param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(rollDTO.getId()))
                .andExpect(jsonPath("$.dice1").value(rollDTO.getDice1()))
                .andExpect(jsonPath("$.dice2").value(rollDTO.getDice2()))
                .andExpect(jsonPath("$.won").value(rollDTO.isWon()))
                .andExpect(jsonPath("$.playerId").value(rollDTO.getPlayerId()));
    }

    @Test
    void getPlayerRolls() throws Exception {
        List<RollDTO> rollList = Arrays.asList(rollDTO);
        when(rollService.getRollsByPlayerId(anyInt(), anyBoolean())).thenReturn(rollList.stream().map(DTOUtils::toRollEntity).toList());

        mockMvc.perform(get("/players/{playerId}/games", rollDTO.getPlayerId()).param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(rollDTO.getId()))
                .andExpect(jsonPath("$[0].dice1").value(rollDTO.getDice1()))
                .andExpect(jsonPath("$[0].dice2").value(rollDTO.getDice2()))
                .andExpect(jsonPath("$[0].won").value(rollDTO.isWon()))
                .andExpect(jsonPath("$[0].playerId").value(rollDTO.getPlayerId()));
    }

    @Test
    void deletePlayerRolls() throws Exception {
        mockMvc.perform(delete("/players/{playerId}/games", rollDTO.getPlayerId()).param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(content().string("Rolls deleted successfully"));
    }

    @Test
    void getRollById() throws Exception {
        when(rollService.getRollById(anyInt(), anyInt(), anyBoolean())).thenReturn(DTOUtils.toRollEntity(rollDTO));

        mockMvc.perform(get("/players/{playerId}/games/{id}", rollDTO.getPlayerId(), rollDTO.getId()).param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(rollDTO.getId()))
                .andExpect(jsonPath("$.dice1").value(rollDTO.getDice1()))
                .andExpect(jsonPath("$.dice2").value(rollDTO.getDice2()))
                .andExpect(jsonPath("$.won").value(rollDTO.isWon()))
                .andExpect(jsonPath("$.playerId").value(rollDTO.getPlayerId()));
    }
}
