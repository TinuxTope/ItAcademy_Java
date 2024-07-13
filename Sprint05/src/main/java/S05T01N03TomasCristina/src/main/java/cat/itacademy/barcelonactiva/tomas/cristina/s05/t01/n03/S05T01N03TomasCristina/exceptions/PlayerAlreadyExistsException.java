package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.exceptions;

public class PlayerAlreadyExistsException extends RuntimeException{
    public PlayerAlreadyExistsException(String email){
        super("Player already exists with email: " + email);
    }
}
