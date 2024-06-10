package TascaS1_01.N1.n1exercici1CristinaTomas;

public class Percussion extends Instruments{
    public Percussion(String name, int price){
        super(name, price);
    }
    @Override
    public String play(){
        return "A percussion instrument is being played.";
    }
}

