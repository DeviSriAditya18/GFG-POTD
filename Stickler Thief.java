/*
Stickler the thief wants to loot money from the houses arranged in a line. He cannot loot two consecutive houses and aims to maximize his total loot.
Given an array, arr[] where arr[i] represents the amount of money in the i-th house.
Determine the maximum amount he can loot.

Examples:

Input: arr[] = [6, 5, 5, 7, 4]
Output: 15
Explanation: Maximum amount he can get by looting 1st, 3rd and 5th house. Which is 6 + 5 + 4 = 15.

Input: arr[] = [1, 5, 3]
Output: 5
Explanation: Loot only 2nd house and get maximum amount of 5.

Input: arr[] = [4, 4, 4, 4]
Output: 8
Explanation: The optimal choice is to loot every alternate house. Looting the 1st and 3rd houses, or the 2nd and 4th, both give a maximum total of 4 + 4 = 8.
*/

class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        if(arr.length==0) return -1;
        int dp[]=new int[arr.length+1];
        Arrays.fill(dp,-1);
        return solve(arr,0,dp);
    }
    public int solve(int arr[],int i,int dp[]){
        if(i>=arr.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int p=arr[i]+solve(arr,i+2,dp);
        int np=solve(arr,i+1,dp);
        return dp[i]=Math.max(p,np);
    } 
}