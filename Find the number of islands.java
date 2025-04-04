/*
Given a grid of size n*m (n is the number of rows and m is the number of columns in the grid) consisting of 'W's (Water) and 'L's (Land). Find the number of islands.

Note: An island is either surrounded by water or the boundary of a grid and is formed by connecting adjacent lands horizontally or vertically or diagonally i.e., in all 8 directions.

Examples:

Input: grid[][] = [['L', 'L', 'W', 'W', 'W'], ['W', 'L', 'W', 'W', 'L'], ['L', 'W', 'W', 'L', 'L'], ['W', 'W', 'W', 'W', 'W'], ['L', 'W', 'L', 'L', 'W']]
Output: 4
Explanation:
The image below shows all the 4 islands in the grid.
 
Input: grid[][] = [['W', 'L', 'L', 'L', 'W', 'W', 'W'], ['W', 'W', 'L', 'L', 'W', 'L', 'W']]
Output: 2
Expanation:
The image below shows 2 islands in the grid.
*/

class Solution {
    public int countIslands(char[][] grid) {
        // Code here
        int m=grid.length;
        int n=grid[0].length;
        boolean vis[][]=new boolean[m][n];
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j]=='L'){
                    dfs(grid,vis,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
    public void dfs(char grid[][], boolean vis[][], int x, int y){
        vis[x][y]=true;
        for(int dx=-1;dx<=1;dx++){
            for(int dy=-1;dy<=1;dy++){
                int cx=x+dx;
                int cy=y+dy;
                if(cx>=0 && cy>=0 && cx<grid.length && cy<grid[0].length && !vis[cx][cy] && grid[cx][cy]=='L'){
                    dfs(grid,vis,cx,cy);
                }
            }
        }
    }
}