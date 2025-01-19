/*
Given the head of two sorted linked lists consisting of nodes respectively. The task is to merge both lists and return the head of the sorted merged list.

Examples:

Input: head1 = 5 -> 10 -> 15 -> 40, head2 = 2 -> 3 -> 20
Output: 2 -> 3 -> 5 -> 10 -> 15 -> 20 -> 40

Input: head1 = 1 -> 1, head2 = 2 -> 4
Output: 1 -> 1 -> 2 -> 4
*/

class Solution {
    Node sortedMerge(Node head1, Node head2) {
        // code here
        Node dummy=new Node(-1);
        Node curr=dummy;
        while(head1!=null && head2!=null){
            if(head1.data<=head2.data){
                curr.next=head1;
                head1=head1.next;
            }
            else{
                curr.next=head2;
                head2=head2.next;
            }
            curr=curr.next;
        }
        if(head1!=null){
            curr.next=head1;
        }
        if(head2!=null){
            curr.next=head2;
        }
        return dummy.next;
    }
}
