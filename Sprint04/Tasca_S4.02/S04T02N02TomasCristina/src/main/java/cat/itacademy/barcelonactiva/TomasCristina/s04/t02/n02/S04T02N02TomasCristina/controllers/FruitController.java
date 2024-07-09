package cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.controllers;

import cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.domain.Fruit;
import cat.itacademy.barcelonactiva.TomasCristina.s04.t02.n02.S04T02N02TomasCristina.models.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fruits")
public class FruitController {
    @Autowired
    private FruitService fruitService;

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
        fruitService.deleteFruita(id);
        return ResponseEntity.ok().body("Fruit with ID " + id + " deleted successfully");

    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitaById(@PathVariable int id) {

        Fruit fruita = fruitService.getFruitaById(id);
        return ResponseEntity.ok().body(fruita);

    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruites() {
        List<Fruit> fruitList = fruitService.getAllFruites();
        return ResponseEntity.ok().body(fruitList);
    }
}
