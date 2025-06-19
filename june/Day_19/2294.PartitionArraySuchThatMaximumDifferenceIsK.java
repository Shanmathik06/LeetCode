// Question : https://leetcode.com/problems/partition-array-such-that-maximum-difference-is-k/
class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int group =1;
        int pointer=nums[0];
        for(int num:nums){
            if(num-pointer>k){
                pointer=num;
                group++;
            }
        }
        return group;
    }
}
