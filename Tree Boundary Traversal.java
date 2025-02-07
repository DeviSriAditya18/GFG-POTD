/*
Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order: 

Left Boundary: This includes all the nodes on the path from the root to the leftmost leaf node. You must prefer the left child over the right child when traversing. Do not include leaf nodes in this section.

Leaf Nodes: All leaf nodes, in left-to-right order, that are not part of the left or right boundary.

Reverse Right Boundary: This includes all the nodes on the path from the rightmost leaf node to the root, traversed in reverse order. You must prefer the right child over the left child when traversing. Do not include the root in this section if it was already included in the left boundary.

Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary. 

Examples:

Input: root[] = [1, 2, 3, 4, 5, 6, 7, N, N, 8, 9, N, N, N, N] 
        1 
      /   \
     2     3  
    / \   / \ 
   4   5 6   7
      / \
     8   9
   
Output: [1, 2, 4, 8, 9, 6, 7, 3]

Input: root[] = [1, 2, N, 4, 9, 6, 5, N, 3, N, N, N, N 7, 8] 
            1
           /
          2
        /  \
       4    9
     /  \    \
    6    5    3
             /  \
            7     8

Output: [1, 2, 4, 6, 5, 7, 8]
Explanation:
As the root doesn't have a right subtree, the right boundary is not included in the traversal.

Input: root[] = [1, N, 2, N, 3, N, 4, N, N] 
    1
     \
      2
       \
        3
         \
          4

Output: [1, 4, 3, 2]
Explanation:
Left boundary: [1] (as there is no left subtree)
Leaf nodes: [4]
Right boundary: [3, 2] (in reverse order)
Final traversal: [1, 4, 3, 2] 
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(node==null) return null;
        if(!leaf(node)) ans.add(node.data);
        left(node,ans);
        add(node,ans);
        right(node,ans);
        return ans;
    }
    public static boolean leaf(Node node){
        return (node.left==null && node.right==null);
    }
    void left(Node root,ArrayList<Integer> ans){
        Node curr=root.left;
        while(curr!=null){
            if(!leaf(curr)) ans.add(curr.data);
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    void right(Node root,ArrayList<Integer> ans){
        Node curr=root.right;
        Stack<Integer> s=new Stack<>();
        while(curr!=null){
            if(!leaf(curr)) s.push(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
        }
        while(!s.isEmpty()) ans.add(s.pop());
    }
    void add(Node root, ArrayList<Integer> ans){
        if(root==null) return;
        if(leaf(root)) ans.add(root.data);
        else{
            add(root.left,ans);
            add(root.right,ans);
        }
    }
}
