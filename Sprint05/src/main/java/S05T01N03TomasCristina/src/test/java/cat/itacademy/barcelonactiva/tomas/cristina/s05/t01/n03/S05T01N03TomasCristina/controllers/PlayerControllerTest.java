package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.controllers.PlayerController;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.infrastructure.unified.UnifiedPlayerService;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.utils.DTOUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ActiveProfiles("test")
@WebMvcTest(PlayerController.class)
public class PlayerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UnifiedPlayerService playerService;

    @Autowired
    private ObjectMapper objectMapper;

    private PlayerDTO playerDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        playerDTO = new PlayerDTO(1, "test@example.com", "Test Player", "password", 10, 5, 50.0);
    }

    @Test
    void createPlayer() throws Exception {
        when(playerService.savePlayer(any(PlayerDTO.class), anyBoolean())).thenReturn(DTOUtils.toPlayerEntity(playerDTO));

        mockMvc.perform(post("/players")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(playerDTO))
                        .param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(playerDTO.getId()))
                .andExpect(jsonPath("$.email").value(playerDTO.getEmail()))
                .andExpect(jsonPath("$.name").value(playerDTO.getName()));
    }

    @Test
    void updatePlayer() throws Exception {
        when(playerService.findPlayerById(anyInt(), anyBoolean())).thenReturn(DTOUtils.toPlayerEntity(playerDTO));
        when(playerService.savePlayer(any(PlayerDTO.class), anyBoolean())).thenReturn(DTOUtils.toPlayerEntity(playerDTO));

        mockMvc.perform(put("/players/{id}", playerDTO.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(playerDTO))
                        .param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(playerDTO.getId()))
                .andExpect(jsonPath("$.email").value(playerDTO.getEmail()))
                .andExpect(jsonPath("$.name").value(playerDTO.getName()));
    }

    @Test
    void getAllPlayers() throws Exception {
        List<PlayerDTO> playerList = Arrays.asList(playerDTO);
        when(playerService.getAllPlayers(anyBoolean())).thenReturn(playerList.stream().map(DTOUtils::toPlayerEntity).toList());

        mockMvc.perform(get("/players").param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(playerDTO.getId()))
                .andExpect(jsonPath("$[0].email").value(playerDTO.getEmail()))
                .andExpect(jsonPath("$[0].name").value(playerDTO.getName()));
    }

    @Test
    void getPlayerById() throws Exception {
        when(playerService.findPlayerById(anyInt(), anyBoolean())).thenReturn(DTOUtils.toPlayerEntity(playerDTO));

        mockMvc.perform(get("/players/{id}", playerDTO.getId()).param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(playerDTO.getId()))
                .andExpect(jsonPath("$.email").value(playerDTO.getEmail()))
                .andExpect(jsonPath("$.name").value(playerDTO.getName()));
    }

    @Test
    void getRanking() throws Exception {
        List<PlayerDTO> playerList = Arrays.asList(playerDTO);
        when(playerService.getAllPlayers(anyBoolean())).thenReturn(playerList.stream().map(DTOUtils::toPlayerEntity).toList());

        mockMvc.perform(get("/players/ranking").param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(50.0));
    }

    @Test
    void getLoser() throws Exception {
        when(playerService.getAllPlayers(anyBoolean())).thenReturn(List.of(DTOUtils.toPlayerEntity(playerDTO)));

        mockMvc.perform(get("/players/ranking/loser").param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(playerDTO.getId()))
                .andExpect(jsonPath("$.email").value(playerDTO.getEmail()))
                .andExpect(jsonPath("$.name").value(playerDTO.getName()));
    }

    @Test
    void getWinner() throws Exception {
        when(playerService.getAllPlayers(anyBoolean())).thenReturn(List.of(DTOUtils.toPlayerEntity(playerDTO)));

        mockMvc.perform(get("/players/ranking/winner").param("useMongo", "false"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(playerDTO.getId()))
                .andExpect(jsonPath("$.email").value(playerDTO.getEmail()))
                .andExpect(jsonPath("$.name").value(playerDTO.getName()));
    }

    @Test
    void logout() throws Exception {
        mockMvc.perform(post("/players/logout"))
                .andExpect(status().isOk())
                .andExpect(content().string("Logout successful"));
    }
}
