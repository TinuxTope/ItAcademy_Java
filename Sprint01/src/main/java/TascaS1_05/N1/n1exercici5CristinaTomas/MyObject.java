package TascaS1_05.N1.n1exercici5CristinaTomas;

import java.io.Serializable;

public class MyObject implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nom;

    public MyObject(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
}
