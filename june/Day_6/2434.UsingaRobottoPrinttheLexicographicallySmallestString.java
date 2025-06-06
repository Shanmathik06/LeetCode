Question:https://leetcode.com/problems/using-a-robot-to-print-the-lexicographically-smallest-string/
class Solution {
    private char minChar(int [] freq){
         for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return (char)(i+'a');
            }
         }
         return 'z';
    }
    public String robotWithString(String s) {
        Stack<Character> stack=new Stack<>();
        StringBuilder ans=new StringBuilder();
        int freq[]=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        for(char ch:s.toCharArray()){
            stack.push(ch);
            freq[ch-'a']--;
            while(!stack.isEmpty() && stack.peek()-'a'<=minChar(freq)-'a'){
                ans.append(stack.pop());
                
            }
        }
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
       return ans.toString();
    }
}
