package BinaryTree;

public class Node {
    public String value;
    public Node left;
    public Node right;

    public Node() {
        value = null;
        left = null;
        right = null;
    }

    public Node(String value) {
        this();
        this.value = value;
    }
}
