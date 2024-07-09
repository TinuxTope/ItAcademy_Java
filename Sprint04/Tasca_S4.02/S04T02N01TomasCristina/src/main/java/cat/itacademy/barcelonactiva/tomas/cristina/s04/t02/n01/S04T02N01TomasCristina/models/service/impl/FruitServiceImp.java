package cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.service.impl;

import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.exceptions.FruitNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.domain.Fruit;
import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.repository.FruitRepository;
import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FruitServiceImp implements FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    @Override
    public Fruit addFruita(Fruit fruita) {
        return fruitRepository.save(fruita);
    }

    @Override
    public Fruit updateFruita(Fruit fruita) {
        if (!fruitRepository.existsById(fruita.getId())) {
            throw new FruitNotFoundException("Fruit with ID " + fruita.getId() + " not found");
        }
        return fruitRepository.save(fruita);
    }

    @Override
    public void deleteFruita(int id) {
        Fruit fruita = fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit not found with id " + id));
        fruitRepository.delete(fruita);
    }

    @Override
    public Fruit getFruitaById(int id) {
        return fruitRepository.findById(id)
                .orElseThrow(() -> new FruitNotFoundException("Fruit not found with id " + id));
    }

    @Override
    public List<Fruit> getAllFruites() {
        return fruitRepository.findAll();
    }
}
