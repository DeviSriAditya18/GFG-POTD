/*
Implement the function power(b, e), which calculates b raised to the power of e (i.e. be).

Examples:

Input: b = 3.00000, e = 5
Output: 243.00000

Input: b = 0.55000, e = 3
Output: 0.16638

Input: b = -0.67000, e = -7
Output: -16.49971
*/

class Solution {
    double power(double b, int e) {
        // code here
        if(e==0) return 1d;
        else if(e<0) return 1d/solve(b,-e);
        else return solve(b,e);
    }
    double solve(double b,int e){
        if(e==1) return b;
        else if(e%2==0) return solve(b*b,e/2);
        else return b*solve(b*b,e/2);
    }
}