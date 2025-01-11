/*
Given an array arr[] with non-negative integers representing the height of blocks. If the width of each block is 1, compute how much water can be trapped between the blocks during the rainy season. 

Examples:

Input: arr[] = [3, 0, 1, 0, 4, 0 2]
Output: 10
Explanation: Total water trapped = 0 + 3 + 2 + 3 + 0 + 2 + 0 = 10 units.

Input: arr[] = [3, 0, 2, 0, 4]
Output: 7
Explanation: Total water trapped = 0 + 3 + 1 + 3 + 0 = 7 units.

Input: arr[] = [1, 2, 3, 4]
Output: 0
Explanation: We cannot trap water as there is no height bound on both sides.

Input: arr[] = [2, 1, 5, 3, 1, 0, 4]
Output: 9
Explanation: Total water trapped = 0 + 1 + 0 + 1 + 3 + 4 + 0 = 9 units.
*/

class Solution {
    public int maxWater(int arr[]) {
        // code here
        int n=arr.length;
        if(n<=1) return 0;
        int l[]=new int[n];
        int r[]=new int[n];
        for(int i=0;i<n;i++){
            if(i==0) l[i]=arr[i];
            else l[i]=Math.max(arr[i],l[i-1]);
        }
        for(int i=n-1;i>=0;i--){
            if(i==n-1) r[i]=arr[i];
            else r[i]=Math.max(arr[i],r[i+1]);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            ans+=Math.min(l[i],r[i])-arr[i];
        }
        return ans;
    }
}
