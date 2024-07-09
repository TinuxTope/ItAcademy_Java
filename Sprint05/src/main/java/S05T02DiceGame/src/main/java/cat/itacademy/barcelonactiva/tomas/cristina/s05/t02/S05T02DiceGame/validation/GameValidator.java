package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.validation;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain.Game;

public class GameValidator {
    public static boolean isValidGame(Game game) {
        return game.getDice1() >= 1 && game.getDice1() <= 6 &&
                game.getDice2() >= 1 && game.getDice2() <= 6;
    }
}
