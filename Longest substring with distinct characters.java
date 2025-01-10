/*
Given a string s, find the length of the longest substring with all distinct characters. 

Examples:

Input: s = "geeksforgeeks"
Output: 7
Explanation: "eksforg" is the longest substring with all distinct characters.

Input: s = "aaa"
Output: 1
Explanation: "a" is the longest substring with all distinct characters.

Input: s = "abcdefabcbb"
Output: 6
Explanation: The longest substring with all distinct characters is "abcdef", which has a length of 6.
*/

class Solution {
    public int longestUniqueSubstr(String s) {
        // code here
        int min=0;
        int ans=Integer.MIN_VALUE;
        HashMap<Character,Integer> h=new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(h.containsKey(s.charAt(i))) min=Math.max(min,h.get(s.charAt(i))+1);
            h.put(s.charAt(i),i);
            ans=Math.max(ans,i-min+1);
        }
        return ans;
    }
}