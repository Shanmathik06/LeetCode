//Question : https://leetcode.com/problems/resulting-string-after-adjacent-removals/
class Solution {
    private Boolean check(char c,int freq[]){
        if(freq[c-'a']!=0){
            freq[c-'a']--;
            return true;
        }
        return false;
    }
    public String resultingString(String s) {
        int freq[]=new int [26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        Stack <Character>st=new Stack<>();
        for(char c:s.toCharArray()){
            if(!st.isEmpty()){
            char topChar=st.peek();
             if(c=='a' ){
                char poss1='b';
                char poss2='z';
                if(poss1==topChar || poss2==topChar){
                   if(check(topChar,freq)){
                        st.pop();
                    }   
                    else{
                        st.push(c);
                    }
                }
                else{
                    st.push(c);
                }
            }
            else if(c=='z'){
                char poss1='y';
                char poss2='a';
                if(poss1==topChar || poss2==topChar){
                   if(check(topChar,freq)){
                        st.pop();
                    }   
                    else{
                        st.push(c);
                    }
                }
                else{
                    st.push(c);
                }
            }
            
            else{
                char poss1=(char)(c-1);
                char poss2=(char)(c+1);
                if(poss1==topChar || poss2==topChar){
                    if(check(topChar,freq)){
                        st.pop();
                    }   
                    else{
                        st.push(c);
                    }
                }
                else{
                    st.push(c);
                }
            }
        }
        else{
            st.push(c);
        }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : st) {
            sb.append(ch);
        }
        String result = sb.toString();
        return  result;
    }
}
