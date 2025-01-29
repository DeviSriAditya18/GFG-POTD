/*
The n-queens puzzle is the problem of placing n queens on a (n × n) chessboard such that no two queens can attack each other. Note that two queens attack each other if they are placed on the same row, the same column, or the same diagonal.

Given an integer n, find all distinct solutions to the n-queens puzzle.
You can return your answer in any order but each solution should represent a distinct board configuration of the queen placements, where the solutions are represented as permutations of [1, 2, 3, ..., n]. In this representation, the number in the ith position denotes the row in which the queen is placed in the ith column.
For eg. below figure represents a chessboard [3 1 4 2].



Examples:

Input: n = 1
Output: [1]
Explaination: Only one queen can be placed in the single cell available.

Input: n = 4
Output: [[2 4 1 3 ] [3 1 4 2 ]]
Explaination: There are 2 possible solutions for n = 4.

Input: n = 2
Output: []
Explaination: There are no possible solutions for n = 2. 
*/

class Solution {
    public ArrayList<ArrayList<Integer>> nQueen(int n) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        solve(n,0,new ArrayList<>(), ans);
        return ans;
    }
    public void solve(int n, int col, ArrayList<Integer> curr, ArrayList<ArrayList<Integer>> ans){
        if(col==n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int row=1;row<=n;row++){
            if(isSafe(row,col+1,curr)){
                curr.add(row);
                solve(n,col+1,curr,ans);
                curr.remove(curr.size()-1);
            }
        }
    }
    public boolean isSafe(int row,int col,ArrayList<Integer> curr){
        for(int i=0;i<curr.size();i++){
            int pr=curr.get(i);
            int pc=i+1;
            if(pr==row || Math.abs(pr-row)==Math.abs(pc-col)){
                return false;
            }
        }
        return true;
    }
}