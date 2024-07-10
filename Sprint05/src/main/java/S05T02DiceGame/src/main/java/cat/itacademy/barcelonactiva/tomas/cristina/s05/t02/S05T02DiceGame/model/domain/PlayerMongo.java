package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "players")
public class PlayerMongo {
    @Id
    private String id;
    private String name;

    private String email;
    private String password;
    private Date registerDate;
    private List<GameMongo> games;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public List<GameMongo> getGames() {
        return games;
    }

    public void setGames(List<GameMongo> games) {
        this.games = games;
    }
}
