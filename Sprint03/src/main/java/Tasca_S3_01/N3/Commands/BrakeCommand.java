package Tasca_S3_01.N3.Commands;

import Tasca_S3_01.N3.Vehicles.Vehicle;

public class BrakeCommand implements Command{
    private Vehicle vehicle;

    public BrakeCommand(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    @Override
    public void execute() {
        vehicle.brake();
    }
}
