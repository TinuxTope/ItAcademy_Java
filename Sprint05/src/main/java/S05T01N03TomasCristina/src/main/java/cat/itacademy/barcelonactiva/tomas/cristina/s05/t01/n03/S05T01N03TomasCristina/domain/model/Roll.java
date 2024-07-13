package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model;

import cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.domain.model.Player;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Entity
@Table(name = "rolls")
@Document(collation = "rolls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Roll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int dice1;

    @Column(nullable = false)
    private int dice2;

    @Column(nullable = false)
    private boolean won;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    private Player player;

}
