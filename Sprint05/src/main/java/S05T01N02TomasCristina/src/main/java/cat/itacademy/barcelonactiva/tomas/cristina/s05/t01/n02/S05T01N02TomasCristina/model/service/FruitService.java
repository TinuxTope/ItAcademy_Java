package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.service;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.dto.FlowerDTO;

import java.util.List;

public interface FruitService {
    FlowerDTO addFlower(FlowerDTO flowerDTO);
    FlowerDTO updateFlower(Integer id, FlowerDTO flowerDTO);
    void deleteFlower(Integer id);
    FlowerDTO getOneFlower(Integer id);
    List<FlowerDTO> getAllFlowers();
}
