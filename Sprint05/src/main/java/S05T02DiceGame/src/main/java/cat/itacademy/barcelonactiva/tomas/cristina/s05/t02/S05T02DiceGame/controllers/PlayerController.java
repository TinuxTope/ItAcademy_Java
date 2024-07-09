package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.dto.RegisterRequest;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.dto.UpdatePlayerRequest;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.service.PlayerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Operation(summary = "Create a new player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player created successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Player.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content),
            @ApiResponse(responseCode = "409", description = "Player already exists",
                    content = @Content)
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody RegisterRequest registerRequest) {
        Player player = playerService.createPlayer(registerRequest.getUsername(), registerRequest.getEmail(), registerRequest.getPassword());
        return ResponseEntity.ok(player);
    }

    @Operation(summary = "Update a player's name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player updated successfully",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Player.class)) }),
            @ApiResponse(responseCode = "400", description = "Invalid input data",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = @Content)
    })
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Player> updatePlayer(@PathVariable Long id, @Valid @RequestBody UpdatePlayerRequest updateRequest) {
        Player player = playerService.updatePlayer(id, updateRequest.getName());
        return ResponseEntity.ok(player);
    }

    @Operation(summary = "Delete all games of a player")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "All games deleted successfully",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = @Content)
    })
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}/games")
    public ResponseEntity<Void> deletePlayerGames(@PathVariable Long id) {
        playerService.deletePlayerGames(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get all players with pagination")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "List of players",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Player.class)) })
    })
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping
    public ResponseEntity<Page<Player>> getAllPlayers(Pageable pageable) {
        Page<Player> players = playerService.getAllPlayers(pageable);
        return ResponseEntity.ok(players);
    }

    @Operation(summary = "Get player by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Player details",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = Player.class)) }),
            @ApiResponse(responseCode = "404", description = "Player not found",
                    content = @Content)
    })
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Player> getPlayerById(@PathVariable Long id) {
        Player player = playerService.getPlayerById(id);
        return ResponseEntity.ok(player);
    }
}
