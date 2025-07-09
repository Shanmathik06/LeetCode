// Question : https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i/
class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n=startTime.length;
       int gaps[]=new int[n+1];
       gaps[0]=startTime[0];
       for(int i=1;i<n;i++){
        gaps[i]=startTime[i]-endTime[i-1];
       } 
       gaps[n]=eventTime-endTime[n-1];
       int windowSize=k+1;
       int max=0;
       int sum=0;
       for(int i=0;i<gaps.length;i++){
        sum+=gaps[i]-((i>=k+1)?gaps[i-(k+1)]:0);
         max=Math.max(sum,max);
       }
       return max;
    }
}
