/*
*For a given binary tree, the boundary is the nodes located in an anticlockwise direction from the root to
* the left boundary,leaves and right boundary. The boundary of the given tree is 1 2 4 6 8 9 7 3
* Approach:

To solve this problem, we can break it down into the following three steps:

Print the left boundary in a top-down manner (To ensure the top-down order, print the node before calling it for the left subtree.).

Print all the leaf nodes from left to right.
Print the leaf nodes from left to right in the left subtree.
Print the leaf nodes from left to right in the right subtree.
Print the right boundary in a bottom-up manner (To ensure the bottom-up order, first call the right subtree and then print the node.).
Note that the bottommost node in the left boundary is also the leftmost node of the leaf nodes of the tree. Make sure that no node is printed twice.
*
*  */
public class BoundaryOfBinaryTree {
    Node root;

    void printLeaves(Node node)
    {
        /* complete the method*/
        if(node == null)
            return;
        printLeaves(node.left);
        if(node.left == null && node.right == null)
            System.out.print(node.data+" ");
        printLeaves(node.right);
    }

    void printBoundaryLeft(Node node)
    {
        /* complete the method*/
        if(node == null)
            return;
        if(node.left != null){
            System.out.print(node.data+" ");
            printBoundaryLeft(node.left);
        }
        else if(node.right != null){
            System.out.print(node.data+" ");
            printBoundaryLeft(node.right);
        }

    }


    void printBoundaryRight(Node node)
    {
        /* complete the method*/
        if(node == null)
            return;
        if(node.right != null){
            printBoundaryRight(node.right);
            System.out.print(node.data+" ");
        }
        else if(node.left != null){
            printBoundaryRight(node.left);
            System.out.print(node.data+" ");
        }

    }
    void printBoundary(Node node)
    {
        if (node == null)
            return;

        System.out.print(node.data + " ");

        printBoundaryLeft(node.left);

        printLeaves(node.left);
        printLeaves(node.right);

        printBoundaryRight(node.right);
    }
    public static void main(String[] args) {
        BoundaryOfBinaryTree tree = new BoundaryOfBinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(7);
        tree.root.left.right.left = new Node(6);
        tree.root.right.right.left = new Node(8);
        tree.root.right.right.right = new Node(9);
        tree.printBoundary(tree.root);
    }
}
class Node{
    int data;
    //char chardata;
    Node left,right;

    public Node(int data){
        this.data = data;
        left = right = null;
    }
}
