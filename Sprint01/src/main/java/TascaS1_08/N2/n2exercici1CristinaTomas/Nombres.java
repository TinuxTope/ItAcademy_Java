package TascaS1_08.N2.n2exercici1CristinaTomas;

import java.util.ArrayList;
import java.util.List;

public class Nombres {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        nombres.add("Antonia");
        nombres.add("Didac");
        nombres.add("Tina");
        nombres.add("Agapito");
        nombres.add("Alex");
        nombres.add("Ana");


        List<String> nombresFiltrados = nombres.stream()
                .filter(nombre -> nombre.startsWith("A") && nombre.length() == 3)
                .toList();

        // Imprimir el resultado
        System.out.println("Nombres que empiezen com 'a' y contienen 3 letras: " + nombresFiltrados);
    }
}
