package TascaS1_06.N2.n2exercici1CristinaTomas;

public class GenericNoGeneric <T>{
    public static <T> void tipsGenericos(T arg1, String arg2, T arg3) {
        System.out.println("Argument 1: " + arg1
                + "\n Argument 2: " + arg2 + "\n Argument 3: " + arg3);
    }
}
