// Question : https://leetcode.com/problems/k-th-smallest-in-lexicographical-order/
class Solution {
    public int findKthNumber(int n, int k) {
        long curr=1;
        k--;
        while(k>0){
            long count=count(n,curr,curr+1);
            if(count<=k){
                curr++;
                k-=count;
            }
            else{
                curr*=10;
                k--;
            }
        }
        return (int)curr;
    }
    private int count(int n,long curr,long next){
        int steps=0;
        while(curr<=n){
            steps+=Math.min(n+1,next)-curr;
            curr*=10;
            next*=10;
        }
        return steps;
    }
}




// TIME 0(K)
// class Solution {
//     public int findKthNumber(int n, int k) {
//         List<Integer> l=new ArrayList<>();
//         int curr=1;
//         for(int i=0;i<k;i++){
//              l.add(curr);
//              if(curr*10<=n){
//                 curr=curr*10;
//              }
//              else{
//                 while(curr>=n || curr%10==9){
//                     curr/=10;
//                 }
//                 curr++;
//              }
//         }
//         return l.get(l.size()-1);
//     }
// }
