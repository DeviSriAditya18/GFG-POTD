/*
You are given a special linked list where each node has a next pointer pointing to its next node. You are also given some random pointers, where you will be given some pairs denoting two nodes a and b i.e. a->random = b (random is a pointer to a random node).

Construct a copy of the given list. The copy should consist of the same number of new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the original and copied list pointers represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes x and y in the original list, where x->random = y, then for the corresponding two nodes xnew and ynew in the copied list, xnew->random = ynew.

Return the head of the copied linked list.

NOTE : 
1. If there is any node whose arbitrary pointer is not given then it's by default NULL. 
2. Don't make any changes to the original linked list.

Examples:

Input: LinkedList: 1->2->3->4->5 , pairs = [[1,3],[2,1],[3,5],[4,3],[5,2]]
Output: true
Explanation: 
Node 1 points to 2 as its NEXT and 3 as its RANDOM.
Node 2 points to 3 as its NEXT and 1 as its RANDOM.
Node 3 points to 4 as its NEXT and 5 as its RANDOM.
Node 4 points to 5 as its NEXT and 3 as its RANDOM.
Node 5 points to NULL as its NEXT and 2 as its RANDOM.

Input: LinkedList: 1->3->5->9 , pairs = [[1,1],[3,4]]
Output: true
Explanation: In the given testcase, applying the method as stated in the above example, the output will be true.
*/

class Solution {
    // Function to clone a linked list with next and random pointer.
    Node cloneLinkedList(Node head) {
        // your code here
        Node curr = head;
        while(curr!=null){
            Node temp = new Node(curr.data);
            Node x = curr.next;
            curr.next = temp;
            temp.next = x;
            curr=x;
        }
        
        for(Node x=head;x!=null && x.next!=null ;x=x.next.next){
            x.next.random = (x.random==null)? null : x.random.next;
        }

        Node h2 = head.next, clone=h2;
        for(Node a=head; a!=null ;a=a.next){
            a.next = a.next.next;
            clone.next = clone.next!=null ? clone.next.next : null;
            clone = clone.next;
        }
        return h2;
    }
}
