/*
Given a sorted array of distinct positive integers arr[], we need to find the kth positive number that is missing from arr[].  

Examples :

Input: arr[] = [2, 3, 4, 7, 11], k = 5
Output: 9
Explanation: Missing are 1, 5, 6, 8, 9, 10… and 5th missing number is 9.
Input: arr[] = [1, 2, 3], k = 2
Output: 5
Explanation: Missing are 4, 5, 6… and 2nd missing number is 5.
Input: arr[] = [3, 5, 9, 10, 11, 12], k = 2
Output: 2
Explanation: Missing are 1, 2, 4, 5, 6… and 2nd missing number is 2.
*/

class Solution {
    public int kthMissing(int[] arr, int k) {
        // code here
        int n=arr.length;
        int a[]=new int[arr[n-1]];
        for(int i=0;i<a.length;i++){
            a[i]=i+1;
        }
        int i=0,j=0;
        while(i<a.length&&j<arr.length){
            if(a[i]==arr[j]){
                i++;
                j++;
            }
            else{
                i++;
                k--;
                if(k==0) return i;
            }
        }
        if(k>0) return arr[n-1]+k;
        else return -1;
    }
}