//Question : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
class Solution {
    private int findfirst(int l,int r,int [] nums,int target){
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                ans=mid;
                r=mid-1;    //left side only the first occurence will be placed 
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    private int findlast(int l,int r,int [] nums,int target){
        int ans=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid]==target){
                ans=mid;
                l=mid+1;       //right side only the first occurence will be placed 
            }
            else if(nums[mid]>target){
                r=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int ans[]=new int[2];
        int left=0;
        int right=nums.length-1;
        ans[0]=findfirst(left,right,nums,target);
        ans[1]=findlast(left,right,nums,target);
        
        return ans;
    }
}
