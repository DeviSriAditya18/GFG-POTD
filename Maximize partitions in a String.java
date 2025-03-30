/*
Courses
90% Refund
Tutorials
Jobs
Practice
Contests
D
51



Maximize partitions in a String
Difficulty: EasyAccuracy: 76.38%Submissions: 72+Points: 2Average Time: 25m
Given a string s of lowercase English alphabets, your task is to return the maximum number of substrings formed, after possible partitions (probably zero) of s such that no two substrings have a common character.

Examples:

Input: s = "acbbcc"
Output: 2
Explanation: "a" and "cbbcc" are two substrings that do not share any characters between them.

Input: s = "ababcbacadefegdehijhklij"
Output: 3
Explanation: Partitioning at the index 8 and at 15 produces three substrings: “ababcbaca”, “defegde”, and “hijhklij” such that none of them have a common character. So, the maximum number of substrings formed is 3.

Input: s = "aaa"
Output: 1
Explanation: Since the string consists of same characters, no further partition can be performed. Hence, the number of substring (here the whole string is considered as the substring) is 1. 
*/

class Solution{
    List<Integer> res=new ArrayList<>();
        int[] last_index=new int[26];
        for(int i=0;i<s.length();i++)
        {
            last_index[s.charAt(i)-'a']=i;
        }
        int start=0,end=0;
        for(int i=0;i<s.length();i++)
        {
            end=Math.max(end,last_index[s.charAt(i)-'a']);
            if(i==end)
            {
                res.add(end-start+1);
                start=i+1;
            }
        }
        return res.size();
}