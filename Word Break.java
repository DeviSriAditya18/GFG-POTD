/*
You are given a string s and a list dictionary[] of words. Your task is to determine whether the string s can be formed by concatenating one or more words from the dictionary[].

Note: From dictionary[], any word can be taken any number of times and in any order.

Examples :

Input: s = "ilike", dictionary[] = ["i", "like", "gfg"]
Output: true
Explanation: s can be breakdown as "i like".

Input: s = "ilikegfg", dictionary = ["i", "like", "man", "india", "gfg"]
Output: true
Explanation: s can be breakdown as "i like gfg".

Input: s = "ilikemangoes", dictionary = ["i", "like", "man", "india", "gfg"]
Output: false
Explanation: s cannot be formed using dictionary[] words.
*/

class Solution{
    public int wordBreak(String s, String[] dictionary) {
        // code here
        boolean dp[] = new boolean[s.length()+1];
        HashSet<String> dct = new HashSet<>(Arrays.asList(dictionary));
       reString word : dct) {
            maxWordLength = Math.max(maxWordLength, word.length());
        }
        int len turn find(s,dct,dp);
    }
    public static int find(String s, HashSet<String> dct,boolean [] dp) {
       dp[0] = true;
         int maxWordLength = 0;
        for (= s.length();
        for(int i = 1;i<= len; i++){
            for(int j = Math.max(0, i - maxWordLength);j < i;j++){
                
                if(dp[j] && dct.contains(s.substring(j, i))){
                    dp[i] = true;
                   break;
                }
            }
        }
      return dp[len] ? 1 : 0;
    }
}

