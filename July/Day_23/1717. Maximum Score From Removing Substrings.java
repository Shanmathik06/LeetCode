//Question : https://leetcode.com/problems/maximum-score-from-removing-substrings/
class Solution {
    public int maximumGain(String s, int x, int y) {
        // STEP :1 find the max priority and low priority
        String highPriority=x>y ?"ab":"ba";
        String lowPriority=highPriority.equals("ba")?"ab":"ba";
        //STEP :2  Deleting the max priority substring in the main string
        String AfterDeleting=delete(s,highPriority);
        int pairs=(s.length()-AfterDeleting.length())/2;
        // STEP :3 CAlxulating the scores
        int totalScore = pairs*Math.max(x,y);
       // repeat step 1,2,3 for low priority
        String AfterLowPri =delete(AfterDeleting,lowPriority);
         pairs=(AfterDeleting.length()-AfterLowPri.length())/2;
        totalScore += pairs*Math.min(x,y);
        return totalScore;

    }
    private String delete(String s,String priority){
        Stack <Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==priority.charAt(1)&& !st.isEmpty() && st.peek()==priority.charAt(0)){
                st.pop();
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder str=new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());

        } 
        return str.reverse().toString();
    }
}
