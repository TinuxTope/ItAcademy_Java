package KataAhorcado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Character>letras = new ArrayList<Character>();
        String palabraSecteta = "";
        String palabraAdivinar = "";
        int maxIntentos = 10;
        int cont = 0;
        String palabraUser = "";

        for(int i = 0; i< palabraSecteta.length(); i++){
            letras.add(palabraSecteta.charAt(i));
        }

        while(palabraAdivinar.equalsIgnoreCase(palabraSecteta) || cont < maxIntentos){

            System.out.println("Dime una letra: ");
            palabraUser = sc.nextLine().toLowerCase();

            for(int i = 0; i < palabraSecteta.length(); i++){
                for(int j = 0; j < palabraUser.charAt(0))

                //if (palabraUser.length() < 1 && palabraSecteta.indexOf(i) == palabraUser.charAt(0)){



               // }

            }


        }
    }
}
