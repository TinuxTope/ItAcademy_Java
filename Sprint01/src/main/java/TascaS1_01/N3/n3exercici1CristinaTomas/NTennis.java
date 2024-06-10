package TascaS1_01.N3.n3exercici1CristinaTomas;

public class NTennis extends New{
    private String competition;
    private String player;

    public NTennis(String headline, String player){
        super(headline);
        this.player = player;
    }

    public  String getPlayer() { return this.player; }
    public void setPlayer(String player) { this.player = player; }

    @Override
    public double calculateNewsPrice(){
        double price = 150;
        if (this.player.equalsIgnoreCase("Federer")
                || (this.player.equalsIgnoreCase("Nadal"))
                || (this.player.equalsIgnoreCase("Djokovic"))){
            price += 100;
        }
        setPrice(price);
        return getPrice();
    }

    @Override
    public byte calculateNewsPoint(){
        byte points = 4;

        if (this.player.equalsIgnoreCase("Federer")
                || (this.player.equalsIgnoreCase("Nadal"))
                || (this.player.equalsIgnoreCase("Djokovic"))) {
            points += 3;
        }
        setPoint(points);
        return  getPoint();
    }
    @Override
    public String toString(){
        return "The tennis news with the title " + super.getHeadline() + " talks about the " +  this.player + ".";
    }
}
