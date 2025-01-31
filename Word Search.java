/*
You are given a two-dimensional mat[][] of size n*m containing English alphabets and a string word. Check if the word exists on the mat. The word can be constructed by using letters from adjacent cells, either horizontally or vertically. The same cell cannot be used more than once.

Examples :

Input: mat[][] = [['T', 'E', 'E'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: true
Explanation:
The letter cells which are used to construct the "GEEK" are colored.

Input: mat[][] = [['T', 'E', 'U'], ['S', 'G', 'K'], ['T', 'E', 'L']], word = "GEEK"
Output: false
Explanation:
It is impossible to construct the string word from the mat using each cell only once.

Input: mat[][] = [['A', 'B', 'A'], ['B', 'A', 'B']], word = "AB"
Output: true
Explanation:
There are multiple ways to construct the word "AB".
*/

class Solution {
    static public boolean isWordExist(char[][] mat, String word) {
        // Code here
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                if(find(mat,i,j,word,0)) return true;
            }
        }
        return false;
    }
    public static boolean find(char mat[][],int i,int j,String word,int index){
        if(index==word.length()){
            return true;
        }
        if (i < 0 || j < 0 || i >= mat.length || j >= mat[0].length || mat[i][j] != word.charAt(index)) {
            return false;
        }
        char t=mat[i][j];
        mat[i][j] = '#'; 

        boolean found = find(mat, i + 1, j, word, index + 1) ||
                        find(mat, i - 1, j, word, index + 1) ||
                        find(mat, i, j + 1, word, index + 1) ||
                        find(mat, i, j - 1, word, index + 1);
        mat[i][j] = t;

        return found;
    }
}