package TascaS1_02.N3.n3exrcici1CristinaTomas;

import java.util.ArrayList;

public class HandleSeats {
    private static ArrayList<Seat> seats;

    public HandleSeats(){
        seats = new ArrayList<>();
    }
    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public static int searchSeat(int row, int seatNum) {
        boolean match = false;
        int i = 0;
        int index = -1;

        while (i < seats.size() && !match) {
            if ((seats.get(i).getRow() == row) && (seats.get(i).getSeatNum() == seatNum)) {
                match = true;
                index = i;
            }
            i++;
        }
        return index;
    }

    public void addSeat(Seat seatRes) throws OccupiedSeatException {
        if (searchSeat(seatRes.getRow(), seatRes.getSeatNum()) != -1) {
            throw new OccupiedSeatException("The seat is already occupied");
        }
        seats.add(seatRes);
    }

    public void deleteSeat(int identifier) throws VacantSeatException {
        if (identifier >= 0 && identifier < seats.size()) {
            seats.remove(identifier);
            System.out.println("Seat at index " + identifier + " has been cancelled.");
        } else {
            ArrayList<Seat> seatsToRemove = new ArrayList<>();
            for (Seat seat : seats) {
                if (seat.getPersonId() == identifier) {
                    seatsToRemove.add(seat);
                }
            }
            if (seatsToRemove.isEmpty()) {
                throw new VacantSeatException("No reservations found for person with ID " + identifier);
            }
            seats.removeAll(seatsToRemove);
            System.out.println("All reservations for person with ID " + identifier + " have been cancelled.");
        }
    }
}
