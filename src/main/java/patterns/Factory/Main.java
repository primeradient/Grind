package patterns.Factory;

class Currancy {

}

class INR extends Currancy {

}

class USD extends Currancy {

}

class CurrancyCreator {
    public static Currancy getCurrancy(String type) {   //This is factory class
        if( type.equals("INR")) {
            return new INR();
        } else if ( type.equals("USD")) {
            return new USD();
        }
        return null;
    }
}

public class Main {

    public static void main(String args[]) {
        Currancy inr = CurrancyCreator.getCurrancy("INR");
    }
}
