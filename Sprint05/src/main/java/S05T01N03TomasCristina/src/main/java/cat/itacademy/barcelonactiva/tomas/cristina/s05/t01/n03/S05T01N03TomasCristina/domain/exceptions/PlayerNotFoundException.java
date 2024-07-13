package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.exceptions;

public class PlayerNotFoundException extends RuntimeException{
    public PlayerNotFoundException(String email){
        super("Player not found with email " + email);
    }
}
