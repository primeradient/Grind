package patterns.Visitor;



interface Item {
    public float getCost();
}

class Coke implements Item {
    public float getCost() {
        return 1;
    }
}

class Pepsi implements Item {
    public float getCost() {
        return 2;
    }
}


interface Visitor {
    public float getCokeCost(Coke coke);
    public float getPepsiCost(Pepsi pepsi);
}


class Biller implements Visitor {
    public float getCokeCost(Coke coke) {
        return new Double(coke.getCost() * 0.95).floatValue();
    }

    public float getPepsiCost(Pepsi pepsi) {
        return new Double(pepsi.getCost() * 0.5).floatValue();
    }
}

public class Main {

    public static void main(String args[]) {
        Coke coke = new Coke();
        Pepsi pepsi = new Pepsi();

        Biller biller = new Biller();
        System.out.println("COKE : " + biller.getCokeCost(coke));
        System.out.println("PEPSI: " + biller.getPepsiCost(pepsi) );
    }
}
