/*
Courses
90% Refund
Tutorials
Jobs
Practice
Contests
D
51



Minimum Platforms
Difficulty: MediumAccuracy: 26.84%Submissions: 518K+Points: 4
You are given the arrival times arr[] and departure times dep[] of all trains that arrive at a railway station on the same day. Your task is to determine the minimum number of platforms required at the station to ensure that no train is kept waiting.

At any given time, the same platform cannot be used for both the arrival of one train and the departure of another. Therefore, when two trains arrive at the same time, or when one arrives before another departs, additional platforms are required to accommodate both trains.

Examples:

Input: arr[] = [900, 940, 950, 1100, 1500, 1800], dep[] = [910, 1200, 1120, 1130, 1900, 2000]
Output: 3
Explanation: There are three trains during the time 9:40 to 12:00. So we need a minimum of 3 platforms.

Input: arr[] = [900, 1235, 1100], dep[] = [1000, 1240, 1200]
Output: 1
Explanation: All train times are mutually exclusive. So we need only one platform

Input: arr[] = [1000, 935, 1100], dep[] = [1200, 1240, 1130]
Output: 3
Explanation: All 3 trains have to be there from 11:00 to 11:30
*/

class Solution{
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int n = arr.length;
        int platformsNeeded = 0, maxPlatforms = 0;
        int i = 0, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) { 
                platformsNeeded++; // Train arrives, increase platform count
                i++;
            } else { 
                platformsNeeded--; // Train departs, decrease platform count
                j++;
            }
            maxPlatforms = Math.max(maxPlatforms, platformsNeeded);
        }
        
        return maxPlatforms;
    }
}