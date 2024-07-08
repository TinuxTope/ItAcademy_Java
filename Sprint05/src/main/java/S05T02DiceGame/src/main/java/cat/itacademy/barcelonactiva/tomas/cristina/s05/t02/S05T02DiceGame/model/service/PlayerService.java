package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.service;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.PlayerAlreadyExistException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    public Player createPlayer(String name, String dni, String email) {
        if (playerRepository.existsByName(name)) {
            throw new PlayerAlreadyExistException("Player with name " + name + " already exists");
        }
        if (playerRepository.findByDni(dni).isPresent()) {
            throw new PlayerAlreadyExistException("Player with DNI " + dni + " already exists");
        }
        if (playerRepository.findByEmail(email).isPresent()) {
            throw new PlayerAlreadyExistException("Player with email " + email + " already exists");
        }
        Player player = new Player();
        player.setName(name != null ? name : "ANÒNIM");
        player.setDni(dni);
        player.setEmail(email);
        player.setRegisterDate(new Date());
        return playerRepository.save(player);
    }

    public Player updatePlayer(Long id, String name) {
        Player player = playerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + id));
        player.setName(name);
        return playerRepository.save(player);
    }

    public void deletePlayerGames(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));
        player.getGames().clear();
        playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getPlayerById(Long playerId) {
        return playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("Player not found with id " + playerId));
    }
}