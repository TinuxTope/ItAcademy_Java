package TascaS1_02.N3.n3exrcici1CristinaTomas;

import java.util.Objects;

public class Seat {
    private int row;
    private int seatNum;
    private String person;
    private int personId;
    private static int nextPersonId = 1;

    public Seat(int row, int seatNum, String person) {
        this.row = row;
        this.seatNum = seatNum;
        this.person = person;
        this.personId = nextPersonId++;
    }

    public int getRow() { return row; }
    public int getSeatNum() { return seatNum; }
    public int getPersonId(){return personId; }

    public String getPerson() { return person; }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return row == seat.row && seatNum == seat.seatNum;
    }


    @Override
    public String toString() {
        return "Seat{" + "row=" + row + ", seatNum=" + seatNum + ", person='" + person + '\'' +
                '}';
    }

}
