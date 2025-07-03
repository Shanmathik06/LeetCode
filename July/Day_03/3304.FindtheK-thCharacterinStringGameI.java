//Question : https://leetcode.com/problems/find-the-k-th-character-in-string-game-i/
class Solution {
    public char kthCharacter(int k) {
        StringBuilder str=new StringBuilder("a");
        int n=str.length();
        while(n<k){
            StringBuilder append=new StringBuilder();
            for(int i=0; i<n ;i++){
                char ch = str.charAt(i);
                int addNum=((ch-'a')+1)%26;
               // System.out.print(addNum);
                append.append((char)('a'+addNum));
               //System.out.print((char)('a'+addNum));
            }
            str.append(append);
            n=str.length();

        }
    return (str.toString().charAt(k-1));
    }
}
