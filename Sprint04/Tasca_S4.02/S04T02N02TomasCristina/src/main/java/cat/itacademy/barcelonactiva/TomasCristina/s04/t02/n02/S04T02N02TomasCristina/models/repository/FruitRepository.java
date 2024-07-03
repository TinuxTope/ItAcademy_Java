package cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.repository;

import cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends JpaRepository<Fruit,Integer> {
}
