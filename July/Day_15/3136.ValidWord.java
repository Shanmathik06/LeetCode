//Question : https://leetcode.com/problems/valid-word/
class Solution {
    public boolean isValid(String word) {
        int v=0,c=0;
        if(word.length()<3){
            return false;
        }
        for(char ch:word.toCharArray()){
            if(!Character.isLetterOrDigit(ch)) {
                return false;
            }
            if(Character.isLetter(ch)){
                if("AEIOUaeiou".indexOf(ch)!=-1){
                    v++;
                }
                else{
                    c++;
                }
            }
           
        }
         if( v>0 && c>0){
                return true;
            }
        return false;
    }
}
