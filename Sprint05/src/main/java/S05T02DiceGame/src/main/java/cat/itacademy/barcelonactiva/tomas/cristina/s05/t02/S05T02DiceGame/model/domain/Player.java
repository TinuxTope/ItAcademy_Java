package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.domain;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String dni;
    private String email;
    private Date registerDate;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private List<Game> games;

    public Player() {}

    public Player(String name, String dni, String email, Date registerDate) {
        this.name = name;
        this.dni = dni;
        this.email = email;
        this.registerDate = registerDate;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getDni() { return dni; }

    public void setDni(String dni) { this.dni = dni; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public Date getRegisterDate() { return registerDate; }

    public void setRegisterDate(Date registerDate) { this.registerDate = registerDate; }

    public List<Game> getGames() { return games; }

    public void setGames(List<Game> games) { this.games = games; }
}