package Tasca_S3_01.N3;

import Tasca_S3_01.N3.Commands.Command;
import Tasca_S3_01.N3.Vehicles.*;

import java.util.Scanner;

public class Parking {
    private VehicleManager vehicleManager;
    private Scanner scanner;

    public Parking() {
        vehicleManager = new VehicleManager();
        scanner = new Scanner(System.in);
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("Choose vehicle (car, bike, plane, boat) or 'exit' to quit:");
            String vehicleType = scanner.nextLine().trim();
            if (vehicleType.equalsIgnoreCase("exit")) {
                running = false;
            }

            Vehicle vehicle = getVehicle(vehicleType);
            if (vehicle == null) {
                System.out.println("Invalid vehicle type.");
                continue;
            }

            System.out.println("Choose command (start, accelerate, brake):");
            String commandType = scanner.nextLine();

            Command command = vehicleManager.getCommand(commandType, vehicle);
            if (command == null) {
                System.out.println("Invalid command.");
                continue;
            }

            vehicleManager.executeCommand(command);
        }
    }

    private Vehicle getVehicle(String vehicleType) {
        switch (vehicleType.toLowerCase()) {
            case "car":
                return new Car();
            case "bike":
                return new Bike();
            case "plane":
                return new Plane();
            case "boat":
                return new Boat();
            default:
                return null;
        }
    }
}
