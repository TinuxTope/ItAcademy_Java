package TascaS1_08.N2.n2exercici3CristinaTomas;

public class Operacions {
    public static void main(String[] args) {
        double a = 10;
        double b = 5;

        Srm[] operacions = {
                (x, y) -> x + y,
                (x, y) -> x - y,
                (x, y) -> x * y,
                (x, y) -> x / y
        };


        double[] resultats = new double[operacions.length];
        for (int i = 0; i < operacions.length; i++) {
            resultats[i] = operacions[i].operacio(a, b);
        }

        // Imprimir resultados
        String[] nomOperacions = {"Suma", "Resta", "Multiplicació", "Divisió"};
        for (int i = 0; i < operacions.length; i++) {
            System.out.println(nomOperacions[i] + ": " + resultats[i]);
        }

    }
}
