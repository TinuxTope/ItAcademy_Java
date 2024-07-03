package cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.service.implementacion;

import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.domain.Fruit;
import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.repository.FruitRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImp implements IFruitService {

    @Autowired
    private FruitRepository fruitaRepository;

    @Override
    public Fruit addFruita(Fruit fruita) {
        return fruitaRepository.save(fruita);
    }

    @Override
    public Fruit updateFruita(Fruit fruita) {
        if (!fruitaRepository.existsById(fruita.getId())) {
            throw new FruitNotFoundException("Fruit with ID " + fruita.getId() + " not found");
        }
        return fruitaRepository.save(fruita);
    }

    @Override
    public void deleteFruita(int id) {
        if (!fruitaRepository.existsById(id)) {
            throw new FruitNotFoundException("Fruit with ID " + id + " not found");
        }
        fruitaRepository.deleteById(id);
    }

    @Override
    public Fruit getFruitaById(int id) {
        return fruitaRepository.findById(id).orElseThrow(() -> new FruitNotFoundException("Fruit with ID " + id + " not found"));
    }

    @Override
    public List<Fruit> getAllFruites() {
        return fruitaRepository.findAll();
    }
}
