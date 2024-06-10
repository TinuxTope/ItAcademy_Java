package TascaS1_08.N1.n1exercici4CristinaTomas;

import java.util.Arrays;
import java.util.List;

public class MesosReference {
    public static void main(String[] args) {

        List<String> nomsMesos = Arrays.asList(
                "Gener", "Febrer", "Març", "Abril", "Maig", "Juny",
                "Juliol", "Agost", "Setembre", "Octubre", "Novembre", "Desembre"
        );

        nomsMesos.forEach(System.out::println);

    }
}
