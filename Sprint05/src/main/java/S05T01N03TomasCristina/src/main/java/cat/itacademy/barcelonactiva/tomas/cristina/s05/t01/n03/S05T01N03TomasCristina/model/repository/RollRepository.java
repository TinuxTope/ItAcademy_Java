package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Roll;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface RollRepository extends JpaRepository<Roll, Integer> {
    List<Roll> findByPlayerId(int playerId);
    void deleteByPlayerId(int playerId);
    Optional<Roll> findByIdAndPlayerId(int id, int playerId);
}
