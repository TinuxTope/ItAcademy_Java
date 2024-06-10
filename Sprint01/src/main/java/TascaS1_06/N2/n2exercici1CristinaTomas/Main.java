package TascaS1_06.N2.n2exercici1CristinaTomas;

public class Main {
    public static void main(String[] args) {
        TascaS1_06.N1.n1exercici2CristinaTomas.Personas persona = new TascaS1_06.N1.n1exercici2CristinaTomas.Personas("Dídac", "Sabrià", 34);
        String hobby = "Cotxes";
        int numSort = 53;

        GenericNoGeneric metodoGenerico = new GenericNoGeneric();

        GenericNoGeneric.tipsGenericos(persona, hobby, numSort);

    }
}
