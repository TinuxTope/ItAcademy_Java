package TascaS1_07.N1.n1exercici2CristinaTomas;
@SuppressWarnings("deprecation")
public class Main {
    public static void main(String[] args) {

        TreballadorOnline treballadorOnline = new TreballadorOnline("Anita","Garcia", 45);
        TreballadorPresencial treballadorPresencial = new TreballadorPresencial("Julio","Cesar", 45);

        System.out.println("Sueldos:");
        System.out.println("- Remote worker: " + treballadorOnline.CalcularSou(150));
        System.out.println("- In office Worker: " + treballadorPresencial.CalcularSou(160));


        @SuppressWarnings("deprecation")
        double sueldoRemoto = treballadorOnline.CalcularSouRemot(150,25);
        @SuppressWarnings("deprecation")
        double sueldoPresencial = treballadorPresencial.CalcularSouPresencial(160,1500);

        System.out.println("Sueldos antes de la actualización:");
        System.out.println("- Remote worker: " + sueldoRemoto);
        System.out.println("- In office Worker: " + sueldoPresencial);
    }
}
