/*
You are given the head of a linked list. You have to replace all the values of the nodes with the nearest prime number. If more than one prime number exists at an equal distance, choose the smallest one. Return the head of the modified linked list.

Examples :

Input: head = 2 → 6 → 10
Output: 2 → 5 → 11
Explanation: The nearest prime of 2 is 2 itself. The nearest primes of 6 are 5 and 7, since 5 is smaller so, 5 will be chosen. The nearest prime of 10 is 11.

Input: head = 1 → 15 → 20
Output: 2 → 13 → 19
Explanation: The nearest prime of 1 is 2. The nearest primes of 15 are 13 and 17, since 13 is smaller so, 13 will be chosen. The nearest prime of 20 is 19.
*/

class Solution {
    boolean isPrime(int n){
        boolean f=true;
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                f=false;
                break;
            }
        }
        return f;
    }
    Node primeList(Node head) {
        // code here
        Node curr=head;
        Node node=new Node(1);
        Node ptr=node;
        while(curr!=null){
            int n=curr.val;
            int left=n-1;
            int right=n+1;
            if(n==1){
                Node t=new Node(2);
                ptr.next=t;
                ptr=t;
            }
            else if(isPrime(n)){
                Node t=new Node(n);
                ptr.next=t;
                ptr=t;
            }
            else{
                while(left>=2 && n<right){
                    if(isPrime(left)){
                        Node t=new Node(left);
                        ptr.next=t;
                        ptr=t;
                        break;
                    }
                    else if(isPrime(right)){
                        Node t=new Node(right);
                        ptr.next=t;
                        ptr=t;
                        break;
                    }
                    left--;
                    right++;
                }
            }
            curr=curr.next;
        }
        return node.next;
    }
}
