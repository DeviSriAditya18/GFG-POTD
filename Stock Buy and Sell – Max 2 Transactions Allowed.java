/*
In daily share trading, a trader buys shares and sells them on the same day. If the trader is allowed to make at most 2 transactions in a day, find out the maximum profit that a share trader could have made.

You are given an array prices[] representing stock prices throughout the day. Note that the second transaction can only start after the first one is complete (buy->sell->buy->sell).

Examples:

Input: prices[] = [10, 22, 5, 75, 65, 80]
Output: 87
Explanation: 
Trader will buy at 10 and sells at 22. 
Profit earned in 1st transaction = 22 - 10 = 12. 
Then he buys at 5 and sell at 80. 
Profit earned in 2nd transaction = 80 - 5 = 75. 
Total profit earned = 12 + 75 = 87. 

Input: prices[] = [2, 30, 15, 10, 8, 25, 80]
Output: 100
Explanation: 
Trader will buy at 2 and sells at 30. 
Profit earned in 1st transaction = 30 - 2 = 28. 
Then he buys at 8 and sell at 80. 
Profit earned in 2nd transaction = 80 - 8 = 72. 
Total profit earned = 28 + 72 = 100.
*/

class Solution {
    public static int maxProfit(int[] prices) {
        // code here
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];
        for(int ind = n-1 ; ind >= 0 ; ind--){
            for(int buy = 0 ; buy <= 1 ; buy++){
                for(int cap = 1; cap <= 2 ; cap++){
                    if(buy == 0){
                        dp[ind][buy][cap] = Math.max(0 + dp[ind+1][0][cap] , -prices[ind] + dp[ind+1][1][cap]);
                    }
                    if(buy == 1){
                        dp[ind][buy][cap] = Math.max(0 + dp[ind+1][1][cap] , prices[ind] + dp[ind+1][0][cap-1]);
                    }
                }
            }
        }
        return dp[0][0][2];
    }
}