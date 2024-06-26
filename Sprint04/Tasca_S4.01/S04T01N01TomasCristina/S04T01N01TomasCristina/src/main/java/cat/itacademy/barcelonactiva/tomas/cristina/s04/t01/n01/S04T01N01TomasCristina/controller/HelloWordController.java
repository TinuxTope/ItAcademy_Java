package cat.itacademy.barcelonactiva.tomas.cristina.s04.t01.n01.S04T01N01TomasCristina.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordController {
    @GetMapping("/HelloWorld")
    public String greets(@RequestParam(value = "nom", defaultValue = "UNKNOWN") String nom){
        return "Hola, " + nom + ". Estàs executant un projecte Maven.";
    }

    @GetMapping({"/HelloWorld2", "/HelloWorld2/{nom}"})
    public String greets2(@PathVariable(value = "nom", required = false) String nom) {
        if (nom == null) {
            nom = "UNKNOWN";
        }
        return "Hola, " + nom + ". Estàs executant un projecte Maven";
    }
}
