package BinaryTree;

public class BinaryTree {
    private Node root;

    public BinaryTree() {
        root = null;
    }
    
    public Boolean has(String value) {
        return hasIn(root, value);
    }
    
    public void insert(String value) {
        if(root == null)
            root = new Node(value);
        else
            insertIn(root, value);
    }

    private Boolean hasIn(Node node, String value) {
        if(node.value.equals(value)) return true;
        if(compStrings(value, node.value)) {
            if(node.right != null) {
                Boolean res = hasIn(node.right, value);
                if(res) return true;
            }
        } else {
            if(node.left != null) {
                Boolean res = hasIn(node.left, value);
                if(res) return true;
            }
        }
        return false;
    }

    private void insertIn(Node node, String value) {
        if(node.value == value) return;
        if(compStrings(value, node.value)) {
            if(node.right == null)
                node.right = new Node(value);
            else
                insertIn(node.right, value);
        } else {
            if(node.left == null)
                node.left = new Node(value);
            else
                insertIn(node.left, value);
        }
    }

    private Boolean compStrings(String str1, String str2) {
        if(str1 == str2) throw new Error("Strings are equal");
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if(ch1[i] > ch2[i]) return true;
            if(ch1[i] < ch2[i]) return false;
        }
        return str1.length() > str2.length();
    }
}
