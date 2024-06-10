package Tasca_S3_02.N1;

import Tasca_S3_02.N1.Observable.StockAgent;
import Tasca_S3_02.N1.Observer.StockAgency;

public class Main {
    public static void main(String[] args) {
        StockAgent agent = new StockAgent();

        StockAgency agency1 = new StockAgency("Agency 1");
        StockAgency agency2 = new StockAgency("Agency 2");
        StockAgency agency3 = new StockAgency("Agency 3");

        agent.addObserver(agency1);
        agent.addObserver(agency2);
        agent.addObserver(agency3);

        agent.setStockData("Stock is up by 5%");
        agent.setStockData("Stock is down by 3%");
    }
}
