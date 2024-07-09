package cat.itacademy.barcelonactiva.tomas.cristina.s05.t02.S05T02DiceGame.model.dto;

import java.util.Date;

public class PlayerDTO {
    private Long id;
    private String name;
    private Date registerDate;

    public PlayerDTO() {}

    public PlayerDTO(Long id, String name, Date registerDate) {
        this.id = id;
        this.name = name;
        this.registerDate = registerDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }
}
