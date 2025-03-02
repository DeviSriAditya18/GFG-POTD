/*
Given an array of positive integers arr[] and a non-negative integer x, the task is to find the longest sub-array where the absolute difference between any two elements is not greater than x.
If multiple such subarrays exist, return the one that starts at the smallest index.

Examples: 

Input: arr[] = [8, 4, 2, 6, 7], x = 4 
Output: [4, 2, 6] 
Explanation: The sub-array described by index [1..3], i.e. [4, 2, 6] contains no such difference of two elements which is greater than 4.

Input: arr[] = [15, 10, 1, 2, 4, 7, 2], x = 5 
Output: [2, 4, 7, 2] 
Explanation: The sub-array described by indexes [3..6], i.e. [2, 4, 7, 2] contains no such difference of two elements which is greater than 5. 
*/

class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        TreeMap<Integer, Integer> freqMap = new TreeMap<>();
        int left = 0, maxLen = 0, startIdx = 0;

        for (int right = 0; right < arr.length; right++) {
            freqMap.put(arr[right], freqMap.getOrDefault(arr[right], 0) + 1);

            while (freqMap.lastKey() - freqMap.firstKey() > x) {
                freqMap.put(arr[left], freqMap.get(arr[left]) - 1);
                if (freqMap.get(arr[left]) == 0) freqMap.remove(arr[left]);
                left++;
            }

            if (right - left + 1 > maxLen) {
                maxLen = right - left + 1;
                startIdx = left;
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (int i = startIdx; i < startIdx + maxLen; i++) {
            result.add(arr[i]);
        }
        return result;
    }
} 