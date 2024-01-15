package patterns.ChainOfResponsibility;


abstract class LOGGER {
    public static int INFO = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    private LOGGER nextLogger;

    private int level = 0;

    abstract public void writeLog(String msg);

    public LOGGER(int level) {
        this.level = level;
    }

    public void processLog(int level, String msg) {
        if ( level > this.level) {
            if ( nextLogger != null ) {
                nextLogger.processLog(level, msg);
            }
        } else {
            writeLog(msg);
        }
    }

    public void setNextLogger(LOGGER logger) {
        this.nextLogger = logger;
    }

}



class INFO extends LOGGER {
    public INFO(int level) {
        super(level);
    }

    public void writeLog(String msg) {
        System.out.println("INFO: " + msg);
    }
}

class DEBUG extends LOGGER {
    public DEBUG(int level) {
        super(level);
    }

    public void writeLog(String msg) {
        System.out.println("DEBUG: " + msg);
    }
}


class ERROR extends LOGGER {
    public ERROR(int level) {
        super(level);
    }

    public void writeLog(String msg) {
        System.out.println("ERROR: " + msg);
    }
}

public class Main {
    public static void main(String args[]) {
        LOGGER info = new INFO(LOGGER.INFO);

        LOGGER debug = new DEBUG(LOGGER.DEBUG);
        info.setNextLogger(debug);

        LOGGER error = new ERROR(LOGGER.ERROR);
        debug.setNextLogger(error);

        info.processLog(LOGGER.ERROR, "This is error started at info");
    }

}
