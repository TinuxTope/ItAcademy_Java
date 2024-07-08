package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping
    public ResponseEntity<Player> createPlayer(@RequestBody String name, @RequestBody String dni, @RequestBody String email) {
        Player player = playerService.createPlayer(name, dni, email);
        return ResponseEntity.ok(player);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @RequestBody String name) {
        Player player = playerService.updatePlayer(id, name);
        return ResponseEntity.ok(player);
    }

    @DeleteMapping("/{id}/games")
    public ResponseEntity<Void> deletePlayerGames(@PathVariable Long id) {
        playerService.deletePlayerGames(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<Player>> getAllPlayers() {
        List<Player> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }
}
