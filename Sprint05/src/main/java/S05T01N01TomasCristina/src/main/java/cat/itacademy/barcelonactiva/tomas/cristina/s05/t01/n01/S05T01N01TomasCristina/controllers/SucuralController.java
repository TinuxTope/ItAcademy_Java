package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.services.SucursalService;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sucursal")
public class SucuralController {
    @Autowired
    private SucursalService sucursalService;
    @GetMapping
    public String viewSucursals(Model model) {
        List<SucursalDTO> sucursales = sucursalService.getAllSucursals();
        model.addAttribute("sucursales", sucursales);
        return "sucursal";
    }

    @PostMapping("/add")
    public SucursalDTO addSucursal(@RequestBody SucursalDTO sucursalDTO) {
        return sucursalService.addSucursal(sucursalDTO);
    }

    @PutMapping("/update/{id}")
    public SucursalDTO updateSucursal(@PathVariable Integer id, @RequestBody SucursalDTO sucursalDTO) {
        return sucursalService.updateSucursal(id, sucursalDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteSucursal(@PathVariable Integer id) {
        sucursalService.deleteSucursal(id);
    }

    @GetMapping("/getOne/{id}")
    public SucursalDTO getOneSucursal(@PathVariable Integer id) {
        return sucursalService.getOneSucursal(id);
    }

    @GetMapping("/getAll")
    public List<SucursalDTO> getAllSucursals() {
        return sucursalService.getAllSucursals();
    }
}
