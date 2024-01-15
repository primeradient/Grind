package patterns.Singelton;

import java.util.Date;


class MyClass {
    private String val;

    public MyClass(String val) {
        this.val = val;
    }

    public String getName() {
        return this.val;
    }
}

public class DoubleLock {

    static MyClass myClass = null;


    public static MyClass getInstance() {
        if (myClass == null) {
            synchronized (MyClass.class) {
                if (myClass == null)
                    myClass = new MyClass("MyClass-" + new Date().toString());
            }
        }
        return myClass;
    }

    public static void main(String args[]) throws Exception {
        MyClass myClass = getInstance();

        System.out.println(myClass.getName());

        MyClass sameClass = getInstance();
        Thread.sleep(1000);
        System.out.println(sameClass.getName());  //Will print same name

    }

}
