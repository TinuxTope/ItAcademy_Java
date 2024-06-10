package TascaS1_01.N3.n3exercici1CristinaTomas;

public class NF1 extends New{
    private String team;

    public NF1(String headline, String team){
        super(headline);
        this.team = team;
    }

    public String getTeam() { return this.team; }
    public void setTeam(String team) { this.team = team; }

    @Override
    public double calculateNewsPrice(){
        double price = 100;
        if ((this.team.equalsIgnoreCase("Ferrari"))
                || (this.team.equalsIgnoreCase("Mercedes"))){
            price += 50;
        }
        setPrice(price);
        return getPrice();
    }
    @Override
    public byte calculateNewsPoint(){
        byte points = 4;
        if ((this.team.equalsIgnoreCase("Ferrari"))
                || (this.team.equalsIgnoreCase("Mercedes"))){
            points += 2;
        }
        setPoint(points);
        return  getPoint();
    }
    @Override
    public String toString(){
        return "The tennis news with the title " + super.getHeadline() + " talks about the " +  this.team + ".";
    }

}
