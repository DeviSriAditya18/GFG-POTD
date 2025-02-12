/*
Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

Examples:

Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
       bst
Output: True
Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.

Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
          bst-3
Output: False
Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.
*/

class Solution {
    int ans=0;
    boolean findTarget(Node root, int target) {
        // Write your code here
        HashSet<Integer> h=new HashSet<>();
        solve(root,h,target);
        if(ans>0) return true;
        return false;
    }
    public void solve(Node root, HashSet<Integer> h,int t){
        if(root==null) return;
        solve(root.left,h,t);
        if(h.contains(t-root.data)){
            ans=1;
            return;
        }
        h.add(root.data);
        solve(root.right,h,t);
    }
}