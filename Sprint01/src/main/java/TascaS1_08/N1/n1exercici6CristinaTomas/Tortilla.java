package TascaS1_08.N1.n1exercici6CristinaTomas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Tortilla {
    public static void main(String[] args) {
        List<String> lista = new ArrayList<>();
        lista.add("patatas");
        lista.add("huevos");
        lista.add("cebolla");
        lista.add("sal");
        lista.add("3.24");

        List<String> ingredientes = lista.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();


        // Imprimir la lista ordenada
        System.out.println("Para hacer la tortilla los ingredientes son: " + ingredientes);
    }
}
