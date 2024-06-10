package TascaS1_08.N1.n1exercici1CristinaTomas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cadenes {
    public static void main(String[] args) {
        List<String> listaCadenas = Arrays.asList("patata", "cebollas", "huevos", "sal");

        List<String> tortilla = filtrarConLetraO(listaCadenas);

        System.out.println("Cadenas con 'o': " + tortilla);
    }

    public static List<String> filtrarConLetraO(List<String> listaCadenas) {

        return listaCadenas.stream()
                .filter(cadena -> cadena.toLowerCase().contains("o"))
                .collect(Collectors.toList());
    }
}
