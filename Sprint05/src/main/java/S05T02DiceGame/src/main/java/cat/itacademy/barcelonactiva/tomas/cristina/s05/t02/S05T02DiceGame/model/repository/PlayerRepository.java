package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    boolean existsByName(String name);
    Optional<Player> findByName(String name);
    Optional<Player> findByDni(String dni);
    Optional<Player> findByEmail(String email);
}
