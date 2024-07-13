package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.controllers;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Roll;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.dto.RollDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.services.MongoRollService;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.utils.DTOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/players/{playerId}/games")
public class RollController {
    @Autowired
    private MongoRollService rollService;

    @PostMapping
    public ResponseEntity<RollDTO> performRoll(@PathVariable int playerId, @RequestParam boolean useMongo) {
        Roll roll = rollService.saveRoll(playerId);
        return ResponseEntity.ok(DTOUtils.toRollDTO(roll));
    }

    @GetMapping
    public ResponseEntity<List<RollDTO>> getPlayerRolls(@PathVariable int playerId, @RequestParam boolean useMongo) {
        List<Roll> rolls = rollService.getRollsByPlayerId(playerId);
        List<RollDTO> responseDTOs = rolls.stream().map(DTOUtils::toRollDTO).collect(Collectors.toList());
        return ResponseEntity.ok(responseDTOs);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePlayerRolls(@PathVariable int playerId, @RequestParam boolean useMongo) {
        rollService.deleteRollsByPlayerId(playerId);
        return ResponseEntity.ok("Rolls deleted successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<RollDTO> getRollById(@PathVariable int playerId, @PathVariable int id, @RequestParam boolean useMongo) {
        Roll roll = rollService.getRollById(playerId, id);
        return ResponseEntity.ok(DTOUtils.toRollDTO(roll));
    }
}
