package TascaS1_01.N3.n3exercici1CristinaTomas;

public class NMotorcycle extends New{
    private String team;

    public NMotorcycle(String headline, String team){
        super(headline);
        this.team = team;
    }

    public String getTeam() { return this.team; }
    public void setTeam(String team) { this.team = team; }

    @Override
    public double calculateNewsPrice(){
        double price = 100;
        if ((this.team.equalsIgnoreCase("Honda"))
                || (this.team.equalsIgnoreCase("Yamaha"))){
            price += 50;
        }
        setPrice(price);
        return getPrice();

    }
    @Override
    public byte calculateNewsPoint(){
        byte points = 3;
        if ((this.team.equalsIgnoreCase("Honda"))
                || (this.team.equalsIgnoreCase("Yamaha"))){
            points += 3;
        }
        setPoint(points);
        return  getPoint();
    }
    @Override
    public String toString(){
        return "The tennis news with the title " + super.getHeadline() + " talks about the " +  this.team + ".";
    }
}
