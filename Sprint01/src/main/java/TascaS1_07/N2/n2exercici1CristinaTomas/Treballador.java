package TascaS1_07.N2.n2exercici1CristinaTomas;

@JsonSerializable
public class Treballador {
    private String name;
    private String surName;
    private double priceHour;


    public Treballador(String name, String surName, double priceHour) {
        this.name = name;
        this.surName = surName;
        this.priceHour = priceHour;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public double getPriceHour() {
        return priceHour;
    }
}
