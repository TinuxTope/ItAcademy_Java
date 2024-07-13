package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.services;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Roll;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository.MongoRollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class MongoRollService {
    @Autowired
    private MongoRollRepository mongoRollRepository;

    @Autowired
    private MongoPlayerService playerService;

    private final Random random = new Random();

    public Roll saveRoll(int playerId) {
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        boolean won = (dice1 + dice2) == 7;

        Roll roll = new Roll();
        roll.setDice1(dice1);
        roll.setDice2(dice2);
        roll.setWon(won);
        roll.setPlayer(playerService.findPlayerById(playerId)); // Asigna el jugador correspondiente

        roll = mongoRollRepository.save(roll);

        playerService.updatePlayerStats(playerId, won);

        return roll;
    }

    public List<Roll> getRollsByPlayerId(int playerId) {
        return mongoRollRepository.findByPlayerId(playerId);
    }

    public void deleteRollsByPlayerId(int playerId) {
        mongoRollRepository.deleteByPlayerId(playerId);
    }

    public Roll getRollById(int playerId, int id) {
        return mongoRollRepository.findByIdAndPlayerId(id, playerId)
                .orElseThrow(() -> new RuntimeException("Roll ID: " + id + " not found for Player ID: " + playerId));
    }
}
