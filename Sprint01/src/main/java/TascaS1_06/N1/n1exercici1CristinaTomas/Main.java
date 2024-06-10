package TascaS1_06.N1.n1exercici1CristinaTomas;

public class Main {
    public static void main(String[] args) {

        Consolas consola1 = new Consolas("PlayStation 5", "Digital Edition", "Blanc");
        Consolas consola2 = new Consolas("Xbox Series X", "Halo Infinite Edition", "Negre");
        Consolas consola3 = new Consolas("Nintendo Switch", "OLED Model", "Neó");


        NoGenericMethods noGenericMethods = new NoGenericMethods (consola1, consola2, consola3);
        System.out.println(noGenericMethods);

        noGenericMethods.emmagatzemarObjecte(2, consola2);
        Consolas consolaExtreta = noGenericMethods.extreureObjecte(1);
        System.out.println("Consola extreta: " + consolaExtreta.getNom());

        noGenericMethods.toString();
    }
}
