package TascaS1_08.N2.n2exercici2CristinaTomas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CadenasNumeros {
    public static void main(String[] args) {

        List<Integer> numeros = new ArrayList<>();
        numeros.add(9);
        numeros.add(256);
        numeros.add(55);
        numeros.add(44);
        numeros.add(16);

        // Obtener la cadena separada por comas utilizando lambdas
        String resultado = obtenerCadena(numeros);

        // Imprimir el resultado
        System.out.println("Cadena resultante: " + resultado);
    }

    public static String obtenerCadena(List<Integer> numeros) {
        // Utilizar expresiones lambda para mapear cada número a su representación con 'o' o 'e'
        return numeros.stream()
                .map(numero -> (numero % 2 == 0 ? "e" : "o") + numero)
                .collect(Collectors.joining(", "));
    }
}
