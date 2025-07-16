//Question : https://leetcode.com/problems/find-the-maximum-length-of-valid-subsequence-i/
class Solution {
    public int maximumLength(int[] nums) {
        int evenC=0,oddC=0,altC=0;
        int prev=-1;
        for(int num:nums){
            // lets count the even number count
            if(num%2==0){
                evenC++;
                if(prev==-1 || prev==1){
                    altC++;
                }
            }
            else{
                oddC++;
                if(prev==0|| prev==-1){
                    altC++;
                }
            }
            prev=num%2;
        }
        return Math.max(altC,Math.max(oddC,evenC));
    }
}
