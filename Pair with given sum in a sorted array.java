/*
You are given an integer target and an array arr[]. You have to find number of pairs in arr[] which sums up to target. It is given that the elements of the arr[] are in sorted order.
Note: pairs should have elements of distinct indexes. 

Examples :

Input: arr[] = [-1, 1, 5, 5, 7], target = 6
Output: 3
Explanation: There are 2 pairs which sum up to 6 : {1, 5}, {1, 5} and {-1, 7}.

Input: arr[] = [1, 1, 1, 1], target = 2
Output: 6
Explanation: There are 6 pairs which sum up to 2 : {1, 1}, {1, 1}, {1, 1}, {1, 1}, {1, 1} and {1, 1}.

Input: arr[] = [-1, 10, 10, 12, 15], target = 125
Output: 0
Explanation: There is no such pair which sums up to 4.
*/

class Solution {

    int countPairs(int arr[], int target) {
        // Complete the function
        int s=0;
        int e=arr.length-1;
        int ans=0;
        while(s<e){
            int sum=arr[s]+arr[e]; 
            if(sum==target){
                ans++;
                int ts=s+1;
                while(ts<e&&arr[ts]==arr[ts-1]){
                    ans++;
                    ts++;
                }
                int te=e-1;
                while(s<te&&arr[te]==arr[te+1]){
                    ans++;
                    te--;
                }
                s++;
                e--;
            }
            else if(sum<target)  s++;
            else e--;
        }
        return ans;
    }
}