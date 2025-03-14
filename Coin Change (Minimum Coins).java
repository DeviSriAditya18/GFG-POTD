/*
You are given an array coins[], where each element represents a coin of a different denomination, and a target value sum. You have an unlimited supply of each coin type {coins1, coins2, ..., coinsm}.

Your task is to determine the minimum number of coins needed to obtain the target sum. If it is not possible to form the sum using the given coins, return -1.

Examples:

Input: coins[] = [25, 10, 5], sum = 30
Output: 2
Explanation: Minimum 2 coins needed, 25 and 5  

Input: coins[] = [9, 6, 5, 1], sum = 19
Output: 3
Explanation: 19 = 9 + 9 + 1

Input: coins[] = [5, 1], sum = 0
Output: 0
Explanation: For 0 sum, we do not need a coin

Input: coins[] = [4, 6, 2], sum = 5
Output: -1
Explanation: Not possible to make the given sum.
*/

class Solution {

    public int minCoins(int coins[], int sum) {
        // code here
        int dp[]=new int[sum+1];
        Arrays.fill(dp,sum+1);
        dp[0]=0;
        for(int c:coins){
            for(int i=c;i<=sum;i++){
                dp[i]=Math.min(dp[i],dp[i-c]+1);
            }
        }
        return dp[sum]==sum+1?-1:dp[sum];
    }
}