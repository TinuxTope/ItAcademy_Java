package TascaS1_08.N1.n1exercici8CristinaTomas;

public class Main {
    public static void main(String[] args) {
        Reves reves = (input) -> (new StringBuilder(input)).reverse().toString();

        String inputString = "Bienvenidos al mundo que ven mis ojos.";

        String rev = reves.reverse(inputString);

        // Imprimir el resultado
        System.out.println("Lista original: " + inputString);
        System.out.println("Al revés: " + rev);
    }
}
