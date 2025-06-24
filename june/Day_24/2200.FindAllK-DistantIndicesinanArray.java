//Question : https://leetcode.com/problems/find-all-k-distant-indices-in-an-array/
class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> l=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        for(int j=0;j<nums.length;j++){
             if(nums[j]==key){
                    l.add(j);
                }
        }
        for(int i=0;i<nums.length ;i++){
            for(int num:l){
                if(Math.abs(num-i)<=k){
                    ans.add(i);
                    break;
                }
             }
        }
        return ans;
    }
}
