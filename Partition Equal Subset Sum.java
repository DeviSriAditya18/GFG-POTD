/*
Given an array arr[], determine if it can be partitioned into two subsets such that the sum of elements in both parts is the same.

Note: Each element must be in exactly one subset.

Examples:

Input: arr = [1, 5, 11, 5]
Output: true
Explanation: The two parts are [1, 5, 5] and [11].

Input: arr = [1, 3, 5]
Output: false
Explanation: This array can never be partitioned into two such parts.
*/

class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for(int i=0; i<arr.length ; i++)
            sum = sum + arr[i];
        
        if(sum%2 != 0)
            return false;
        else
        {
            boolean dp [][] =  new boolean [arr.length+1][(sum/2)+1];
            
            for(int i = 0 ; i<arr.length+1 ; i++)
               for(int j = 0; j< (sum/2)+1 ; j++)
               {
                   if(i == 0)
                      dp[i][j]  = false;
                   if(j == 0)
                      dp[i][j] = true;
               }
               
            for(int i=1 ; i<arr.length+1 ; i++)
            {
                for(int j = 1; j<(sum/2)+1 ; j++)
                {
                    if(arr[i-1] <= j)
                       dp[i][j] = dp[i-1][j - arr[i-1]]  || dp[i-1][j];
                    else
                       dp[i][j] = dp[i-1][j];
                }
            }
            return dp[arr.length][(sum/2)];
            
        }
    }
}