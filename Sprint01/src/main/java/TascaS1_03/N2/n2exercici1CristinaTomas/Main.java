package TascaS1_03.N2.n2exercici1CristinaTomas;

import java.util.HashSet;

public class Main {
    static HashSet<Restaurant> restaurants = new HashSet<>();
    public static void main(String[] args) {

        restaurants.add(new Restaurant("Locanda", 8));
        restaurants.add(new Restaurant("El Purgat", 10));
        restaurants.add(new Restaurant("Burger caw", 3));
        restaurants.add(new Restaurant("Locanda", 7));
        restaurants.add(new Restaurant("Locanda", 8));

        System.out.println("Total: " + restaurants.size());

        for (Restaurant rest : restaurants) {
            System.out.println(rest.toString());
        }




    }
}
