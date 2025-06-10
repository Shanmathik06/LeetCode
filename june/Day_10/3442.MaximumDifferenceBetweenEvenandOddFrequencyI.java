//Question: https://leetcode.com/problems/maximum-difference-between-even-and-odd-frequency-i/
class Solution {
    public int maxDifference(String s) {
        int freq[]=new int[26];
        int a1=0;
        int a2=s.length();
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                if(freq[i]%2!=0 && freq[i]>a1){
                    a1=freq[i];
                }
                if(freq[i]%2==0 && freq[i]<a2){
                    a2=freq[i];
                }
            }
        }
        return a1-a2;
    }
}
