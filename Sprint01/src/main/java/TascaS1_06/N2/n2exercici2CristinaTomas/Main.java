package TascaS1_06.N2.n2exercici2CristinaTomas;

public class Main {
    public static void main(String[] args) {
        Personas persona = new Personas("Dídac", "Sàbria", 34);
        String hobby = "Cotxes";
        int numSort = 53;
        Personas persona2 = new Personas("Tina", "Tomás", 36);

        // Crear una instancia de GenericMethod
        GenericMethod metodoGenerico = new GenericMethod();

        // Llamar al método imprimirGenericos a través de la instancia
        metodoGenerico.imprimirGenericos(persona);
        metodoGenerico.imprimirGenericos(persona, hobby);
        metodoGenerico.imprimirGenericos(persona, numSort, persona2);
    }
}
