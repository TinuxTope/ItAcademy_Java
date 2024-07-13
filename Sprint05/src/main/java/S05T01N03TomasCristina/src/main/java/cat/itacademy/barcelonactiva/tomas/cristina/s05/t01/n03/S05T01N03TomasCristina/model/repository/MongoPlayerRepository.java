package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface MongoPlayerRepository extends MongoRepository<Player, Integer> {
    boolean existsByEmail(String email);
    Optional<Player> findByEmail(String email);
}
