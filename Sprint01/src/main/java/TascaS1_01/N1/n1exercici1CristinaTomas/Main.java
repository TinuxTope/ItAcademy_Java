package TascaS1_01.N1.n1exercici1CristinaTomas;

public class Main {
    public static void main(String[] args){

        Wind flute = new Wind("Transverse flute",1650);
        Percussion triangle = new Percussion("Musical triangle",7);
        Rope guitar = new Rope("Guitar",5750);

        //ToString
        System.out.println(flute);
        System.out.println(triangle);
        System.out.println(guitar);

        //play
        System.out.println(flute.play());
        System.out.println(guitar.play());

    }
}
