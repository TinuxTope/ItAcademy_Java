package TascaS1_06.N1.n1exercici2CristinaTomas;

public class GenericMethod<T>{
    public static <T> void tipsGenericos(T arg1, T arg2, T arg3) {
        System.out.println("Argument 1: " + arg1
        + "\n Argument 2: " + arg2 + "\n Argument 3: " + arg3);
    }
}
