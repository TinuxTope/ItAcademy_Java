package TascaS1_06.N1.n1exercici1CristinaTomas;

public class NoGenericMethods {
    Consolas consola1;
    Consolas consola2;
    Consolas consola3;

    public NoGenericMethods(Consolas consola1, Consolas consola2, Consolas consola3) {
        this.consola1 = consola1;
        this.consola2 = consola2;
        this.consola3 = consola3;
    }

    public void emmagatzemarObjecte(int posicio, Consolas objecte) {
        if (posicio == 1) {
            this.consola1 = objecte;
        } else if (posicio == 2) {
            this.consola2 = objecte;
        } else if (posicio == 3) {
            this.consola3 = objecte;
        } else {
            throw new IllegalArgumentException("Posició no vàlida: " + posicio);
        }
    }

    public Consolas extreureObjecte(int posicio) {
        if (posicio == 1) {
            return this.consola1;
        } else if (posicio == 2) {
            return this.consola2;
        } else if (posicio == 3) {
            return this.consola3;
        } else {
            throw new IllegalArgumentException("Posició no vàlida: " + posicio);
        }
    }

    @Override
    public String toString(){
        return "Consola 1: " + consola1.getNom() + "\n" +
                "consola 2: " + consola2.getNom() + "\n" + "consola 3: " + consola3.getNom();

    }
}
