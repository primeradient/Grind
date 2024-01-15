package patterns.Proxy;


interface Connection {
    public boolean grantAccess();
}

class ReadConnection implements Connection {
    public boolean grantAccess() {
        //This should do some operation and grant use with access.
        System.out.println("Access granted");
        return true;
    }
}

class ProxyConnection implements Connection {
    private Connection realConnection = null;

    private final String userName;
    public ProxyConnection(String userName) {
        this.userName = userName;
    }

    public boolean grantAccess() {
        if ( this.userName.equals("Administrator")) {
            realConnection = new ReadConnection();
            return realConnection.grantAccess();
        } else {
            System.out.println("Access Denied");
        }
        return false;
    }
}

public class Main {
    public static void main(String args[]) {
        ProxyConnection proxyConnection = new ProxyConnection("Administrator");
        proxyConnection.grantAccess();
    }
}
