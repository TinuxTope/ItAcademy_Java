package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.PlayerMongo;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PlayerMongoRepository extends MongoRepository<PlayerMongo, String> {
    Optional<PlayerMongo> findByName(String name);
    Optional<PlayerMongo> findByDni(String dni);
    Optional<PlayerMongo> findByEmail(String email);
}
