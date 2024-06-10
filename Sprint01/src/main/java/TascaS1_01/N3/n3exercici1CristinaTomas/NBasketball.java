package TascaS1_01.N3.n3exercici1CristinaTomas;

public class NBasketball extends New{
    private String competition;
    private String club;

    public NBasketball(String headline, String competition, String club){
        super(headline);
        this.competition = competition;
        this.club = club;
    }

    public String getCompetition() { return this.competition; }
    public void setCompetition(String competition) { this.competition = competition; }
    public String getClub() { return  this.club; }
    public void setClub(String club) { this.club = club; }

    @Override
    public double calculateNewsPrice(){
        double price = 250;
        if (this.competition.equalsIgnoreCase("Eurolliga")) {
            price += 75;
        }
        if ((this.club.equalsIgnoreCase("Barça"))
                || (this.club.equalsIgnoreCase("Madrid"))){
            price += 75;
        }
        setPrice(price);
        return getPrice();
    }

    @Override
    public byte calculateNewsPoint(){
        byte points = 4;
        if (this.competition.equalsIgnoreCase("Eurolliga")) {
            points += 3;
        } else if (this.competition.equalsIgnoreCase("ACB")) {
            points += 2;
        }

        if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
            points += 1;
        }
        setPoint(points);
        return  getPoint();
    }
    @Override
    public String toString(){
        return "The basketball news with the title " + super.getHeadline() + " talks about the " + this.competition +
                " of the " + this.club + ".";
    }
}
