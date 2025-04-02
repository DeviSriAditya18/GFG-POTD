/*
Given a matrix mat[][] of dimension n * m where each cell in the matrix can have values 0, 1 or 2 which has the following meaning:
0 : Empty cell
1 : Cell have fresh oranges
2 : Cell have rotten oranges

We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index (i, j) can rot other fresh orange at indexes (i-1, j), (i+1, j), (i, j-1), (i, j+1) (up, down, left and right) in a unit time.

Note: Your task is to return the minimum time to rot all the fresh oranges. If not possible returns -1.

Examples:

Input: mat[][] = [[0, 1, 2], [0, 1, 2], [2, 1, 1]]
Output: 1
Explanation: Oranges at positions (0,2), (1,2), (2,0) will rot oranges at (0,1), (1,1), (2,2) and (2,1) in unit time.

Input: mat[][] = [[2, 2, 0, 1]]
Output: -1
Explanation: Oranges at (0,0) and (0,1) can't rot orange at (0,3).

Input: mat[][] = [[2, 2, 2], [0, 2, 0]]
Output: 0
Explanation: There is no fresh orange. 
*/

class Solution{
    public int orangesRotting(int[][] mat) {
        // Code here
        Queue<int[]> q = new LinkedList<>();
        int time = 0;

        // Step 1: Add all initially rotten oranges to queue
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }

        // Step 2: BFS traversal
        while (!q.isEmpty()) {
            int lvl = q.size();
            boolean rotten = false; // Track if any fresh orange turns rotten

            for (int i = 0; i < lvl; i++) {
                int[] arr = q.poll();
                int ii = arr[0];
                int jj = arr[1];

                // Check 4 possible directions
                if (ii + 1 < mat.length && mat[ii + 1][jj] == 1) {
                    q.add(new int[]{ii + 1, jj});
                    mat[ii + 1][jj] = 2;
                    rotten = true;
                }
                if (ii - 1 >= 0 && mat[ii - 1][jj] == 1) {
                    q.add(new int[]{ii - 1, jj});
                    mat[ii - 1][jj] = 2;
                    rotten = true;
                }
                if (jj + 1 < mat[0].length && mat[ii][jj + 1] == 1) {
                    q.add(new int[]{ii, jj + 1});
                    mat[ii][jj + 1] = 2;
                    rotten = true;
                }
                if (jj - 1 >= 0 && mat[ii][jj - 1] == 1) {
                    q.add(new int[]{ii, jj - 1});
                    mat[ii][jj - 1] = 2;
                    rotten = true;
                }
            }

            if (rotten) time++; // Increment time only if at least one orange rots
        }

        // Step 3: Check if any fresh oranges remain
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) return -1;
            }
        }

        return time;

    }
}
