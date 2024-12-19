/*
You are given a rectangular matrix mat[][] of size n x m, and your task is to return an array while traversing the matrix in spiral form.

Examples:

Input: mat[][] = [[1, 2, 3, 4], [5, 6, 7, 8], [9, 10, 11, 12], [13, 14, 15, 16]]
Output: [1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10]

Input: mat[][] = [[1, 2, 3, 4, 5, 6], [7, 8, 9, 10, 11, 12], [13, 14, 15, 16, 17, 18]]
Output: [1, 2, 3, 4, 5, 6, 12, 18, 17, 16, 15, 14, 13, 7, 8, 9, 10, 11]

Input: mat[][] = [[32, 44, 27, 23], [54, 28, 50, 62]]
Output: [32, 44, 27, 23, 62, 50, 28, 54]
*/


class Solution {
    // Function to return a list of integers denoting spiral traversal of matrix.
    public ArrayList<Integer> spirallyTraverse(int mat[][]) {
        // code here
        ArrayList<Integer> a=new ArrayList<>();
        if(mat==null||mat.length==0) return a;
        int t=0,b=mat.length-1;
        int l=0,r=mat[0].length-1;
        while(t<=b&&l<=r){
            for(int i=l;i<=r;i++) a.add(mat[t][i]);
            t++;
            for(int i=t;i<=b;i++) a.add(mat[i][r]);
            r--;
            if(t<=b){
                for(int i=r;i>=l;i--) a.add(mat[b][i]);
                b--;
            }
            if(l<=r){
                for(int i=b;i>=t;i--) a.add(mat[i][l]);
                l++;
            }
        }
        return a;
    }
}