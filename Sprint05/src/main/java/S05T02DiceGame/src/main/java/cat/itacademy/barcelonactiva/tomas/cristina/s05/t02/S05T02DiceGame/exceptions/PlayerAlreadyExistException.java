package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.exceptions;

public class PlayerAlreadyExistException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PlayerAlreadyExistException(String message) {
        super(message);
    }
}
