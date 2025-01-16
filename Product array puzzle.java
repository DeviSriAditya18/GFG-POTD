/*
Given an array, arr[] construct a product array, res[] where each element in res[i] is the product of all elements in arr[] except arr[i]. Return this resultant array, res[].
Note: Each element is res[] lies inside the 32-bit integer range.

Examples:

Input: arr[] = [10, 3, 5, 6, 2]
Output: [180, 600, 360, 300, 900]
Explanation: For i=0, res[i] = 3 * 5 * 6 * 2 is 180.
For i = 1, res[i] = 10 * 5 * 6 * 2 is 600.
For i = 2, res[i] = 10 * 3 * 6 * 2 is 360.
For i = 3, res[i] = 10 * 3 * 5 * 2 is 300.
For i = 4, res[i] = 10 * 3 * 5 * 6 is 900.

Input: arr[] = [12, 0]
Output: [0, 12]
Explanation: For i = 0, res[i] is 0.
For i = 1, res[i] is 12.
*/

class Solution {
    public static int[] productExceptSelf(int arr[]) {
        // code here
        int p=1;
        int n=arr.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=p;
            p*=arr[i];
        }
        p=1;
        for(int i=n-1;i>=0;i--){
            ans[i]=ans[i]*p;
            p*=arr[i];
        }
        return ans;
    }
}