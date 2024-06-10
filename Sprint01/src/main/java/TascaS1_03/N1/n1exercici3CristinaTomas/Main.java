package TascaS1_03.N1.n1exercici3CristinaTomas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/TascaS1_03/N1/n1exercici3CristinaTomas/countries.txt";
        File file = new File(filePath);


        HashMap<String, String> countries = readCountries(filePath);
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Welcome to the guessing game of capitals! What's your name? ");
        String nameUser = input.nextLine();
        int score = 0;

        for (int i = 0; i < 10; i++) {
            String country = countries.keySet().toArray(new String[0])[random.nextInt(countries.size())];
            String capitalCorrect = countries.get(country);
            System.out.println("¿What is the capital of " + country + "?");
            String capitalUser = input.nextLine();
            if (capitalUser.equalsIgnoreCase(capitalCorrect)) {
                System.out.println("¡Correct! +1 point.");
                score++;
            } else {
                System.out.println("Incorrect. The capital is " + capitalCorrect + ".");
            }
        }
        saveScore(nameUser, score);
    }

    public static HashMap<String, String> readCountries(String file) {
        HashMap<String, String> countries = new HashMap<>();

        try  {
            BufferedReader reader = Files.newBufferedReader(Paths.get(file));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ", 2);
                countries.put(parts[0], parts[1]);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return countries;
    }

    public static void saveScore(String nameUser, int score) {
        try (FileWriter writer = new FileWriter("src/main/java/TascaS1_03/N1/n1exercici3CristinaTomas/classification.txt", true)) {
            writer.write(nameUser + ":  "  + score +  " puntos\n");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the score: " + e.getMessage());
        }
    }
}