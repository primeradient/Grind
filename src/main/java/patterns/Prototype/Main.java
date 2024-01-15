package patterns.Prototype;


class MyObject implements Cloneable{

    private String name;

    public MyObject(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public Object clone() throws CloneNotSupportedException{
        return new MyObject(this.name);
    }

}

public class Main {

    public static void main(String args[]) throws Exception {

        MyObject obj = new MyObject("123");

        MyObject newObj = (MyObject) obj.clone();
    }

}