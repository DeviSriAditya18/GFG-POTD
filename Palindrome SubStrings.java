/*
Given a string s, count all palindromic sub-strings present in the string. The length of the palindromic sub-string must be greater than or equal to 2. 

Examples

Input: s = "abaab"
Output: 3
Explanation: All palindromic substrings are : "aba" , "aa" , "baab".

Input: s = "aaa"
Output: 3
Explanation: All palindromic substrings are : "aa", "aa", "aaa".

Input: s = "abbaeae"
Output: 4
Explanation: All palindromic substrings are : "bb" , "abba" , "aea", "eae".
*/

class Solution {
    public int countPS(String s) {
        // code here
        int n=s.length();
        boolean dp[][]=new boolean[n][n];
        int ans=0;
        for(int i=0;i<n;i++){
            dp[i][i]=true;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                ans++;
            }
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j=i+len-1;
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                    dp[i][j]=true;
                    ans++;
                }
            }
        }
        return ans;
    }
}