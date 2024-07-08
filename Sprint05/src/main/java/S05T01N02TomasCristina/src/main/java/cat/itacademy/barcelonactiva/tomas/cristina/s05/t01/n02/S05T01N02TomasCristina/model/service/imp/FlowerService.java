package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.service.imp;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.exceptions.FlowerNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.domian.FlowerEntity;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.service.IFruitService;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.util.ContinentCountries;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.dto.FlowerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n02.S05T01N02TomasCristina.model.repository.FlowerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FlowerService implements IFruitService {
    @Autowired
    private FlowerRepository flowerRepository;

    @Override
    public FlowerDTO addFlower(FlowerDTO flowerDTO) {
        FlowerEntity flower = new FlowerEntity(flowerDTO.getName(), flowerDTO.getCountry());
        flower = flowerRepository.save(flower);
        return convertToDTO(flower);
    }

    @Override
    public FlowerDTO updateFlower(Integer id, FlowerDTO flowerDTO) {
        FlowerEntity flower = flowerRepository.findById(id)
                .orElseThrow(() -> new FlowerNotFoundException("Flower not found with id: " + id));
        flower.setName(flowerDTO.getName());
        flower.setCountry(flowerDTO.getCountry());
        flower = flowerRepository.save(flower);
        return convertToDTO(flower);
    }

    @Override
    public void deleteFlower(Integer id) {
        if (!flowerRepository.existsById(id)) {
            throw new FlowerNotFoundException("Flower not found with id: " + id);
        }
        flowerRepository.deleteById(id);
    }

    @Override
    public FlowerDTO getOneFlower(Integer id) {
        FlowerEntity flower = flowerRepository.findById(id)
                .orElseThrow(() -> new FlowerNotFoundException("Flower not found with id: " + id));
        return convertToDTO(flower);
    }

    @Override
    public List<FlowerDTO> getAllFlowers() {
        return flowerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private FlowerDTO convertToDTO(FlowerEntity flower) {
        return new FlowerDTO(
                flower.getPk_FlowerID(),
                flower.getName(),
                flower.getCountry(),
                ContinentCountries.getContinent(flower.getCountry())
        );
    }
}
