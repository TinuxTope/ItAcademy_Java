package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.services;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.exceptions.PlayerAlreadyExistsException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.exceptions.PlayerNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository.MongoPlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoPlayerService {
    @Autowired
    private MongoPlayerRepository mongoPlayerRepository;

    public Player savePlayer(PlayerDTO playerDTO) {
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
    }

    public Player findPlayerByEmail(String email) {
        return mongoPlayerRepository.findByEmail(email)
                .orElseThrow(() -> new PlayerNotFoundException(email));
    }

    public Player findPlayerById(int id) {
        return mongoPlayerRepository.findById(id)
                .orElseThrow(() -> new PlayerNotFoundException("ID: " + id));
    }

    public List<Player> getAllPlayers() {
        return mongoPlayerRepository.findAll();
    }

    public void updatePlayerStats(int playerId, boolean won) {
        Player player = mongoPlayerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException("ID: " + playerId));
        player.setTotalRolls(player.getTotalRolls() + 1);
        if (won) {
            player.setWonRolls(player.getWonRolls() + 1);
        }
        mongoPlayerRepository.save(player);
    }
}
