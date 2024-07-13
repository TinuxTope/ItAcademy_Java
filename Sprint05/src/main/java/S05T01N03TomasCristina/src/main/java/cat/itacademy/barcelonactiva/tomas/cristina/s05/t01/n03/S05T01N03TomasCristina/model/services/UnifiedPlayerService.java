package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.services;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.exceptions.PlayerAlreadyExistsException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository.MongoPlayerRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UnifiedPlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private MongoPlayerRepository mongoPlayerRepository;

    public Player savePlayer(PlayerDTO playerDTO, boolean useMongo) {
        if (useMongo) {
            if (mongoPlayerRepository.existsByEmail(playerDTO.getEmail())) {
                throw new PlayerAlreadyExistsException(playerDTO.getEmail());
            }
            Player player = new Player(
                    playerDTO.getId(),
                    playerDTO.getEmail(),
                    playerDTO.getName(),
                    playerDTO.getPassword(),
                    playerDTO.getTotalRolls(),
                    playerDTO.getWonRolls()
            );
            return mongoPlayerRepository.save(player);
        } else {
            if (playerRepository.existsByEmail(playerDTO.getEmail())) {
                throw new PlayerAlreadyExistsException(playerDTO.getEmail());
            }
            Player player = new Player(
                    playerDTO.getId(),
                    playerDTO.getEmail(),
                    playerDTO.getName(),
                    playerDTO.getPassword(),
                    playerDTO.getTotalRolls(),
                    playerDTO.getWonRolls()
            );
            return playerRepository.save(player);
        }
    }

    public Player findPlayerByEmail(String email, boolean useMongo) {
        if (useMongo) {
            return mongoPlayerRepository.findByEmail(email)
                    .orElseThrow(() -> new PlayerNotFoundException(email));
        } else {
            return playerRepository.findByEmail(email)
                    .orElseThrow(() -> new PlayerNotFoundException(email));
        }
    }

    public Player findPlayerById(int id, boolean useMongo) {
        if (useMongo) {
            return mongoPlayerRepository.findById(id)
                    .orElseThrow(() -> new PlayerNotFoundException("ID: " + id));
        } else {
            return playerRepository.findById(id)
                    .orElseThrow(() -> new PlayerNotFoundException("ID: " + id));
        }
    }

    public List<Player> getAllPlayers(boolean useMongo) {
        if (useMongo) {
            return mongoPlayerRepository.findAll();
        } else {
            return playerRepository.findAll();
        }
    }

    public void updatePlayerStats(int playerId, boolean won, boolean useMongo) {
        Player player;
        if (useMongo) {
            player = mongoPlayerRepository.findById(playerId)
                    .orElseThrow(() -> new PlayerNotFoundException("ID: " + playerId));
        } else {
            player = playerRepository.findById(playerId)
                    .orElseThrow(() -> new PlayerNotFoundException("ID: " + playerId));
        }
        player.setTotalRolls(player.getTotalRolls() + 1);
        if (won) {
            player.setWonRolls(player.getWonRolls() + 1);
        }
        if (useMongo) {
            mongoPlayerRepository.save(player);
        } else {
            playerRepository.save(player);
        }
    }
}
