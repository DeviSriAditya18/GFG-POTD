/*
Given a string s, your task is to find the longest palindromic substring within s.

A substring is a contiguous sequence of characters within a string, defined as s[i...j] where 0 ≤ i ≤ j < len(s).

A palindrome is a string that reads the same forward and backward. More formally, s is a palindrome if reverse(s) == s.

Note: If there are multiple palindromic substrings with the same length, return the first occurrence of the longest palindromic substring from left to right.

Examples :

Input: s = “forgeeksskeegfor” 
Output: “geeksskeeg”
Explanation: There are several possible palindromic substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.

Input: s = “Geeks” 
Output: “ee”
Explanation: "ee" is the longest palindromic substring of "Geeks". 

Input: s = “abc” 
Output: “a”
Explanation: "a", "b" and "c" are longest palindromic substrings of same length. So, the first occurrence is returned. 
*/

class Solution {
    static String longestPalindrome(String s) {
        // code here
        int n=s.length();
        int start=0,end=0,ml=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(pal(s,i,j)){
                    if(j-i+1>ml){
                        start=i;
                        end=j;
                        ml=Math.max(ml,end-start+1);
                    }
                }
            }
        }
        return s.substring(start,end+1);
    }
    static boolean pal(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}