package TascaS1_02.N1.n1exercici1CristinaTomas;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name; }

    public double getPrice() {
        return this.price; }
    @Override
    public String toString() {

        return "Product " + this.name + " has a price of " + this.price + "€.";
    }

}
