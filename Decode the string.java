/*
Given an encoded string s, the task is to decode it. The encoding rule is :

k[encodedString], where the encodedString inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
Note: The test cases are generated so that the length of the output string will never exceed 105 .

Examples:

Input: s = "1[b]"
Output: "b"
Explanation: "b" is present only one time.

Input: s = "3[b2[ca]]"
Output: "bcacabcacabcaca"
Explanation:
1. Inner substring “2[ca]” breakdown into “caca”.
2. Now, new string becomes “3[bcaca]”
3. Similarly “3[bcaca]” becomes “bcacabcacabcaca ” which is final result. 
*/

class Solution {
    static String decodeString(String s) {
        // code here
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder current = new StringBuilder();
        
        int num = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if (c == '[') {
                nums.push(num);
                st.push(current);
                current = new StringBuilder();
                num = 0;
            }
            else if (c == ']') {
                StringBuilder temp = current;
                current = st.pop();
                int count = nums.pop();
                current.append(String.valueOf(temp).repeat(count));
            }
            else {
                current.append(c);
            }
        }
        
        return current.toString();
    }
}