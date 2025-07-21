// Question : https://leetcode.com/problems/delete-characters-to-make-fancy-string/
class Solution {
    public String makeFancyString(String s) {
        if(s.length()<=2){
            return s;
        }
        StringBuilder str=new StringBuilder();
        str.append(s.charAt(0));
        str.append(s.charAt(1));
        for(int i=2;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1) && s.charAt(i)==s.charAt(i-2)){
                    continue;
            }
            else{
                str.append(s.charAt(i));
              
            }
        }
        return str.toString();
    }
}
