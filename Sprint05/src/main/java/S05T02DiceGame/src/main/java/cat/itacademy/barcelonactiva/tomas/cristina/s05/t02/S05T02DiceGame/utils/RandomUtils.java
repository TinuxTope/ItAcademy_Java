package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static int rollDice() {
        return RANDOM.nextInt(6) + 1;
    }
}
