package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.GameMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface GameMongoRepository  extends MongoRepository<GameMongo, String> {
    List<GameMongo> findByPlayerId(String playerId);
}
