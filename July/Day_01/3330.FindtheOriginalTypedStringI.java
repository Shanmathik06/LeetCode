//Question : https://leetcode.com/problems/find-the-original-typed-string-i/
class Solution {
    public int possibleStringCount(String word) {
        int count=1;
        char curr=word.charAt(0);;
        for(int i=1;i<word.length();i++){
                if(curr==word.charAt(i)){
                    count++;
                }
                curr=word.charAt(i);
        }
        return count;
    }
}
