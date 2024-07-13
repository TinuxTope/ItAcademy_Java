package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.infrastructure.mongo.MongoPlayerService;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.utils.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    private MongoPlayerService playerService;

    @PostMapping
    public ResponseEntity<PlayerDTO> createPlayer(@RequestBody PlayerDTO playerDTO, @RequestParam boolean useMongo) {
        Player player = playerService.savePlayer(playerDTO);
        return ResponseEntity.ok(DTOUtils.toPlayerDTO(player));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable int id, @RequestBody PlayerDTO playerDTO, @RequestParam boolean useMongo) {
        Player updatedPlayer = playerService.updatePlayer(id, playerDTO);
        return ResponseEntity.ok(DTOUtils.toPlayerDTO(updatedPlayer));
    }

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAllPlayers(@RequestParam boolean useMongo) {
        List<Player> players = playerService.getAllPlayers();
        List<PlayerDTO> responseDTOs = players.stream().map(DTOUtils::toPlayerDTO).collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable int id, @RequestParam boolean useMongo) {
        Player player = playerService.findPlayerById(id);
        return ResponseEntity.ok(DTOUtils.toPlayerDTO(player));
    }

    @GetMapping("/ranking")
    public ResponseEntity<Double> getRanking(@RequestParam boolean useMongo) {
        List<Player> players = playerService.getAllPlayers();
        double averageSuccessRate = players.stream().mapToDouble(Player::getSuccessRate).average().orElse(0.0);
        return ResponseEntity.ok(averageSuccessRate);
    }

    @GetMapping("/ranking/loser")
    public ResponseEntity<PlayerDTO> getLoser(@RequestParam boolean useMongo) {
        Player loser = playerService.getLoser();
        return (loser != null) ? ResponseEntity.ok(DTOUtils.toPlayerDTO(loser)) : ResponseEntity.notFound().build();
    }

    @GetMapping("/ranking/winner")
    public ResponseEntity<PlayerDTO> getWinner(@RequestParam boolean useMongo) {
        Player winner = playerService.getWinner();
        return (winner != null) ? ResponseEntity.ok(DTOUtils.toPlayerDTO(winner)) : ResponseEntity.notFound().build();
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logout() {
        // Implementa la lógica de logout, como invalidar el token JWT
        return ResponseEntity.ok("Logout successful");
    }
}
