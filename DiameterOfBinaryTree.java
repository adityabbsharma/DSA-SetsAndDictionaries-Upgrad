/*
The diameter of a tree is the number of nodes on the longest path between two end nodes.
The largest of the following quantities is the diameter of the tree T:

the diameter of T’s left subtree
the diameter of T’s right subtree
the longest path between leaves that go through the root of T (which can be computed from the heights of the subtrees of T)


Approach:

The following steps can be used to solve the problem:

Calculate the height and the diameter of left and right subtrees.
Calculate the longest path between the end nodes of the left and right subtrees, which is equal to the height of the left subtree + the height of the right subtree + 1(root).
The maximum of these three values would be the diameter of the tree.


 */

public class DiameterOfBinaryTree {
    Node root;

    // Method to calculate the diameter and return it to
    // main
    int diameter(Node root) {
        /* write code here */
        if(root==null)
            return 0;
        int lHeight = height(root.left);
        int rHeight = height(root.right);
        int lDiameter = diameter(root.left);
        int rDiameter = diameter(root.right);
        return Math.max(lHeight+rHeight+1 , Math.max(lDiameter,rDiameter));
    }

    int diameter() {
        return diameter(root);
    }
    static int height(Node node){
        if(node == null)
            return 0;
        return 1+Math.max(height(node.left),height(node.right));
    }
    public static void main(String[] args) {
        DiameterOfBinaryTree tree = new DiameterOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.left.right.left = new Node(8);
        tree.root.left.right.right = new Node(9);
        tree.root.right.right.left = new Node(10);
        tree.root.right.right.right = new Node(11);
        tree.root.left.right.left.right = new Node(12);
        tree.root.right.right.left.left = new Node(13);
        tree.root.right.right.right.left = new Node(14);
        tree.root.right.right.right.left.right = new Node(15);

        System.out.println("The diameter of given binary tree is: "+tree.diameter());

    }
}
class Node{
    int data;
    char chardata;
    Node left,right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}