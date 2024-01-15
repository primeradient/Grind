package patterns.Composite;

import java.util.ArrayList;
import java.util.List;

class Node {
    String fileName;
    List<Node> childrens = null;

    public Node(String name) {
        this.fileName = name;
        childrens = new ArrayList<Node>();
    }
}

public class Main {

    public static void printNode(Node node, String parentPath ) {
        if ( node == null ) {
            return;
        }

        String fileName = parentPath + node.fileName;
        System.out.println(fileName);
        if ( node.childrens == null ) {
            return;
        }

        for (Node child : node.childrens) {
            printNode(child, fileName);
        }
    }

    public static void main(String args[]) {
        Node base = new Node("/");
        Node etc = new Node("etc");
        Node usr = new Node("usr");
        Node bin = new Node("/bin");

        base.childrens.add(etc);
        base.childrens.add(usr);
        usr.childrens.add(bin);

        printNode(base,"");

        /* OUTPUT
            /
            /etc
            /usr
            /usr/bin
        */


    }

}
