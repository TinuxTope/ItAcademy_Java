package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.services;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Roll;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository.MongoRollRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository.RollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.Optional;

@Service
public class UnifiedRollService {
    @Autowired
    private RollRepository rollRepository;

    @Autowired
    private MongoRollRepository mongoRollRepository;

    @Autowired
    private UnifiedPlayerService playerService;

    private final Random random = new Random();

    public Roll saveRoll(int playerId, boolean useMongo) {
        int dice1 = random.nextInt(6) + 1;
        int dice2 = random.nextInt(6) + 1;
        boolean won = (dice1 + dice2) == 7;

        Roll roll = new Roll();
        roll.setDice1(dice1);
        roll.setDice2(dice2);
        roll.setWon(won);
        roll.setPlayer(playerService.findPlayerById(playerId, useMongo)); // Asigna el jugador correspondiente

        if (useMongo) {
            roll = mongoRollRepository.save(roll);
        } else {
            roll = rollRepository.save(roll);
        }

        playerService.updatePlayerStats(playerId, won, useMongo);

        return roll;
    }

    public List<Roll> getRollsByPlayerId(int playerId, boolean useMongo) {
        if (useMongo) {
            return mongoRollRepository.findByPlayerId(playerId);
        } else {
            return rollRepository.findByPlayerId(playerId);
        }
    }

    public void deleteRollsByPlayerId(int playerId, boolean useMongo) {
        if (useMongo) {
            mongoRollRepository.deleteByPlayerId(playerId);
        } else {
            rollRepository.deleteByPlayerId(playerId);
        }
    }

    public Roll getRollById(int playerId, int id, boolean useMongo) {
        Optional<Roll> rollOptional;
        if (useMongo) {
            rollOptional = mongoRollRepository.findByIdAndPlayerId(id, playerId);
        } else {
            rollOptional = rollRepository.findByIdAndPlayerId(id, playerId);
        }
        return rollOptional.orElseThrow(() -> new RuntimeException("Roll ID: " + id + " not found for Player ID: " + playerId));
    }
}
