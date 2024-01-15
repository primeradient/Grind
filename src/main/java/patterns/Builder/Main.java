package patterns.Builder;

import java.util.ArrayList;
import java.util.List;

abstract class Item {
    public int getPrice() { return 0; } //FREE !!
}

abstract class Burger extends Item { }

abstract  class ColdDrink extends Item  { }

class VegBurger extends Burger {
    public int getPrice() { return 50; }
}

class NonVegBurger extends Burger {
    public int getPrice() { return 75; }
}

class Pepsi extends ColdDrink {
    public int getPrice() { return 10; }
}

class Coke extends ColdDrink {
    public int getPrice() { return 11; }
}

abstract class Meal {

    List<Item> items = new ArrayList<Item>();

    public void addItem(Item item) { }
    public int getPrice() {
        int total = 0;
        for (Item item : items ) {
            total += item.getPrice();
        }
        return total;
    }

}

class VegMeal extends Meal {
    public void addItem(Item item) {
        items.add(item);
    }
}

class NonVegMeal extends Meal {
    public void addItem(Item item) {
        items.add(item);
    }
}

class Builder {
    public static Meal createVegMeal() {
        Meal meal = new VegMeal();
        Item coke = new Coke();
        Item burger = new VegBurger();
        meal.addItem(coke);
        meal.addItem(burger);
        return meal;
    }

    public static Meal createNonVegMeal() {
        Meal meal = new NonVegMeal();
        Item coke = new Pepsi();
        Item burger = new NonVegBurger();
        meal.addItem(coke);
        meal.addItem(burger);
        return meal;
    }


}


public class Main {
    public static  void main(String args[]) {
        Builder builder = new Builder();
        Meal veg = builder.createVegMeal();
        Meal nonVeg = builder.createNonVegMeal();

        System.out.println("Veg Meal Price: " + veg.getPrice());
        System.out.println("Non-Veg Meal Price: " + nonVeg.getPrice());
    }

}
