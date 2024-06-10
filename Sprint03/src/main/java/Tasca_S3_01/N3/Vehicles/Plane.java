package Tasca_S3_01.N3.Vehicles;

public class Plane implements Vehicle{
    @Override
    public void start() {
        System.out.println("Plane is starting.");
    }

    @Override
    public void accelerate() {
        System.out.println("Plane is accelerating.");
    }

    @Override
    public void brake() {
        System.out.println("Plane is braking.");
    }
}
