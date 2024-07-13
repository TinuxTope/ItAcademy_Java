package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.utils;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model.Player;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model.Roll;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.dto.PlayerDTO;
import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.api.dto.RollDTO;

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
    public static Roll toRollEntity(RollDTO rollDTO) {
        Roll roll = new Roll();
        roll.setId(rollDTO.getId());
        roll.setDice1(rollDTO.getDice1());
        roll.setDice2(rollDTO.getDice2());
        roll.setWon(rollDTO.isWon());
        // Player should be set outside of this method to avoid unnecessary dependencies
        return roll;
    }
}
