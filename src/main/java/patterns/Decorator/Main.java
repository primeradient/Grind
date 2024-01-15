package patterns.Decorator;

abstract class Beverage {
    public abstract int getCost();
}

class Milk extends Beverage {
    public int getCost() {
        return 1;
    }
}

abstract class Decorator extends Beverage { }

class FlavoredMilk extends Decorator {
    Beverage beverage = null;

    public FlavoredMilk(Beverage beverage) {
        this.beverage = beverage;
    }

    public int getCost() {
        return beverage.getCost() + 1;
    }
}


public class Main {

    public static void main(String args[]) {

        Beverage beverage = new Milk();
        FlavoredMilk flavoredMilk = new FlavoredMilk(beverage);

        System.out.println(flavoredMilk.getCost());
    }

}
