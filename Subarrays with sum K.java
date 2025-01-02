/*
Given an unsorted array of integers, find the number of continuous subarrays having sum exactly equal to a given number k.

Examples:

Input: arr = [10, 2, -2, -20, 10], k = -10
Output: 3
Explaination: Subarrays: arr[0...3], arr[1...4], arr[3...4] have sum exactly equal to -10.

Input: arr = [9, 4, 20, 3, 10, 5], k = 33
Output: 2
Explaination: Subarrays: arr[0...2], arr[2...4] have sum exactly equal to 33.

Input: arr = [1, 3, 5], k = 0
Output: 0
Explaination: No subarray with 0 sum.
*/

class Solution {
    public int countSubarrays(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> h=new HashMap<>();
        int ans=0,s=0;
        h.put(0,1);
        for(int i=0;i<arr.length;i++){
            s+=arr[i];
            if(h.containsKey(s-k)) ans+=h.get(s-k);
            h.put(s,h.getOrDefault(s,0)+1);
        }
        return ans;
    }
}