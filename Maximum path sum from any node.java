/*
Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

Examples:

Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
Output: 42
Explanation: 
Max path sum is represented using green colour nodes in the above binary tree.

Input: root[] = [-17, 11, 4, 20, -2, 10]
Output: 31
Explanation: 
Max path sum is represented using green colour nodes in the above binary tree. 
*/

class Solution {
    // Function to return maximum path sum from any node in a tree.
    int ans;
    int findMaxSum(Node node) {
        // your code goes here
        ans=Integer.MIN_VALUE;
        find(node);
        return ans;
    }
    int find(Node node){
        if(node==null) return 0;
        int l=Math.max(find(node.left),0);
        int r=Math.max(find(node.right),0);
        ans=Math.max(ans,l+r+node.data);
        return node.data+Math.max(l,r);
    }
}
