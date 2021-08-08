/*
*Spiral Level-Order Traversal
Description
Consider the binary tree given below. You are required to print the spiral level-order traversal for it.

Image 5-01.jpg 97.24 KB

﻿Output:

1 2 3 5 4



Input:

The input will be in the following format:

The first line should be the number ‘n’. Here, the number ‘n’ is the total number of nodes present in the binary tree.
The second line contains space-separated ‘n’ values. This is the level-order traversal of the tree. The code for inserting the values in the tree for the given level-order traversal has been addressed in the code.


Output:

The output should be the spiral level-order traversal of the tree with the nodes separated by spaces.



Sample Input:

5

1 2 3 4 5

Sample Output:

1 2 3 5 4



Sample Input:

4

8 2 5 6

Sample Output:

8 2 5 6
* */
import java.util.*;
public class SpiralLevelOrderTraversal {
    public static void main(String[] x) {
        Tree tree = new Tree();

        int size;
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        if (size < 0){
            System.out.println("Size should be a positive integer");
        }

        else{
            int[] elementsArr = new int[size];
            for(int i = 0; i < size; i++) {
                elementsArr[i] = sc.nextInt();
            }

            tree.root = tree.insertNode(elementsArr, tree.root, 0);

            tree.spiralOrder();
        }
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

class Tree {
    Node root;

    Tree() {
        root = null;
    }

    // Method to construct a binary tree from the given array
    public Node insertNode(int[] elementsArr, Node node, int i) {
        if(i < elementsArr.length){
            node = new Node(elementsArr[i]);
            node.left = insertNode(elementsArr,node.left,2 * i + 1);
            node.right = insertNode(elementsArr,node.right,2 * i + 2);
        }
        return node;
    }

    // Method to traverse the elements of a tree using BFS (level-order traversal) in the spiral order
    void spiralOrder() {
        // Write your code here
        Node rootNode = this.root;
        int flag=1; // 1 means go left, 2 means go right
        Queue<Node> queue = new LinkedList<>();
        queue.add(rootNode);
        while(!queue.isEmpty()){
            if(flag == 1){
                flag =2;
                Node temp = queue.peek();
                queue.remove();
                System.out.print(temp.data+" ");
                if(temp.left !=null)
                    queue.add(temp.left);
                if(temp.right !=null)
                    queue.add(temp.right);
            }
            else{
                flag =1;
                Node temp = queue.peek();
                queue.remove();
                System.out.print(temp.data+" ");
                if(temp.right !=null)
                    queue.add(temp.right);
                if(temp.left !=null)
                    queue.add(temp.left);
            }
        }
    }

}


