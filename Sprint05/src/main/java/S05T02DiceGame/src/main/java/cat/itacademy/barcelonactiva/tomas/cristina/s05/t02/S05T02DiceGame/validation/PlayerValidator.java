package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.validation;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Player;

public class PlayerValidator {
    public static boolean isValidPlayer(Player player) {
        return player.getEmail() != null && !player.getEmail().isEmpty() &&
                player.getPassword() != null && !player.getPassword().isEmpty();
    }
}
