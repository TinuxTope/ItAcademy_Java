package cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.service;

import cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.domain.Fruit;

import java.util.List;

public interface FruitService {
    Fruit addFruita(Fruit fruita);
    Fruit updateFruita(Fruit fruita);
    void deleteFruita(int id);
    Fruit getFruitaById(int id);
    List<Fruit> getAllFruites();
}
