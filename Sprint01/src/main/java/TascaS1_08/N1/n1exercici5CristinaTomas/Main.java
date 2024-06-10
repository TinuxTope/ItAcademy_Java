package TascaS1_08.N1.n1exercici5CristinaTomas;

public class Main {
    public static void main(String[] args) {
        PiProvider piProvider = () -> 3.1415;

        System.out.println("Pi es: " + piProvider.getPiValue());
    }
}
