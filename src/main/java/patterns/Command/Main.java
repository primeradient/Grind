package patterns.Command;


class Light {

    public void switchON() {
        System.out.println("Switched On Light");
    }
}

interface Command {
    public void execute();
}

class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.switchON();
    }

}

class Switch {
    private final LightOnCommand lightOnCommand;

    public Switch(LightOnCommand command) {
        this.lightOnCommand = command;
    }

    public void ON() {
        lightOnCommand.execute();
    }
}


public class Main {

    public static void main(String args[]) {
        Light light = new Light();
        LightOnCommand command = new LightOnCommand(light);
        Switch _switch = new Switch(command);

        _switch.ON();
    }
}
