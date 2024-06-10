package TascaS1_07.N1.n1exercici1CristinaTomas;

public class TreballadorPresencial extends  Treballador{
    private static double benzina = 0.33;
    public TreballadorPresencial(String name, String surName, double priceHour) {
        super(name, surName, priceHour);
        TreballadorPresencial.benzina = benzina;
    }


    @Override
    public double CalcularSou(double workingHours) {
        double salary = (workingHours * getPriceHour()) + benzina;
        return salary;
    }
}
