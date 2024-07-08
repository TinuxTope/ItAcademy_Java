package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.controllers;


import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Game;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/players/{id}/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping
    public ResponseEntity<Game> playGame(@PathVariable Long id) {
        Game game = gameService.playGame(id);
        return ResponseEntity.ok(game);
    }

    @GetMapping
    public ResponseEntity<List<Game>> getPlayerGames(@PathVariable Long id) {
        List<Game> games = gameService.getGamesByPlayer(id);
        return ResponseEntity.ok(games);
    }
}