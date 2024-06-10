package TascaS1_08.N1.n1exercici2CristinaTomas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CadenasExtended {
    public static void main(String[] args) {
        List<String> listaCadenas = Arrays.asList("patata", "cebollas", "huevos", "sal");

        List<String> tortilla = filtrarConLetraO(listaCadenas);

        System.out.println("Cadenas con 'o' y más de 5 letras: " + tortilla);
    }

    public static List<String> filtrarConLetraO(List<String> listaCadenas) {

        return listaCadenas.stream()
                .filter(cadena -> cadena.contains("o") && cadena.length() > 5)
                .collect(Collectors.toList());
    }
}
