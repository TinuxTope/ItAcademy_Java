package Tasca_S3_02.N1.Observable;

import Tasca_S3_02.N1.Observer.StockObserver;

public interface StockObservable {
    void addObserver(StockObserver observer);
    void removeObserver(StockObserver observer);
    void notifyObservers();
}
