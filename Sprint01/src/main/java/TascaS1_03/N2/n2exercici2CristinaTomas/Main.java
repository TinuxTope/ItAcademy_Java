package TascaS1_03.N2.n2exercici2CristinaTomas;

import java.util.HashSet;
import java.util.TreeSet;


public class Main {
    static HashSet<Restaurant> restaurants = new HashSet<>();
    public static void main(String[] args) {
        TreeSet<Restaurant> treeSet = new TreeSet<>(restaurants);

        Restaurant rest1 = new Restaurant("Locanda", 8);
        Restaurant rest2 = new Restaurant("Burger caw", 10);
        Restaurant rest3 = new Restaurant("Purgat", 7);
        Restaurant rest4 = new Restaurant("Locanda", 9);
        restaurants.add(rest1);
        restaurants.add(rest2);
        restaurants.add(rest3);
        restaurants.add(rest4);

        treeSet.addAll(restaurants);

        System.out.println("Ranking: ");

        for(Restaurant restaurant : treeSet) {
            System.out.println("- " + restaurant);
        }
    }
}
