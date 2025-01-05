/*
Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

Examples:

Input: arr[] = [10, 30, 20, 5], target = 25
Output: [5, 20]
Explanation: As 5 + 20 = 25 is closest to 25.

Input: arr[] = [5, 2, 7, 1, 4], target = 10
Output: [2, 7]
Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 

Input: arr[] = [10], target = 10
Output: []
Explanation: As the input array has only 1 element, return an empty array.
*/

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n=arr.length;
        if(n==0||n==1) return new ArrayList<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int d=Integer.MAX_VALUE;
        Arrays.sort(arr);
        int i=0,j=n-1;
        while(i<j){
            int s=arr[i]+arr[j];
            if(d==0) return ans;
            if(d>Math.abs(target-s)){
                d=Math.abs(target-s);
                ans.clear();
                ans.add(arr[i]);
                ans.add(arr[j]);
            }
            else if(arr[i]+arr[j]<target) i++;
            else j--;
        }
        return ans;
    }
}