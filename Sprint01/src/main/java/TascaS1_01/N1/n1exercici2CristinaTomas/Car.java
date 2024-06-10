package TascaS1_01.N1.n1exercici2CristinaTomas;

public class Car {
    private static final String BRAND = "Opel";
    private static String model = "Astra";
    private final int power;

    public Car(String model, int power){
        Car.model = model;
        this.power = power;
    }

    public String getBrand(){ return BRAND; }
    public String getModel(){ return model; }
    public int getPower(){ return power; }

    public static String brake(){ return "The vehicle is braking."; }
    public String accelerate(){ return "The vehicle is accelerating.";}

    @Override
    public String toString() {
        return "Car with the brand " + this.getBrand() + ", model " + this.getModel()
                + ", and with a power of " + this.power +"hp.";
    }
}
