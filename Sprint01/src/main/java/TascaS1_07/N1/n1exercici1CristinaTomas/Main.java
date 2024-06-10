package TascaS1_07.N1.n1exercici1CristinaTomas;

public class Main {
    public static void main(String[] args) {

        TreballadorOnline treballadorOnline = new TreballadorOnline("Anita","Garcia", 45);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Julio","Cesar", 45);

        System.out.print("Sueldos");
        System.out.print("- Remote worker: " +treballadorOnline.CalcularSou(150));
        System.out.print("- In office Worker: " +treballadorPresencial.CalcularSou(160));
    }

}
