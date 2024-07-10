package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "games")
public class GameMongo {
    @Id
    private String id;
    private int dice1;
    private int dice2;
    private boolean win;
    private String playerId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDice1() {
        return dice1;
    }

    public void setDice1(int dice1) {
        this.dice1 = dice1;
    }

    public int getDice2() {
        return dice2;
    }

    public void setDice2(int dice2) {
        this.dice2 = dice2;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }
}
