package patterns.Observer;

import java.util.Observable;
import java.util.Observer;


// Observable provides setChanged() and notifyObservers() APIs to facilitate change notification
class Stock extends Observable {

    private double price = 0.0;
    private final String stockName;

    public Stock(String name) {
        this.stockName = name;
    }

    public void updatePrice(double val) {
        this.price = val;


        setChanged();  //Value has changed
        notifyObservers();   //Notify Observers waiting for change
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return stockName;
    }
}

class Trader implements Observer {

    //Observer implements an update() API providing Observable object
    public void update(Observable o, Object arg) {
        Stock stock  = (Stock) o;
        System.out.println(stock.getName() + " price has changed to " + stock.getPrice());
    }
}


public class Main {

    public static void main(String args[]) {
        Stock myStock = new Stock("ABC");
        Trader trader = new Trader();


        myStock.addObserver(trader);   //Add a new Observer to this Observable Object
        myStock.updatePrice(100.0);


    }
}
