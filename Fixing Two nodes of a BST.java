/*
Given the root of a Binary search tree(BST), where exactly two nodes were swapped by mistake. Your task is to fix (or correct) the BST by swapping them back. Do not change the structure of the tree.
Note: It is guaranteed that the given input will form BST, except for 2 nodes that will be wrong. All changes must be reflected in the original linked list.
 
Examples :
Input: root = [10, 5, 8, 2, 20]
Output: 1
Explanation: The nodes 20 and 8 were swapped.    

Input: root = [5, 10, 20, 2, 8]   
Output: 1 
Explanation: The nodes 10 and 5 were swapped.
*/

class Solution {
    private Node prev;
    private Node first;
    private Node middle;    
    private Node last;  
     
    void in_order(Node root){
        if(root == null) return;
        
        in_order(root.left);
        
        if(prev!=null && root.data<prev.data){
            
            if(first == null){
                first = prev;
                middle = root;
            }
            
            else last = root;
        }
        
        prev = root;
        
        in_order(root.right);
        
    }

    void correctBST(Node root) {
        // code here.
        first=middle=last=null;
        prev = new Node(Integer.MIN_VALUE);
        
        in_order(root);
        
        if(last==null) 
        {int temp = first.data;
        first.data = middle.data;
        middle.data = temp;
        return;
        }
       int temp = first.data;
        first.data = last.data;
        last.data = temp;
        return;
    }
}