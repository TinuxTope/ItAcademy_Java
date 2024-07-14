package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.repository.mongo;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model.Roll;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface MongoRollRepository  extends MongoRepository<Roll, Integer> {
    List<Roll> findByPlayerId(int playedId);
    void deleteByPlayerId(int playerId);
    Optional<Roll> findByIdAndPlayerId(int id, int playerId);
}
