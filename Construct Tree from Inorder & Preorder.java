/*
Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

Note: The output is written in postorder traversal.

Examples:

Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
Output: [8, 7, 6, 1]
Explanation: The tree will look like

Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
Output: [3, 4, 1, 5, 2, 0]
Explanation: The tree will look like

Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
Output: [2, 5, 4, 3, 1]
Explanation: The tree will look like
*/

class Solution {
    public static Node buildTree(int inorder[], int preorder[]) {
        // code here
        HashMap<Integer, Integer> h=new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            h.put(inorder[i],i);
        }
        return split(inorder,0,inorder.length-1,preorder,0,h);
    }
    public static Node split(int inorder[],int is,int ie, int preorder[], int ind, HashMap<Integer,Integer> h){
        Node root=new Node(preorder[ind]);
        int m=h.get(root.data);
        if(m>is) root.left=split(inorder,is,m-1,preorder,ind+1,h);
        if(m<ie) root.right=split(inorder,m+1,ie,preorder,ind+m-is+1,h);
        return root;
    }
}
