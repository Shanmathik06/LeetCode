//Question:https://leetcode.com/problems/lexicographically-minimum-string-after-removing-stars/
class Solution {
    public String clearStars(String s) {
        int n=s.length();
        PriorityQueue<Character> pq=new PriorityQueue<>();
        boolean [] keep=new boolean[n];
        Arrays.fill(keep,true);
        Map<Character,Deque<Integer>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(c=='*'){
                char smallChar=pq.poll();
                int idxToRemove=map.get(smallChar).removeLast();
                keep[idxToRemove]=false;
                keep[i]=false;
            }
            else{
                pq.offer(c);
                map.putIfAbsent(c,new ArrayDeque<>());
                map.get(c).add(i);
            }
            
        }
        StringBuilder str=new StringBuilder();
        for(int i=0;i<n;i++){
            if(keep[i]){
                str.append(s.charAt(i));
            }
        }
        return str.toString();
    }
}
