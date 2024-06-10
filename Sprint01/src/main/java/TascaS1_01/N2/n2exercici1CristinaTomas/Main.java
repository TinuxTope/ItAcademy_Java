package TascaS1_01.N2.n2exercici1CristinaTomas;

public class Main {
    public static void main(String[] args) {
        Smartphone samsung = new Smartphone("Samsung","Galaxy S24");

        System.out.println(samsung.alarm());
        System.out.println(samsung.photograph());
        System.out.println(samsung.call("666 547 547"));
    }
}
