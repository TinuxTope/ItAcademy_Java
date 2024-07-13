package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Roll;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MongoRollRepository  extends MongoRepository<Roll, Integer> {
    List<Roll> findByPlayerId(int playedId);
    void deleteByPlayerId(int playerId);
    Optional<Roll> findByIdAndPlayerId(int id, int playerId);
}
