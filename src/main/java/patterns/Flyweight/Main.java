package patterns.Flyweight;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Circle {
    private final String color;

    public Circle(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}

class CircleFactory {
    private static Map<String, Circle> circleMap = new HashMap<String, Circle>();

    public static Circle getCircle(String color) {
        Circle circle = circleMap.get(color);
        if ( circle == null) {
            circle = new Circle(color);
        }
        return circle;
    }
}

public class Main {
    public static void main(String args[]) {

        List<String> listOfColors = new ArrayList<String>();
        //Populate list of colors
        //.....

        for (String color : listOfColors) {
            Circle circle = CircleFactory.getCircle(color);
            //Use the circle
        }
    }
}
