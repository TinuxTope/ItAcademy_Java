package TascaS1_01.N3.n3exercici1CristinaTomas;

public class NFootball extends New{
    private String competition;
    private String club;
    private String player;

    public NFootball(String headline, String competition, String club, String player){
        super(headline);
        this.competition = competition;
        this.club = club;
        this.player = player;
    }

    public String getCompetition() { return this.competition; }
    public void setCompetition(String competition) { this.competition = competition; }
    public String getClub() { return  this.club; }
    public void setClub(String club) { this.club = club; }
    public  String getPlayer() { return this.player; }
    public void setPlayer(String player) { this.player = player; }

    @Override
    public double calculateNewsPrice(){
        double price = 300;
        if (this.competition.equalsIgnoreCase("Champion")) {
            price += 100;
        }
        if ((this.club.equalsIgnoreCase("Barça"))
                || (this.club.equalsIgnoreCase("Madrid"))){
            price += 100;
        }
        if (this.player.equalsIgnoreCase("Ferran Torres")
                || (this.player.equalsIgnoreCase("Benzema"))){
            price += 50;
        }
        setPrice(price);
        return getPrice();
    }
    @Override
    public byte calculateNewsPoint(){
        byte points = 5;
        if (this.competition.equalsIgnoreCase("league")) {
            points += 2;
        } else if (this.competition.equalsIgnoreCase("Champion")) {
            points += 3;
        }

        if (this.club.equalsIgnoreCase("Barça") || this.club.equalsIgnoreCase("Madrid")) {
            points += 1;
        }

        if (this.player.equalsIgnoreCase("Ferran Torres") || this.player.equalsIgnoreCase("Benzema")) {
            points += 1;
        }
        setPoint(points);
        return  getPoint();
    }
    @Override
    public String toString(){
        return "The football news with the title " + super.getHeadline() + " talks about the " + this.competition +
                " of the " + this.club + " and the player " + this.player + ".";
    }

}
