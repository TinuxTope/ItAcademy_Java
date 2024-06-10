package Tasca_S3_01.N3;

import Tasca_S3_01.N3.Commands.AccelerateCommand;
import Tasca_S3_01.N3.Commands.BrakeCommand;
import Tasca_S3_01.N3.Commands.Command;
import Tasca_S3_01.N3.Commands.StartCommand;
import Tasca_S3_01.N3.Vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleManager {
    private List<Command> commands;

    public VehicleManager() {
        commands = new ArrayList<>();
    }

    public void executeCommand(Command command) {
        commands.add(command);
        command.execute();
    }

    public Command getCommand(String action, Vehicle vehicle) {
        switch (action.toLowerCase()) {
            case "start":
                return new StartCommand(vehicle);
            case "accelerate":
                return new AccelerateCommand(vehicle);
            case "brake":
                return new BrakeCommand(vehicle);
            default:
                return null;
        }
    }
}
