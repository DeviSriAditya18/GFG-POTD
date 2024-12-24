/*
You are given a 2D matrix mat[][] of size n×m. The task is to modify the matrix such that if mat[i][j] is 0, all the elements in the i-th row and j-th column are set to 0 and do it in constant space complexity.

Examples:

Input: mat[][] = [[1, -1, 1],
                [-1, 0, 1],
                [1, -1, 1]]
Output: [[1, 0, 1],
        [0, 0, 0],
        [1, 0, 1]]
Explanation: mat[1][1] = 0, so all elements in row 1 and column 1 are updated to zeroes.

Input: mat[][] = [[0, 1, 2, 0],
                [3, 4, 5, 2],
                [1, 3, 1, 5]]
Output: [[0, 0, 0, 0],
        [0, 4, 5, 0],
        [0, 3, 1, 0]]
Explanation: mat[0][0] and mat[0][3] are 0s, so all elements in row 0, column 0 and column 3 are updated to zeroes.
*/

class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length, m = mat[0].length;

        // To store which rows and columns are
        // supposed to mark with zeroes
        boolean[] rows = new boolean[n];
        boolean[] cols = new boolean[m];

        // Traverse the matrix to fill rows[] and cols[]
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // If the cell contains zero then mark
                // its row and column as zero
                if (mat[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }

        // Set matrix elements to zero if they
        // belong to a marked row or column
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                // Mark cell (i, j) with zero if either
                // of rows[i] or cols[j] is true
                if (rows[i] || cols[j]) {
                    mat[i][j] = 0;
                }
            }
        }

    }
}