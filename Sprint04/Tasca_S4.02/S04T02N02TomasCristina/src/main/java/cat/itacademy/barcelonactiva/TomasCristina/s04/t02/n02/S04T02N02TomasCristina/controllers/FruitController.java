package cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.controllers;

import cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.domain.Fruit;
import cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private IFruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<String> addFruita(@RequestBody Fruit fruita) {
        Fruit savedFruita = fruitService.addFruita(fruita);
        String responseMessage = "Fruit created: " + savedFruita.getNom() + ", Quantity: " + savedFruita.getQuantitatQuilos();
        return ResponseEntity.ok().body(responseMessage);
    }

    @PutMapping("/update")
    public ResponseEntity<Fruit> updateFruita(@RequestBody Fruit fruita) {
        Fruit updatedFruita = fruitService.updateFruita(fruita);
        return ResponseEntity.ok().body(updatedFruita);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteFruita(@PathVariable int id) {
        try {
            fruitService.deleteFruita(id);
            return ResponseEntity.ok().body("Fruit with ID " + id + " deleted successfully");
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitaById(@PathVariable int id) {
        try {
            Fruit fruita = fruitService.getFruitaById(id);
            return ResponseEntity.ok().body(fruita);
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruites() {
        List<Fruit> fruitList = fruitService.getAllFruites();
        return ResponseEntity.ok().body(fruitList);
    }
}
