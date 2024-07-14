package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.repository.jpa;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model.Roll;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RollRepository extends JpaRepository<Roll, Integer> {
    List<Roll> findByPlayerId(int playerId);
    void deleteByPlayerId(int playerId);
    Optional<Roll> findByIdAndPlayerId(int id, int playerId);
}
