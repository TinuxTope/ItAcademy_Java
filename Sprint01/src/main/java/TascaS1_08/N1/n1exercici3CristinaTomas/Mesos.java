package TascaS1_08.N1.n1exercici3CristinaTomas;

import java.util.List;
import java.util.Arrays;

public class Mesos {
    public static void main(String[] args) {

        List<String> nomsMesos = Arrays.asList(
                "Gener", "Febrer", "Març", "Abril", "Maig", "Juny",
                "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"
        );

        nomsMesos.forEach(mes -> System.out.println(mes));
    }
}
