/*
Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

Examples:

Input: arr[] = [5, 8, 3, 7, 9, 1]
Output: 3
Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.

Input: arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
Output: 6
Explanation: One of the possible longest strictly increasing subsequences is [0, 2, 6, 9, 13, 15], which has a length of 6.

Input: arr[] = [3, 10, 2, 1, 20]
Output: 3
Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3. 
*/

class Solution {
    static int lis(int arr[]) {
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for(int[] d : dp) Arrays.fill(d, -1);
        return func(0, -1, arr, dp);
    }
    static int func(int ind, int prev_ind, int[] arr, int[][] dp) {
        if(ind == arr.length) return 0;
        if(dp[ind][prev_ind + 1] != -1) return dp[ind][prev_ind + 1];
        int ans = func(ind+1, prev_ind, arr, dp);
        if(prev_ind == -1 || arr[ind] > arr[prev_ind]) {
            ans = Math.max(ans, 1 + func(ind + 1, ind, arr, dp));
        }
        return dp[ind][prev_ind+1]=ans;
    }
}