package Tasca_S3_01.N1;

import java.util.ArrayList;
import java.util.List;

public class Undo {
    private static Undo instance;
    private List<String> commands;

    private Undo(){
        commands = new ArrayList<>();
    }
    public static Undo getInstance() {
        if (instance == null) {
            instance = new Undo();
        }
        return instance;
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public void removeCommand() {
        if (!commands.isEmpty()) {
            commands.remove(commands.size() - 1);
        } else {
            System.out.println("No commands to undo.");
        }
    }

    public void listCommands() {
        if (commands.isEmpty()) {
            System.out.println("No commands to display.");
        } else {
            System.out.println("Command history:");
            for (String command : commands) {
                System.out.println(command);
            }
        }
    }
}
