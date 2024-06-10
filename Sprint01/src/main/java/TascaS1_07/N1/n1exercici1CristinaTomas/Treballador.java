package TascaS1_07.N1.n1exercici1CristinaTomas;

public abstract class Treballador {
    protected String name;
    protected String surName;
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


    public abstract double CalcularSou(double workingHours);
}
