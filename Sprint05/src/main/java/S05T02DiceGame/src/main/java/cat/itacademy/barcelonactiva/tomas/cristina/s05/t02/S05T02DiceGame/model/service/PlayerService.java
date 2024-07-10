package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.service;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.PlayerAlreadyExistsException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.InvalidPlayerDataException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.PlayerMongo;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.PlayerRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.PlayerMongoRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.validation.PlayerValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PlayerService {

@Autowired
    private final PlayerRepository playerRepository;
@Autowired
    private PlayerMongoRepository playerMongoRepository;
    private final PasswordEncoder passwordEncoder;


    @Autowired
    public PlayerService(PlayerRepository playerRepository, PlayerMongoRepository playerMongoRepository, PasswordEncoder passwordEncoder) {
        this.playerRepository = playerRepository;
        this.playerMongoRepository = playerMongoRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Player createPlayer(String name, String email, String password) {
        if (playerRepository.existsByName(name)) {
            throw new PlayerAlreadyExistsException("Player with name " + name + " already exists");
        }
        if (playerRepository.findByEmail(email).isPresent()) {
            throw new PlayerAlreadyExistsException("Player with email " + email + " already exists");
        }
        if (playerMongoRepository.findByEmail(email).isPresent()) {
            throw new PlayerAlreadyExistsException("Player with email " + email + " already exists in MongoDB");
        }
        Player player = new Player();
        player.setName(name != null ? name : "ANÒNIM");
        player.setEmail(email);
        player.setPassword(passwordEncoder.encode(password));
        player.setRegisterDate(new Date());

        if (!PlayerValidator.isValidPlayer(player)) {
            throw new InvalidPlayerDataException("Invalid player data");
        }

        playerRepository.save(player);

        PlayerMongo playerMongo = new PlayerMongo();
        playerMongo.setName(player.getName());
        playerMongo.setEmail(player.getEmail());
        playerMongo.setPassword(player.getPassword());
        playerMongo.setRegisterDate(player.getRegisterDate());
        playerMongoRepository.save(playerMongo);

        return player;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Player updatePlayer(Long id, String name) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + id));
        player.setName(name);
        playerRepository.save(player);

        PlayerMongo playerMongo = playerMongoRepository.findByEmail(player.getEmail())
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with email " + player.getEmail()));
        playerMongo.setName(name);
        playerMongoRepository.save(playerMongo);

        return player;
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deletePlayerGames(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));
        player.getGames().clear();
        playerRepository.save(player);
        PlayerMongo playerMongo = playerMongoRepository.findByEmail(player.getEmail())
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with email " + player.getEmail()));
        playerMongo.getGames().clear();
        playerMongoRepository.save(playerMongo);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Page<Player> getAllPlayers(Pageable pageable) {
        return playerRepository.findAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));
    }
}
