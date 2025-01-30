/*
Given an incomplete Sudoku configuration in terms of a 9x9  2-D interger square matrix, mat[][], the task is to solve the Sudoku. It is guaranteed that the input Sudoku will have exactly one solution.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
Note: Zeros represent blanks to be filled with numbers 1-9, while non-zero cells are fixed and cannot be changed.

Examples:

Input: mat[][] = 

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers.
Input: mat[][] = 

Output:

Explanation: Each row, column and 3 x 3 box of the output matrix contains unique numbers. 
*/

class Solution {
    // Function to find a solved Sudoku.
    static void solveSudoku(int[][] mat) {
        // code here
        solve(mat,0,0);
    }
    static boolean solve(int m[][],int r, int c){
        if(r==9) return true;
        int nr=r;
        int nc=c+1;
        if(c==8){
            nr=r+1;
            nc=0;
        }
        if(m[r][c]!=0) return solve(m,nr,nc);
        for(int num=1;num<=9;num++){
            if(isValid(m,r,c,num)){
                m[r][c]=num;
                if(solve(m,nr,nc)) return true;
                m[r][c]=0;
            }
        }
        return false;
    }
    static boolean isValid(int m[][],int r,int c, int n){
        for(int i=0;i<9;i++){
            if(m[r][i]==n || m[i][c]==n ||
            m[3*(r/3)+i/3][3*(c/3)+i%3]==n){
                return false;
            }
        }
        return true;
    }
}