/*
Given a BST and an integer k, the task is to find the kth smallest element in the BST. If there is no kth smallest element present then return -1.

Examples:

Input: root = [2, 1, 3], k = 2
Output: 2
Explanation: 2 is the 2nd smallest element in the BST.

Input: root = [2, 1, 3], k = 5
Output: -1
Explanation: There is no 5th smallest element in the BST as the size of BST is 3.

Input: root = [20, 8, 22, 4, 12, N, N, N, N, 10, 14], k = 3  
Output: 10
Explanation: 10 is the 3rd smallest element in the BST. 
*/

class Solution {
    // Return the Kth smallest element in the given BST
    public int kthSmallest(Node root, int k) {
        // Write your code here
        int ans[]={-1};
        solve(root,new int[]{k},ans);
        return ans[0];
    }
    void solve(Node root,int k[],int ans[]){
        if(root==null) return;
        if(k[0]==0){
            ans[0]=root.data;
            return;
        }
        solve(root.left,k,ans);
        k[0]--;
        if(k[0]==0){
            ans[0]=root.data;
            return;
        }
        solve(root.right,k,ans);
    }
}