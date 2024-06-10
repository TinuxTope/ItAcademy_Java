package TascaS1_01.N1.n1exercici2CristinaTomas;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Astra", 145);

        //toString
        System.out.println(car1);

        //Class method 'Static'
        System.out.println(Car.brake());

        //object method (no Static)

        System.out.println(car1.accelerate());

    }

}
