package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.PlayerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerMongoRepository extends MongoRepository<PlayerMongo, String> {
    boolean existsByEmail(String email);
    Optional<PlayerMongo> findByEmail(String email);
}
