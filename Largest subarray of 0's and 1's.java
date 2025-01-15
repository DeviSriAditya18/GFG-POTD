/*
Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

Examples:

Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
Output: 6
Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.

Input: arr[] = [0, 0, 1, 1, 0]
Output: 4
Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.

Input: arr[] = [0]
Output: 0
Explnation: There is no subarray with an equal number of 0s and 1s.
*/

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int n=arr.length;
        HashMap<Integer,Integer> h=new HashMap<>();
        int ans=0;
        int ps=0;
        for(int i=0;i<n;i++){
            ps+=arr[i]==0?-1:arr[i];
            if(ps==0) ans=Math.max(ans,i+1);
            if(h.containsKey(ps)){
                ans=Math.max(ans,i-h.get(ps));
            }
            else h.put(ps,i);
        }
        return ans;
    }
}