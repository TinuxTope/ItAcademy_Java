package TascaS1_01.N2.n2exercici1CristinaTomas;

public class Phone {
    private String brand;
    private String model;

    public Phone(String brand, String model){
        this.brand = brand;
        this.model = model;
    }

    public String getBrand(){ return this.brand; }
    public String getModel(){ return this.model; }

    public String call(String phoneNum){
        return "Calling " + phoneNum;
    }


}
