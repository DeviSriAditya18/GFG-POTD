/*
Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

Examples:

Input: root[] = [1, 2, 3]
Output: 2
Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

Input: root[] = [5, 8, 6, 3, 7, 9]
Output: 4
Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).
*/

class Solution {
    int ans=Integer.MIN_VALUE;
    int diameter(Node root) {
        // Your code here
        if(root==null) return 0;
        solve(root);
        return ans;
    }
    int solve(Node root){
        if(root==null) return 0;
        int l=solve(root.left);
        int r=solve(root.right);
        ans=Math.max(ans,l+r);
        return 1+Math.max(l,r);
    }
}
