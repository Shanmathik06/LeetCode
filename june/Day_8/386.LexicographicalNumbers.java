Question: https://leetcode.com/problems/lexicographical-numbers/
class Solution {
    public List<Integer> lexicalOrder(int n) {
       List<Integer> l=new ArrayList<>();
       int curr=1;
       for(int i=0;i<n;i++ ){
            l.add(curr);
            if(curr*10<=n){
               curr=curr*10;     
            }
           else{
                while(curr>=n || curr%10==9){
                    curr/=10;
                }
           curr++;
        }  
       }
       return l;
    }
}
