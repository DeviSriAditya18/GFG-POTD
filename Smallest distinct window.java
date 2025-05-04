/*
Given a string str, your task is to find the length of the smallest window that contains all the characters of the given string at least once.

Example:

Input: str = "aabcbcdbca"
Output: 4
Explanation: Sub-String "dbca" has the smallest length that contains all the characters of str.

Input: str = "aaab"
Output: 2
Explanation: Sub-String "ab" has the smallest length that contains all the characters of str.

Input: str = "geeksforgeeks"
Output: 8
Explanation: There are multiple substring with smallest length that contains all characters of str, "geeksfor" and "forgeeks". 
*/

class Solution {
    public int findSubString(String str) {
        // code here
        int[] freq = new int[26];
        int count  = 0, uniq_count = 0;
        int subStringLength = str.length();
        
        for(char ch : str.toCharArray())    freq[ch - 'a'] = 1;
        for(int i : freq)                   uniq_count += i;
        Arrays.fill(freq, 0);
        
        for(int right = 0, left = 0; right < str.length(); right++) {
            char char_r = str.charAt(right);
            
            if(freq[char_r - 'a']++ == 0)                count++;
            
            while(count == uniq_count) {
                subStringLength = Math.min(subStringLength, right - left + 1);
                
                char char_l = str.charAt(left);
                if(--freq[char_l - 'a'] == 0) {
                    count--;
                }
                left++;
            }
        }
        return subStringLength;
    }
}