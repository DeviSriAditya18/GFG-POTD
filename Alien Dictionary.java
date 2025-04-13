/*
A new alien language uses the English alphabet, but the order of letters is unknown. You are given a list of words[] from the alien language’s dictionary, where the words are claimed to be sorted lexicographically according to the language’s rules.

Your task is to determine the correct order of letters in this alien language based on the given words. If the order is valid, return a string containing the unique letters in lexicographically increasing order as per the new language's rules. If there are multiple valid orders, return any one of them.

However, if the given arrangement of words is inconsistent with any possible letter ordering, return an empty string ("").

A string a is lexicographically smaller than a string b if, at the first position where they differ, the character in a appears earlier in the alien language than the corresponding character in b. If all characters in the shorter word match the beginning of the longer word, the shorter word is considered smaller.

Your implementation will be tested using a driver code. It will print true if your returned order correctly follows the alien language’s lexicographic rules; otherwise, it will print false.

Examples:

Input: words[] = ["cb", "cba", "a", "bc"]
Output: true
Explanation: You need to return "cab" as the correct order of letters in the alien dictionary.

Input: words[] = ["ab", "aa", "a"]
Output: ""
Explanation: You need to return "" because "aa" is lexicographically larger than "a", making the order invalid.

Input: words[] = ["ab", "cd", "ef", "ad"]
Output: ""
Explanation: You need to return "" because "a" appears before "e", but then "e" appears before "a", which contradicts the ordering rules.
*/

class Solution {
    public String findOrder(String[] words) {
        // code here
        HashMap<Character,HashSet<Character>>adj=new HashMap<>(); // i need hashset also coz the char can point to multipal character
        HashMap<Character,Integer>indegree=new HashMap<>();   // for track of indegree i use map
        //Now initiallize the size
        for(String str: words){   //this give me each and every word of array
            for(char ch: str.toCharArray()){   //convert the word to array and provide individual char
                adj.putIfAbsent(ch,new HashSet<>()); 
                indegree.putIfAbsent(ch,0);        //finding unique char and declearing value as 0
            }
        }
        
        //now making graph and filling  indegree
        for(int i=0; i<words.length-1;i++){
            String current=words[i];    //simple intuition we compare 2 -2 string 1st char
            String next=words[i+1];
            int len=Math.min(current.length(),next.length()); 
            for(int j=0;j<len;j++){
                char c=current.charAt(j);
                char n=next.charAt(j);
                if(c!=n){
                 if(!adj.get(c).contains(n)){ // i need to check this coz a>b might be multipal in diff cases but i dont want to increase my indegree 
                     indegree.put(n,indegree.get(n)+1);   //i increase the indegree by 1 for graph
                     adj.get(c).add(n); //basically i added n in hashmap of c ,c>n
                     
                 }
                 break;    // only we see first diff we follow lexicographally so obey dictionary rule  if alrady added then we need breakmight cause trouble in ans so we break here down
                }
                if(j==len-1 && current.length()> next.length()){  //it is must do step coz if we dont find similar and we reach to end mean abc and ab then accordig to our loop we ignore it but if may result in incorrect result as we will be comparinf ab with3rd word and c will treated as component 
                    return "";         
                }
                
            }
        }
        //now we will topo sort graph and make our ans
        StringBuilder s=new StringBuilder();
        Queue<Character> q=new LinkedList<>();
        for(char it: indegree.keySet()){    //basically we are finding all keys
            if(indegree.get(it)==0){        //checking key with 0 ans as a>b a will be 0
                q.offer(it);
            }
        }
        
        while(!q.isEmpty()){
            char temp=q.poll();
            s.append(temp);
            for(char c:adj.get(temp)){   // as we pop temp we go to temp and get its set and decrese their indegree
                indegree.put(c,indegree.get(c)-1); //we are decreasing the values of indegree 
                if(indegree.get(c)==0)
                q.offer(c);
            }
        }
        
        return s.length()==indegree.size()?s.toString() : "";
    }
}