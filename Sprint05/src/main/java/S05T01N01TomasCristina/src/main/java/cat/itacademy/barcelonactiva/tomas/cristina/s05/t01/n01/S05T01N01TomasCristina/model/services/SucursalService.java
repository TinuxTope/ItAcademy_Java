package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.services;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.exceptions.SucursalNotFoundException;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.domain.Sucursal;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.dto.SucursalDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n01.S05T01N01TomasCristina.model.repository.SucursalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SucursalService {
    @Autowired
    private SucursalRepository sucursalRepository;

    public SucursalDTO addSucursal(SucursalDTO sucursalDTO) {
        Sucursal sucursal = new Sucursal();
        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursal = sucursalRepository.save(sucursal);
        return new SucursalDTO(sucursal.getPk_SucursalId(), sucursal.getNomSucursal(), sucursal.getPaisSucursal());
    }

    public SucursalDTO updateSucursal(Integer id, SucursalDTO sucursalDTO) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal not found with id: " + id));
        sucursal.setNomSucursal(sucursalDTO.getNomSucursal());
        sucursal.setPaisSucursal(sucursalDTO.getPaisSucursal());
        sucursal = sucursalRepository.save(sucursal);
        return new SucursalDTO(sucursal.getPk_SucursalId(), sucursal.getNomSucursal(), sucursal.getPaisSucursal());
    }

    public void deleteSucursal(Integer id) {
        if (!sucursalRepository.existsById(id)) {
            throw new SucursalNotFoundException("Sucursal not found with id: " + id);
        }
        sucursalRepository.deleteById(id);
    }

    public SucursalDTO getOneSucursal(Integer id) {
        Sucursal sucursal = sucursalRepository.findById(id)
                .orElseThrow(() -> new SucursalNotFoundException("Sucursal not found with id: " + id));
        return new SucursalDTO(sucursal.getPk_SucursalId(), sucursal.getNomSucursal(), sucursal.getPaisSucursal());
    }

    public List<SucursalDTO> getAllSucursals() {
        return sucursalRepository.findAll().stream()
                .map(sucursal -> new SucursalDTO(sucursal.getPk_SucursalId(), sucursal.getNomSucursal(), sucursal.getPaisSucursal()))
                .collect(Collectors.toList());
    }
}
