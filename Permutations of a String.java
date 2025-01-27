/*

Difficulty: MediumAccuracy: 34.65%Submissions: 281K+Points: 4
Given a string s, which may contain duplicate characters, your task is to generate and return an array of all unique permutations of the string. You can return your answer in any order.

Examples:

Input: s = "ABC"
Output: ["ABC", "ACB", "BAC", "BCA", "CAB", "CBA"]
Explanation: Given string ABC has 6 unique permutations.

Input: s = "ABSG"
Output: ["ABGS", "ABSG", "AGBS", "AGSB", "ASBG", "ASGB", "BAGS", "BASG", "BGAS", "BGSA", "BSAG", "BSGA", "GABS", "GASB", "GBAS", "GBSA", "GSAB", "GSBA", "SABG", "SAGB", "SBAG", "SBGA", "SGAB", "SGBA"]
Explanation: Given string ABSG has 24 unique permutations.

Input: s = "AAA"
Output: ["AAA"]
Explanation: No other unique permutations can be formed as all the characters are same. 
*/

class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        HashSet<String> h=new HashSet<>();
        perm(h,"",s);
        ArrayList<String> ans=new ArrayList<>(h);
        return ans;
    }
    public void perm(HashSet<String> l,String p, String up){
        if(up.isEmpty()){
            l.add(p);
            return;
        }
        
        for(int i=0;i<up.length();i++){
            String first=up.substring(0,i);
            String second=up.substring(i+1);
            perm(l,p+up.charAt(i),first+second);
        }
    }
}