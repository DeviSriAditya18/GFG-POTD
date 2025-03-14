/*
Given an array of integers arr[] and a number k, count the number of subarrays having XOR of their elements as k.

Examples: 

Input: arr[] = [4, 2, 2, 6, 4], k = 6
Output: 4
Explanation: The subarrays having XOR of their elements as 6 are [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], and [6]. Hence, the answer is 4.

Input: arr[] = [5, 6, 7, 8, 9], k = 5
Output: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]. Hence, the answer is 2.
*/

class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        HashMap<Integer,Integer> h=new HashMap<>();
        int ans=0,xor=0;
        h.put(0,1);
        for(int i=0;i<arr.length;i++){
            xor^=arr[i];
            if(h.containsKey(xor^k)) ans+=h.get(xor^k);
            h.put(xor,h.getOrDefault(xor,0)+1);
        }
        return ans;
    }
}