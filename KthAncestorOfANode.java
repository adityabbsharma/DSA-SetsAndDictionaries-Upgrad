/*
* In a binary tree, we have to find the kth ancestor of a given node.
* The first ancestor of a node is its immediate parent node. For example, in the image given below,
* the first ancestor of the leaf node 8 is 4, the second ancestor of the leaf node 8 is 2 (2 being
* the first ancestor of node 4), and so on.
* Approach:

To find the kth ancestor of a node, a basic approach would be to locate the node and then backtrack to
* the kth ancestor/parent. We can use BFS (Breadth First Search) for that approach.

Steps:

Traverse the binary tree.
Store the ancestor of each node in an array of size n.
The way it would work is if we have an array parent[] and parent[i] contains the parent of i’th node.
* And if we were to find out the second ancestor, then it would be at parent[parent[i]], and so on.



To save the extra space used in the array, another approach could be using DFS (Depth First Search) recursively
* without using an array to store the parent node.

Steps:

Find the given node in the tree using DFS.
Backtrack k times to reach the kth ancestor.
Once you have reached the kth parent, you can simply print the node and return NULL
*
* A binary tree with nodes numbered 1 to n is given. A node and a positive integer K is also given.

Print the Kth ancestor of the given node in the binary tree. If such an ancestor does not exist print -1.

No extra array to be created.

Input
No input from stdin.

Output
The function you code must return node 2 for k=2 and node=8.

* */
public class KthAncestorOfANode {
    static class Node {
        int data;
        Node left, right;
    };
    static Node temp = null;
    static int k,kDash=0;
    static Node kthAncestorDFS(Node root, int node) {
        /* write code here */

        if(root==null)
            return null;
        if(root.data == node){
            k--;
            return root;
        }
        else{
            Node leftRoot = kthAncestorDFS(root.left,node);
            if(leftRoot!=null){
                if(k==0){
                    System.out.println(root.data);
                    return null;
                }
                k--;
                return root;
            }
            Node rightRoot = kthAncestorDFS(root.right,node);
            if(rightRoot!=null){
                if(k==0){
                    System.out.println(root.data);
                    return null;
                }
                k--;
                return root;
            }
        }
        return null;
    }
    static Node newNode(int data){
        Node temp = new Node();
        temp.data = data;
        temp.left = temp.right = null;
        return temp;
    }

    public static void main(String[] args) {
        Node root = newNode(1);
        root.left = newNode(2);
        root.right = newNode(3);
        root.left.left = newNode(4);
        root.left.left.left = newNode(7);
        root.left.left.right = newNode(8);
        root.left.right = newNode(5);
        root.right.right = newNode(6);
        root.right.right.left = newNode(9);
        k =2;
        int node = 8;
        Node parent = kthAncestorDFS(root,node);
        if(parent != null){
            System.out.println("-1");
        }
    }

}

