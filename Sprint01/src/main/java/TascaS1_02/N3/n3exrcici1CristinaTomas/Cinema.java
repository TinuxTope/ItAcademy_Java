package TascaS1_02.N3.n3exrcici1CristinaTomas;

import java.util.ArrayList;
import java.util.Scanner;

public class Cinema {
    private static Scanner input = new Scanner(System.in);
    private static HandleSeats handleSeats = new HandleSeats();
    private static int numRows;
    private static int numSeatsPerRow;

    public Cinema() {
        dataStart();
    }

    public static void start() {
        while (true) {
            int option = menu();
            switch (option) {
                case 1:
                    showSeats();
                    break;
                case 2:
                    showReservedSeatsByPerson();
                    break;
                case 3:
                    reserveSeat();
                    break;
                case 4:
                    cancelReservation();
                    break;
                case 5:
                    cancelAllReservationsByPerson();
                    break;
                case 0:
                    System.out.println("Goodbye");
                    return;
                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    private static void dataStart() {
        System.out.println("\nHello, you have just entered Tina's Cinema Seat Management.\n");
        System.out.print("Insert number of rows in the cinema room: ");
        numRows = input.nextInt();
        System.out.print("Insert number of seats per row: ");
        numSeatsPerRow = input.nextInt();
        input.nextLine();
    }

    private static int menu() {
        System.out.println("\nThe menu is: " +
                "\n 0. Exit" +
                "\n1. Show all reserved seats" +
                "\n2. Show reserved seats by a person" +
                "\n3. Reserve a seat" +
                "\n4. Cancel reservation of a seat" +
                "\n5. Cancel all reservations of a person" +
                "\nOption: ");
        return input.nextInt();
    }

    private static void showSeats() {
        ArrayList<Seat> seats = handleSeats.getSeats();
        if (seats.isEmpty()) {
            System.out.println("There are no seats reserved.");
        } else {
            System.out.println("Reserved Seats: ");
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        }
    }

    private static void showReservedSeatsByPerson() {
        input.nextLine();
        System.out.print("Enter the name of the person: ");
        String personName = input.nextLine().toLowerCase();
        System.out.println(personName);
        ArrayList<Seat> seats = handleSeats.getSeats();
        boolean found = false;
        for (Seat seat : seats) {
            if (seat.getPerson().equals(personName)) {
                System.out.println(seat);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No reservations found for " + personName + ".");
        }
    }

    private static void reserveSeat() {
        try {
            int row = enterRow();
            int seatNum = enterSeatNum();
            System.out.print("Enter your name: ");
            String userName = input.next();
            handleSeats.addSeat(new Seat(row, seatNum, userName));
        } catch (IncorrectRowException | IncorrectSeatException | OccupiedSeatException e) {
            System.out.println("Invalid input. " + e.getMessage());
        }
    }

    private static void cancelReservation() {
        try {
            int row = enterRow();
            int seatNum = enterSeatNum();
            int identifier = handleSeats.searchSeat(row, seatNum);
            if (identifier != -1) {
                handleSeats.deleteSeat(identifier);
                System.out.println("Reservation cancelled for seat at row " + row + ", seat number " + seatNum);
            } else {
                System.out.println("No reservation found for seat at row " + row + ", seat number " + seatNum);
            }
        } catch (IncorrectRowException | IncorrectSeatException | VacantSeatException e) {
            System.out.println("Invalid input. " + e.getMessage());
        }
    }

    private static void cancelAllReservationsByPerson() {
        input.nextLine();
        System.out.print("Enter the name of the person: ");
        String perName = input.nextLine().toLowerCase();
        ArrayList<Seat> seats = handleSeats.getSeats();
        int count = 0;
        for (Seat seat : seats) {
            if (seat.getPerson().equalsIgnoreCase(perName)) {
                try {
                    handleSeats.deleteSeat(seat.getPersonId());
                    count++;
                } catch (VacantSeatException e){
                    System.out.println("Error cancelling reservation: " + e.getMessage());
            }
        }
        if (count > 0) {
            System.out.println("All reservations for " + perName + " have been cancelled.");
        } else {
            System.out.println("No reservations found for " + perName + ".");
        }
    }
}
    private static int enterRow() throws IncorrectRowException {
        System.out.print("Enter the seat row: ");
        int row = input.nextInt();
        if (row < 1 || row > numRows) {
            throw new IncorrectRowException("Row number is invalid.");
        }
        return row;
    }
    private static int enterSeatNum() throws IncorrectSeatException {
        System.out.print("Enter the seat number: ");
        int seatNum = input.nextInt();
        if (seatNum < 1 || seatNum > numSeatsPerRow) {
            throw new IncorrectSeatException("Seat number is invalid.");
        }
        return seatNum;
    }
}