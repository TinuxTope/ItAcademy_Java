package Tasca_S3_02.N1.Observable;

import Tasca_S3_02.N1.Observer.StockObserver;

import java.util.ArrayList;
import java.util.List;

public class StockAgent implements StockObservable {
    private List<StockObserver> observers;
    private String stockData;

    public StockAgent() {
        this.observers = new ArrayList<>();
    }

    public void addObserver(StockObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(StockObserver observer) {
        observers.remove(observer);
    }

    public void setStockData(String stockData) {
        this.stockData = stockData;
        notifyObservers();
    }

    public void notifyObservers() {
        for (StockObserver observer : observers) {
            observer.update(stockData);
        }
    }
}
