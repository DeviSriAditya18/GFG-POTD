/*
Given a Binary Tree, you need to find all the possible paths from the root node to all the leaf nodes of the binary tree.

Note: The paths should be returned such that paths from the left subtree of any node are listed first, followed by paths from the right subtree.

Examples:

Input: root[] = [1, 2, 3, 4, 5, N, N]
ex-3
Output: [[1, 2, 4], [1, 2, 5], [1, 3]]
Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 -> 4, 1 -> 2 -> 5 and 1 -> 3

Input: root[] = [1, 2, 3]
Output: [[1, 2], [1, 3]] 
Explanation: All the possible paths from root node to leaf nodes are: 1 -> 2 and 1 -> 3

Input: root[] = [10, 20, 30, 40, 60, N, N]
Output: [[10, 20, 40], [10, 20, 60], [10, 30]]
Explanation: All the possible paths from root node to leaf nodes are: 10 -> 20 -> 40, 10 -> 20 -> 60 and 10 -> 30
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        solve(root, ans, new ArrayList<>());
        return ans;
    }
    private static void solve(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> a){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            a.add(root.data);
            ans.add(new ArrayList<>(a));
            a.remove(a.size()-1);
            return;
        }
        a.add(root.data);
        solve(root.left,ans,a);
        solve(root.right,ans,a);
        a.remove(a.size()-1);
    }
}
