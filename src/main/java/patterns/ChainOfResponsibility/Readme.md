<h1>Chain of Responsibility Pattern</h2>
<b>Type: </b> Behavioural Pattern<br>


<ul>
<li>A Command Object is passed along a series of processing objects.
<li>Object which is fit to handle the command object intercepts and executes on the command.
<li>Example: Logging Levels such as INFO, ERROR, DEBUG and so on
    <ul>
    <li>Each of log level object has a next processing object which can execute/pass-along input if current object is not able to execute.
    </ul>
</ul>

<pre>
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
    <b>
    public void processLog(int level, String msg) {
        if ( level > this.level) {
            if ( nextLogger != null ) {
                nextLogger.processLog(level, msg);
            }
        } else {
            writeLog(msg);
        }
    }
    </b>

    public void setNextLogger(LOGGER logger) {
        this.nextLogger = logger;
    }

}
</pre>




