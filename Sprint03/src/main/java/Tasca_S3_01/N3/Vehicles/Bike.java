package Tasca_S3_01.N3.Vehicles;

public class Bike implements Vehicle{
    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Bike is accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Bike is braking.");
    }
}
