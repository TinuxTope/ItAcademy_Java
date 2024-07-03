package cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.repository;

import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FruitRepository extends JpaRepository<Fruit,Integer> {
}
