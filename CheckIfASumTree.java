/*
* Sum Tree
Description
Given a binary tree, check if it’s a SumTree or not.



Input
No input from stdin.



Output
The function you code must return an int which should be the sum if it is a sum tree else it should return Integer.MIN_VALUE
* A Binary Tree in which the value of a node is equal to the sum of the nodes present in its left and right subtrees is called a SumTree. An empty tree is also a SumTree, and the sum is considered as 0. A leaf node is also a SumTree with the sum as the value of the node.
*                           24
*                   5               7
*               2       3       6       1
*Every node in the tree is a sum of all the nodes in its left and right subtrees. In the given binary tree, node 24 is the sum of nodes 5, 7, 2, 3, 6 and 1. Similarly, node 5 is the sum of nodes 2 and 3, and node 7 is the sum of nodes 6 and 1.


Approach:

This problem can be easily solved using a recursive approach. Traverse the tree in postorder fashion (left subtree, right subtree and then root node). Now, for each non-leaf node, check whether the node’s value is equal to the sum of all the nodes in the left and right subtrees. If this check fails at any node, then the tree is not a SumTree.
* CheckIfASumTree
* */
public class CheckIfASumTree {
    public static int isSumTree(Node root){
        if(root==null)
            return 0;
//        if(root.left==null && root.right == null){
//            System.out.println("Inside base cndn and root.key="+root.key);
//            return root.key;
//        }

//        System.out.println("root.key="+root.key);
        return root.key== root.key+ (isSumTree(root.left)+ isSumTree(root.right))? root.key : Integer.MIN_VALUE;

    }

    public static void main(String[] args) {
        Node root = new Node(24);
        root.left = new Node(5);
        root.right = new Node(7);
        root.left.left = new Node(2);
        root.left.right = new Node(3);
        root.right.left = new Node(6);
        root.right.right = new Node(1);
        if(isSumTree(root) != Integer.MIN_VALUE ){
            System.out.println("Yes");
        }else{
            System.out.println("No");
        }
    }
}
class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}
