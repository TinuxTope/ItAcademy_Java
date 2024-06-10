package TascaS1_02.N1.n1exercici1CristinaTomas;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> products;
    private double totalPrice;

    public Sale(ArrayList<Product> products, double totalPrice){
        this.products = new ArrayList<Product>();
        this.totalPrice = totalPrice;
    }

    public ArrayList<Product> getProductsCollection() { return products; }
    public double getTotalPrice() { return totalPrice; }

    public void insertProduct(Product product) { products.add(product); }

    public double computeTotal() throws EmptySaleException{
        if (products.isEmpty()) {
            throw new EmptySaleException("You should add product. Then you can make a sale.");
        }

        for (Product product : products){
            totalPrice += product.getPrice();
        }
        return totalPrice;

    }
}
