package TascaS1_03.N2.n2exercici2CristinaTomas;

import java.util.Objects;

public class Restaurant implements Comparable<Restaurant>{
    private String name;
    private int score;

    public Restaurant(String name, int score){
        this.name = name;
        this.score = score;
    }

    public String getName(){
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return score == that.score &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }

    @Override
    public int compareTo(Restaurant other) {
        // Comparar por puntuación, si son iguales, comparar por nombre
        if (this.score != other.score) {
            return Integer.compare(other.score, this.score);
        } else {
            return this.name.compareTo(other.name);
        }
    }

    @Override
    public String toString() {
        String ms = "Restaurant: " + this.getName() + " Score: " + this.getScore() + ".";
        return ms;
    }
}
