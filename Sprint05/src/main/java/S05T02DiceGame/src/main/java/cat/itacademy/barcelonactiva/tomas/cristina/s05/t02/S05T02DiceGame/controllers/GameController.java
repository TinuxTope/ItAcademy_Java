package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Game;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.service.GameService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/players/{id}/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @Operation(summary = "Player plays a game")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Game played successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Game.class)) }),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = @Content)
    })
    @PostMapping
    public ResponseEntity<Game> playGame(@PathVariable Long id) {
        Game game = gameService.playGame(id);
        return ResponseEntity.ok(game);
    }

    @Operation(summary = "Get all games of a player with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of games",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Game.class)) }),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = @Content)
    })
    @GetMapping
    public ResponseEntity<Page<Game>> getPlayerGames(@PathVariable Long id, Pageable pageable) {
        Page<Game> games = gameService.getGamesByPlayer(id, pageable);
        return ResponseEntity.ok(games);
    }
}
