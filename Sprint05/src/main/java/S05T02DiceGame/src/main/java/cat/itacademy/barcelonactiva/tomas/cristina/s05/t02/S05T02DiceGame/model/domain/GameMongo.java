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
}
