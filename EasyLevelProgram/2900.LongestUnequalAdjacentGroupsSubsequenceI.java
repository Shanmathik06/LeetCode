//Question:https://leetcode.com/problems/longest-unequal-adjacent-groups-subsequence-i/
class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> l=new ArrayList<>();
        int num=0;
        for(int i=0;i<words.length;i++){
            if(i==0){
                l.add(words[i]);
                 num=groups[i];
            }
            else if(groups[i]!=num){
                l.add(words[i]);
                num=groups[i];
            }
        }
        return l;
    }
}
