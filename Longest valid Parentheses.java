/*
Given a string s consisting of opening and closing parenthesis '(' and ')'. Find the length of the longest valid parenthesis substring.

A parenthesis string is valid if:

For every opening parenthesis, there is a closing parenthesis.
The closing parenthesis must be after its opening parenthesis.
Examples :

Input: s = "((()"
Output: 2
Explanation: The longest valid parenthesis substring is "()".

Input: s = ")()())"
Output: 4
Explanation: The longest valid parenthesis substring is "()()".

Input: s = "())()"
Output: 2
Explanation: The longest valid parenthesis substring is "()". 
*/

class Solution {
    static int maxLength(String s) {
        // code here
        Stack<Integer> st=new Stack<>();
        st.push(-1);
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='(') st.push(i);
            else{
                st.pop();
                if(!st.isEmpty()){
                    ans=Math.max(ans,i-st.peek());
                }
                else st.push(i);
            }
        }
        return ans;
    }
}