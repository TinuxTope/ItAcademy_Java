package Tasca_S3_02.N1.Observer;

public class StockAgency implements StockObserver {
    private String name;

    public StockAgency(String name) {
        this.name = name;
    }

    @Override
    public void update(String stockData) {
        System.out.println("StockAgency " + name + " received update: " + stockData);
    }
}
