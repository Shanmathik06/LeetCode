//Question:https://leetcode.com/problems/longest-substring-without-repeating-characters/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0,j=0;
        int max=0;
        int arr[]=new int[128];
        while(j<s.length()){
            if(arr[s.charAt(j)]==0){
                arr[s.charAt(j)]++;
                j++;
                 max=Math.max(max,j-i);

            }
            else{
                while(arr[s.charAt(j)]!=0){
                    arr[s.charAt(i)]--;
                    i++;

                }
            }
        }
        return max;
    }
}
