package patterns.Singelton;


enum MySingelton {
    SOME_INSTANCE; //Specificy only and only one type


    MySingelton() {
        System.out.println("2. Object Created");
    }

    public void doSomething() {
        System.out.println("3. We are doing some Operation");
    }


    public void doSomethingElse() {
        System.out.println("4. We are doing some Other Operation");
    }

}

public class EnumBased {

    public static void main(String args[]) {
        System.out.println("1. Main Started");
        MySingelton.SOME_INSTANCE.doSomething();

        MySingelton.SOME_INSTANCE.doSomething();

        MySingelton.SOME_INSTANCE.doSomethingElse();

    }

}
