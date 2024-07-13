package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.infrastructure.mongo;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.repository.mongo.MongoPlayerRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.utils.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MongoPlayerService {
    @Autowired
    private MongoPlayerRepository playerRepository;

    public Player savePlayer(PlayerDTO playerDTO) {
        Player player = DTOUtils.toPlayerEntity(playerDTO);
        return playerRepository.save(player);
    }

    public Player updatePlayer(int id, PlayerDTO playerDTO) {
        Player existingPlayer = findPlayerById(id);
        existingPlayer.setName(playerDTO.getName());
        existingPlayer.setEmail(playerDTO.getEmail());
        existingPlayer.setPassword(playerDTO.getPassword());
        return playerRepository.save(existingPlayer);
    }

    public Player findPlayerById(int id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Player getLoser() {
        return playerRepository.findAll().stream()
                .min((p1, p2) -> Double.compare(p1.getSuccessRate(), p2.getSuccessRate()))
                .orElse(null);
    }

    public Player getWinner() {
        return playerRepository.findAll().stream()
                .max((p1, p2) -> Double.compare(p1.getSuccessRate(), p2.getSuccessRate()))
                .orElse(null);
    }

    public void updatePlayerStats(int playerId, boolean won) {
        Player player = findPlayerById(playerId);
        player.setTotalRolls(player.getTotalRolls() + 1);
        if (won) {
            player.setWonRolls(player.getWonRolls() + 1);
        }
        player.setSuccessRate((double) player.getWonRolls() / player.getTotalRolls() * 100);
        playerRepository.save(player);
    }
}
