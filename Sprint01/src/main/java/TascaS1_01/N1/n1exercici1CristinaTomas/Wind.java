package TascaS1_01.N1.n1exercici1CristinaTomas;

public class Wind extends Instruments{
    public Wind(String name, int price){ super(name,price); }
    @Override
    public String play(){
        return "A wind instrument is being played.";
    }
}
