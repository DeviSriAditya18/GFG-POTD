/*
Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

Examples:

Input: k = 7   
Output: 3
Explanation: The following paths sum to k 
 
Input: k = 3
   1
  /  \
2     3
Output: 2
Explanation:
Path 1 : 1 -> 2 (Sum = 3)
Path 2 : 3 (Sum = 3) 
*/

class Solution {
    int ans=0;
    public int sumK(Node root, int k) {
        // code here
        if(root==null) return 0;
        ArrayList<Integer> l=new ArrayList<>();
        find(root,k,l);
        return ans;
    }
    public void find(Node root,int k,ArrayList<Integer> l){
        if(root==null) return;
        l.add(root.data);
        int t=0;
        for(int i=l.size()-1;i>=0;i--){
            t+=l.get(i);
            if(t==k) ans++;
        }
        find(root.left,k,l);
        find(root.right,k,l);
        l.remove(l.size()-1);
    }
}