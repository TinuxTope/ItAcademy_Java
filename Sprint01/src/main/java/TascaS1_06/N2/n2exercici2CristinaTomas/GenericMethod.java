package TascaS1_06.N2.n2exercici2CristinaTomas;

public class GenericMethod {
    public void imprimirGenericos(Object... args) {
        for (Object arg : args) {
            System.out.println(arg);
        }
    }
}
