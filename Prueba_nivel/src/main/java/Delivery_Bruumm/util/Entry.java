package Delivery_Bruumm.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {
    private static Scanner input = new Scanner(System.in);

    public static int readInt(String message) {
        int value = 0;
        boolean valueOK = false;
        while (!valueOK) {
            try {
                System.out.print(message);
                value = input.nextInt();
                valueOK = true;
            } catch (InputMismatchException e) {
                System.out.println("Error en el formato. Por favor, introduzca un número válido.");
                input.nextLine();
            }
        }
        return value;
    }

    public static String readString(String message) {
        System.out.print(message);
        return input.next();
    }
}
