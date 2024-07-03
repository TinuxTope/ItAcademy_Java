package cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.service;

import cat.itacademy.barcelonactiva.tomas.cristina.s04.t02.n01.S04T02N01TomasCristina.models.domain.Fruit;

import java.util.List;

public interface IFruitService {
    Fruit addFruita(Fruit fruita);
    Fruit updateFruita(Fruit fruita);
    void deleteFruita(int id);
    Fruit getFruitaById(int id);
    List<Fruit> getAllFruites();
}
