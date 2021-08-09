import java.util.HashSet;

/*
* Duplicate Values in Binary Tree
* A binary tree that has nodes with the same values has to be identified.
* The idea is to traverse the tree and keep a check on the values that appear as we traverse the tree. While traversing the tree, at any point, we need to identify whether or not that value has already appeared.


Approach:

A direct solution is to store inorder traversal of a given binary tree in an array, and then, check whether the array has duplicates or not.

However, to be more efficient in our approach, we can avoid the multiple steps required in first traversing and then identifying duplicates from the array. The problem can be solved in O(n) time by using hashing.

Steps:

Traverse the given tree.
For every node, check whether it already exists in the hash table.
If it exists, then return true (found duplicate).
If it does not exist, then insert it into the hash table.
* Description
Check if the given Binary Tree (which is not a Binary Search Tree) has duplicate values.

Complete the function checkDuplicate.
Input
No input from stdin.
Output
The function you code must return a boolean true if the binary tree contains a duplicate else false.
* */
public class DuplicateValuesInABinaryTree {
    public static boolean checkDuplicate(Node root, HashSet<Integer> s){
        if(root==null)
            return false;
        if(s.contains(root.key))
            return false;
        checkDuplicate(root.left,s);
            s.add(root.key);
        checkDuplicate(root.right,s);
        return true;
    }
    public static boolean checkDup(Node root){
        HashSet<Integer> s = new HashSet<>();
        return checkDuplicate(root,s);
    }

    public static void main(String[] args) {
        Node root = new Node(4);
        root.left = new Node(7);
        root.right = new Node(12);
        root.left.left = new Node(3);
        root.right.right = new Node(7);
        if(checkDup(root))
            System.out.print("Yes");
        else
            System.out.println("No");
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
