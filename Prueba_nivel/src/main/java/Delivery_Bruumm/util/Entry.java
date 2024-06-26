package Delivery_Bruumm.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {

    public static int readInt(String message, Scanner input) {
        int value = 0;
        boolean valueOK = false;
        while (!valueOK) {
            try {
                System.out.print(message);
                value = input.nextInt();
                valueOK = true;
            } catch (InputMismatchException e) {
                System.out.println("Error en el formato. Por favor, introduzca un número válido.");
                input.nextLine(); // clear the invalid input
            }
        }
        return value;
    }

    public static String readString(String message, Scanner input) {
        System.out.print(message);
        input.nextLine(); // clear the buffer
        return input.nextLine();
    }
}
