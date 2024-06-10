package Tasca_S3_01.N1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Undo undo = Undo.getInstance();

        UndoManager undoManager = new UndoManager(scanner, undo);

        undoManager.start();
    }
}
