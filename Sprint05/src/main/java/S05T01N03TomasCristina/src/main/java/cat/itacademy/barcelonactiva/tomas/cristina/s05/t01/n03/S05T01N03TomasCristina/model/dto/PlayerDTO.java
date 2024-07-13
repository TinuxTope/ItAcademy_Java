package cat.itacademy.barcelonactiva.tomas.cristina.s05.t01.n03.S05T01N03TomasCristina.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private int id;
    private String email;
    private String name;
    private String password;
    private int totalRolls;
    private int wonRolls;
    private double successRate;

    public double getSuccessRate() {
        if (totalRolls == 0) {
            return 0.0;
        }
        return (double) wonRolls / totalRolls * 100;
    }
}
