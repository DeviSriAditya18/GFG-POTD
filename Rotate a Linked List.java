/*
Given the head of a singly linked list, your task is to left rotate the linked list k times.

Examples:

Input: head = 10 -> 20 -> 30 -> 40 -> 50, k = 4
Output: 50 -> 10 -> 20 -> 30 -> 40
Explanation:
Rotate 1: 20 -> 30 -> 40 -> 50 -> 10
Rotate 2: 30 -> 40 -> 50 -> 10 -> 20
Rotate 3: 40 -> 50 -> 10 -> 20 -> 30
Rotate 4: 50 -> 10 -> 20 -> 30 -> 40

Input: head = 10 -> 20 -> 30 -> 40 , k = 6
Output: 30 -> 40 -> 10 -> 20 

*/

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        if(head.next == null || k == 0)   return head;
        
        Node temp = head, curr, prev, end;
        int n = 1;
        while(temp.next != null){
            temp = temp.next;
            n++;
        }
        end = temp;
        temp.next = head;
    
        k = k % n;
        
        curr = head;
        prev = null;
        
        if(k == 0){
            end.next = null;
            return curr;
        }
        while(k > 0){
            prev = curr;
            curr = curr.next;
            k--;
        }
        prev.next = null;
        return curr;
    }
}