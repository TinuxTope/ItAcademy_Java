package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.dto;

public class JwtResponse {
    private String token;

    public JwtResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
