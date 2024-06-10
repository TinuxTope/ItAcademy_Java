package TascaS1_06.N2.n2exercici2CristinaTomas;

public class Personas {
    private String nom;
    private String cognom;
    private int edat;

    public Personas(String nom, String cognom, int edat) {
        this.nom = nom;
        this.cognom = cognom;
        this.edat = edat;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public int getEdat() {
        return edat;
    }

    @Override
    public String toString() {
        return "Sóc " + getNom() + " el meu cognom es " + getCognom() + " i tinc " + getEdat() + " anys.";
    }
}
