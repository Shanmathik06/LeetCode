//Question : https://leetcode.com/problems/longest-harmonious-subsequence/
class Solution {
    public int findLHS(int[] nums) {
        Map <Integer ,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);

        }
        int ans=0;
        for(int key:map.keySet()){
            if(map.containsKey(key+1)){
                ans=Math.max(ans,map.get(key)+map.get(key+1));
            }
        }
        return ans;
    }
}
