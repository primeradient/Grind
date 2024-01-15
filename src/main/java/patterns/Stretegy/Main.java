package patterns.Stretegy;

abstract class Strategy {
    protected int a;
    protected int b;

    public Strategy(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public abstract void execute();
}

class ADD extends Strategy {
    public ADD(int a,int b) {
        super(a,b);
    }

    public void execute() {
        System.out.println(a+b);
    }
}

class SUB extends Strategy {
    public SUB(int a,int b) {
        super(a,b);
    }

    public void execute() {
        System.out.println(a-b);
    }
}



class Context {
    public void execute(Strategy strategy) {
        strategy.execute();
    }
}


public class Main {
    public static void main(String args[]) {
        Context context = new Context();

        context.execute(new ADD(5,6));

        context.execute(new SUB(5,6));
    }
}
