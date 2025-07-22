//Question :https://leetcode.com/problems/maximum-erasure-value/
class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int start=0,add=0;
        int max=0;
        Set <Integer> set=new HashSet<>(); 
        for(int end =0;end<nums.length;end++){
            int num=nums[end];
                while(set.contains(num)){
                    
                        set.remove(nums[start]);
                        add-=nums[start];
                       start=start+1;
                
                }
               set.add(num);
                add+=num;
        
            max=Math.max(max,add);
        }
        return max;
        
    }
}
