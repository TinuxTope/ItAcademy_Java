package TascaS1_02.N2.n2exercici1CristinaTomas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {
    private static Scanner input = new Scanner(System.in);


    public static byte readByte(String message) {
        byte value = 0;
        boolean valueOK = false;
        while (!valueOK){
            try {
                System.out.print(message);
                value = input.nextByte();
                valueOK = true;
            } catch (InputMismatchException e) {
                System.out.println("Error in the format.");
                input.nextLine();
            }
        }
        return value;
    }
    public static int readInt(String message) {
        int value = 0;
        boolean valueOK = false;
        while (!valueOK){
            try {
                System.out.print(message);
                value = input.nextInt();
                valueOK = true;
            } catch (InputMismatchException e) {
                System.out.println("Error in the format.");
                input.nextLine();
            }
        }
        return value;
    }
    public static float readFloat(String message) {
        float value = 0.0f;
        boolean valueOK = false;
        while (!valueOK) {
            try {
                System.out.print(message);
                String inputString = input.next();
                String[] parts = inputString.split("\\.");
                if (parts.length > 2 || (parts.length == 2 && parts[1].length() > 2)) {
                    System.out.println("Error: Only two decimal places allowed.");
                } else {
                    value = Float.parseFloat(inputString);
                    valueOK = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error in the format.");
                input.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
                input.nextLine();
            }
        }
        return value;
    }
    public static double readDouble(String message) {
        double value = 0.0;
        boolean valueOK = false;
        while (!valueOK){
            try {
                System.out.print(message);
                String inputString = input.next();
                String[] parts = inputString.split("\\.");
                if (parts.length > 2 || (parts.length == 2 && parts[1].length() > 15)) {
                    System.out.println("Error: Only 15 decimal places allowed for double.");
                } else {
                    value = Double.parseDouble(inputString);
                    valueOK = true;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error in the format.");
                input.nextLine();
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number format.");
                input.nextLine();
            }
        }
        return value;
    }
    //classe Exception:
    public static char readChar(String message) {
        char value = '0';
        boolean valueOK = false;
        do {
            try {
                System.out.print(message);
                value = input.next().charAt(0);
                valueOK = true;
            } catch (InputMismatchException e) {
                System.out.println("Error in the format.");
                input.nextLine();
            }
        } while (!valueOK);
        return value;
    }
    public static String readString(String message) {
        String value = " ";
        boolean valueOK = false;
        do {
            try {
                System.out.print(message);
                value = input.nextLine();
                valueOK = true;
            } catch (InputMismatchException e) {
                System.out.println("Error in the format.");
                input.nextLine();
            }
        } while (!valueOK);
        return value;
    }

    public static boolean readBool(String message){
        boolean answer = false;
        boolean valueOK = false;
        do{
            try{
                System.out.print(message);
                String test = input.next().toLowerCase();
                if (test.equals("y")){
                    answer = true;
                    valueOK = true;
                } else if (test.equals("n")){
                    valueOK = true;
                } else{
                    System.out.println("Error. insert 'y' or 'n'");
                }
            }catch (Exception e){
                System.out.println("Error in the format.");
                input.nextLine();
            }

        }while (!valueOK);
        return answer;
    }


}
