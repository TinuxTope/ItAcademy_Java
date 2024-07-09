package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.service;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Game;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.GameRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.PlayerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GameService {
    private final GameRepository gameRepository;
    private final PlayerRepository playerRepository;
    private final Random random = new Random();

    public GameService(GameRepository gameRepository, PlayerRepository playerRepository) {
        this.gameRepository = gameRepository;
        this.playerRepository = playerRepository;
    }

    public Game playGame(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));

        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        boolean win = (dice1 + dice2) == 7;

        Game game = new Game();
        game.setDice1(dice1);
        game.setDice2(dice2);
        game.setWin(win);
        game.setPlayer(player);

        return gameRepository.save(game);
    }

    public Page<Game> getGamesByPlayer(Long playerId, Pageable pageable) {
        if (!playerRepository.existsById(playerId)) {
            throw new PlayerNotFoundException("Player not found with id " + playerId);
        }
        return gameRepository.findByPlayerId(playerId, pageable);
    }
}
