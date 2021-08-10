/*
* For a given binary tree, the problem requires that it should be printed in vertical order.
*                           9
*                   5               7
*               2       1        3      8
*                                   6       12
*
* For instance, in the binary tree given above, the order in which it should be printed will
* follow the vertical lines from left to right, which would be as follows:

2

5

9 1 3

7 6

8

12
*
*
 * */
import java.util.*;
public class BinaryTreeInVerticalOrder {
    // 'horizontalDistance' is initially passed as 0
    static void getVerticalOrder(Node root, int horizontalDistance, TreeMap<Integer, Vector<Integer>> m) {
        /* complete the method*/
        //base case
        if (root == null)
            return;
        //get the vector list at 'horizontal distance'

        Vector<Integer> vector = new Vector<>();
        // Store current node in map 'm'
        if(m.containsKey(horizontalDistance)){
            vector = m.get(horizontalDistance);
        }
        vector.add(root.data);
        m.put(horizontalDistance,vector);
        // Store nodes in left subtree
        getVerticalOrder(root.left,horizontalDistance-1,m);
        // Store nodes in right subtree
        getVerticalOrder(root.right,horizontalDistance+1,m);
    }
    static void printVerticalOrder(Node root){
        TreeMap<Integer,Vector<Integer>> m = new TreeMap<>();
        int hd = 0;
        getVerticalOrder(root,hd,m);
        for(Map.Entry<Integer,Vector<Integer>> entry : m.entrySet()){
            System.out.println(entry.getValue());
        }
    }
    public static void main(String[] args) {
        Node root = new Node(9);
        root.left = new Node(5);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(1);
        root.right.left = new Node(3);
        root.right.right = new Node(8);
        root.right.left.right = new Node(6);
        root.right.right.right = new Node(12);
        System.out.println("Vertical Order traversal is");
        printVerticalOrder(root);
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
