/*
* Symmetric Tree
Description
Check whether a given tree is a mirror image of itself and symmetric about its root node.

Input
No input from stdin.

Output
The function you code must return a boolean true if the tree is a mirror image of itself.
* Otherwise, it must return false.

* */
public class SymmetricTree {
    Node root;
    boolean isMirror(Node node1, Node node2)
    {
        /* Write your code here */
        if(node1 == null && node2 == null){
            return true;
        }
        if(node1==null || node2==null){
            return false;
        }
        return node1.data == node2.data && isMirror(node1.left,node2.right) && isMirror(node1.right,node2.left);

    }
    public static void main(String args[])
    {
        SymmetricTree tree = new SymmetricTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(2);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
        boolean output = tree.isMirror(tree.root, tree.root);
        if (output == true)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
class Node {
    int data;
    Node left, right;

    Node(int value) {
        data = value;
        left = right = null;
    }
}
