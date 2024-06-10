package TascaS1_02.N1.n1exercici1CristinaTomas;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<Product>();
        DecimalFormat df = new DecimalFormat(("#.##"));
        double totalPrice = 0;
        Sale sale = new Sale(products, 0);

        try {
            sale.computeTotal();
        } catch (EmptySaleException error){
            System.out.println(error.getMessage());
        }

        Product phone = new Product("Samsung",856.56);
        Product protect = new Product("Case", 9.52);
        Product battery = new Product("Battery", 25.68);

        products.addAll(List.of(phone, protect, battery));

        for (Product product : products) {
            sale.insertProduct(product);
        }

        try{
            System.out.println("The list of product is: " );
            for (Product product: products){
                System.out.println(product + "\n");
            }
            totalPrice = sale.computeTotal();
            System.out.println("The total price is: " + df.format(totalPrice) + "€.");

        } catch (EmptySaleException error){
            System.out.println(error.getMessage());
        }

        try {
            Product outOfRangeProduct = products.get(3);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Exceptión: " + e.getMessage());

        }

    }
}
