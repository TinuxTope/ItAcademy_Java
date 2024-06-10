package TascaS1_06.N1.n1exercici2CristinaTomas;

public class Main {
    public static void main(String[] args) {
        Personas persona = new Personas("Dídac", "Sabrià", 34);
        String hobby = "Cotxes";
        int numSort = 53;

        GenericMethod<Personas> metodoGenerico = new GenericMethod<>();


        GenericMethod.tipsGenericos(persona, hobby, numSort);

    }
}
