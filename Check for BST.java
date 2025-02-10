/*
Given the root of a binary tree. Check whether it is a BST or not.
Note: We are considering that BSTs can not contain duplicate Nodes.
A BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Examples:

Input: root = [2, 1, 3, N, N, N, 5]
Output: true 
Explanation: The left subtree of every node contains smaller keys and right subtree of every node contains greater keys. Hence, the tree is a BST.

Input: root = [2, N, 7, N, 6, N, 9] 
Output: false 
Explanation: Since the node to the right of node with key 7 has lesser key value, hence it is not a valid BST.

Input: root = [10, 5, 20, N, N, 9, 25]
Output: false
Explanation: The node with key 9 present in the right subtree has lesser key value than root node.
*/

class Solution {
    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // code here.
        int max=Integer.MAX_VALUE;
        int min=Integer.MIN_VALUE;
        return bst(root,min,max);
    }
    public static boolean bst(Node root,int min,int max){
        if(root == null) return true;
        if(root.data<=min || root.data>=max) return false;
        return bst(root.left,min,root.data)&&bst(root.right,root.data,max);
    }
}