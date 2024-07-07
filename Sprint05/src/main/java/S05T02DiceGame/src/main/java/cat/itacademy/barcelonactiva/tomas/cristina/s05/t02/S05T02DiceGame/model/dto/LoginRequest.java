package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.dto;

public class LoginRequest {
    private String nick;
    private String password;

    // Getters and Setters
    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
