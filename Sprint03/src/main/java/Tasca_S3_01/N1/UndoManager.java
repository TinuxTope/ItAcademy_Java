package Tasca_S3_01.N1;

import java.util.Scanner;

public class UndoManager {
    private Scanner scanner;
    private Undo undo;

    public UndoManager(Scanner scanner, Undo undo) {
        this.scanner = scanner;
        this.undo = undo;
    }

    public void start() {
        String command;
        while (true) {
            System.out.println("Enter a command (add, remove, list, exit): ");
            command = scanner.nextLine();

            switch (command) {
                case "add":
                    System.out.println("Enter command to add: ");
                    String newCommand = scanner.nextLine();
                    undo.addCommand(newCommand);
                    break;
                case "remove":
                    undo.removeCommand();
                    break;
                case "list":
                    undo.listCommands();
                    break;
                case "exit":
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid command.");
            }
        }
    }

}
