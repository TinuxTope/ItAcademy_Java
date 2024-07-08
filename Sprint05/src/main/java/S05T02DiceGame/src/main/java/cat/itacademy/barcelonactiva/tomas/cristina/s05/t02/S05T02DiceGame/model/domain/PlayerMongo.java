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
    private String dni;
    private String email;
    private Date registerDate;
    private List<GameMongo> games;
}
