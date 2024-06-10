package TascaS1_07.N1.n1exercici1CristinaTomas;

public class TreballadorOnline extends Treballador {
    private static final double internetPrice = 49.95;

    public TreballadorOnline(String name, String surName, double priceHour) {
        super(name, surName, priceHour);
    }


    @Override
    public double CalcularSou(double workingHours) {
        double salary = (workingHours * getPriceHour()) + internetPrice;
        return salary;
    }
}
