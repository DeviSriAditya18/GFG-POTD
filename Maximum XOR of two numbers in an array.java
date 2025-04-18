/*
Given an array arr[] of non-negative integers of size n. Find the maximum possible XOR between two numbers present in the array.

Examples:

Input: arr[] = [25, 10, 2, 8, 5, 3]
Output: 28
Explanation: The maximum possible XOR is 5 ^ 25 = 28.

Input: arr[] = [1, 2, 3, 4, 5, 6, 7]
Output: 7
Explanation : The maximum possible XOR is 1 ^ 6 = 7.
*/

class Solution {
    public int maxXor(int[] arr) {
        // code here
        int n=arr.length;
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                ans=Math.max(arr[i]^arr[j],ans);
            }
        }
        return ans;
    }
}