/*
Given the head of two singly linked lists num1 and num2 representing two non-negative integers. The task is to return the head of the linked list representing the sum of these two numbers.

For example, num1 represented by the linked list : 1 -> 9 -> 0, similarly num2 represented by the linked list: 2 -> 5. Sum of these two numbers is represented by 2 -> 1 -> 5.

Note: There can be leading zeros in the input lists, but there should not be any leading zeros in the output list.

Examples:

Input: num1 = 4 - > 5, num2 = 3 -> 4 -> 5
Output:  3 -> 9 -> 0
 
Explanation: Given numbers are 45 and 345. There sum is 390.

Input: num1 = 0 -> 0 -> 6 -> 3, num2 = 0 -> 7 
Output: 7 -> 0 
 
Explanation: Given numbers are 63 and 7. There sum is 70.
*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        num1 = trimLeadingZeros(num1);
        num2 = trimLeadingZeros(num2);
        Node head1 = reverseList(num1), head2 = reverseList(num2), 
            head=null, curr=null, curr1=head1, curr2=head2;
        int carry = 0;
        while(curr1!=null || curr2!=null || carry > 0){
            int sum = carry;
            if(curr1 != null){
                sum += curr1.data;
                curr1 = curr1.next;
            }

            if(curr2 != null){
                sum += curr2.data;
                curr2 = curr2.next;
            }
            
            carry = sum/10;
            sum %= 10;
            
            if(head == null){
                head = new Node(sum);
                curr = head;
            } else {
                curr.next = new Node(sum);
                curr = curr.next;
            }
        }
        return reverseList(head);
    }
    
    static Node reverseList(Node head) {
        Node prev=null, curr=head, next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    // Function to trim leading zeros in linked list
    static Node trimLeadingZeros(Node head) {
        while (head != null && head.data == 0) {
            head = head.next;
        }
        return head;
    }
}