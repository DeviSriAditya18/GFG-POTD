/*
Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

Examples:

Input: arr[] = [1, 5, 7, -1, 5], target = 6 
Output: 3
Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 

Input: arr[] = [1, 1, 1, 1], target = 2 
Output: 6
Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).

Input: arr[] = [10, 12, 10, 15, -1], target = 125
Output: 0
*/

class Solution {

    int countPairs(int arr[], int target) {
        // Your code here
        HashMap<Integer,Integer> h=new HashMap<>();
        int ans=0;
        for(int i=0;i<arr.length;i++){
            if(h.containsKey(target-arr[i])) ans+=h.get(target-arr[i]);
            h.put(arr[i],h.getOrDefault(arr[i],0)+1);
        }
        return ans;
    }
}