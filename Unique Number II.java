/*
Given an array arr[] containing 2*n + 2 positive numbers, out of which 2*n numbers exist in pairs whereas the other two number occur exactly once and are distinct. Find the other two numbers. Return the answer in increasing order.

Examples:

Input: arr[] = [1, 2, 3, 2, 1, 4]
Output: [3, 4] 
Explanation: 3 and 4 occur exactly once.

Input: arr[] = [2, 1, 3, 2]
Output: [1, 3]
Explanation: 1 and 3 occur exactly once.

Input: arr[] = [2, 1, 3, 3]
Output: [1, 2]
Explanation: 1 and 2 occur exactly once.
*/

class Solution {
    public int[] singleNum(int[] arr) {
        // Code here
        HashMap<Integer,Integer> h=new HashMap<>();
        for(int i:arr) h.put(i,h.getOrDefault(i,0)+1);
        int ans[]=new int[2];
        int j=0;
        for (int key : h.keySet()) {
            if (h.get(key) == 1) {
                ans[j++] = key;
            }
        }
        Arrays.sort(ans);
        return ans;
    }
}