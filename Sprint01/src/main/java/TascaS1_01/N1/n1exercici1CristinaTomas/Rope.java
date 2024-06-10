package TascaS1_01.N1.n1exercici1CristinaTomas;

public class Rope extends Instruments{
    public Rope(String name, int price){ super(name,price); }
    @Override
    public String play(){
        return "A rope instrument is being played.";
    }
}
