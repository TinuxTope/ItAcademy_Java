package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.utils;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.domain.Roll;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.dto.RollDTO;

public class DTOUtils {
    public static PlayerDTO toPlayerDTO(Player player) {
        return new PlayerDTO(
                player.getId(),
                player.getEmail(),
                player.getName(),
                player.getPassword(),
                player.getTotalRolls(),
                player.getWonRolls(),
                player.getSuccessRate()
        );
    }

    public static Player toPlayerEntity(PlayerDTO playerDTO) {
        return new Player(
                playerDTO.getId(),
                playerDTO.getEmail(),
                playerDTO.getName(),
                playerDTO.getPassword(),
                playerDTO.getTotalRolls(),
                playerDTO.getWonRolls()
        );
    }

    public static RollDTO toRollDTO(Roll roll) {
        return new RollDTO(
                roll.getId(),
                roll.getDice1(),
                roll.getDice2(),
                roll.isWon(),
                roll.getPlayer().getId()
        );
    }
}
