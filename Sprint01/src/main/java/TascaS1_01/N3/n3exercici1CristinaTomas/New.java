package TascaS1_01.N3.n3exercici1CristinaTomas;

public abstract class New {
    private String headline;
    private String text;
    private byte rating;
    protected static double price;
    protected byte point;


    public New(String headline){
        this.headline = headline;
        text = "";
        rating = 0;
        price = 0;
        point = 0;
    }

    public String getHeadline(){ return this.headline; }
    public void setHeadline(String headline) { this.headline = headline; }
    public String getText() { return this.text; }
    public void setText(String text) { this.text = text; }
    public byte getRating() { return rating; }
    public void setRating(byte rating) { this.rating = rating; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public byte getPoint() {return point; }
    public void setPoint(byte point) { this.point = point; }


    public abstract double calculateNewsPrice();

    public abstract byte calculateNewsPoint();
    @Override
    public String toString(){
        return "The news with the title " + this.headline + ".";
    }

}
