package TascaS1_01.N1.n1exercici1CristinaTomas;

public abstract class Instruments {
    protected String name;
    protected int price;

    public Instruments(String name, int price){
        this.name = name;
        this.price = price;
    }

    public void setName(String name) { this.name = name; }

    public void setPrice(int price) { this.price = price; }

    @Override
    public String toString() {
        return "It's a/an " + this.name + " and my price is " + this.price + "€.";
    }
    public abstract String play();


}
