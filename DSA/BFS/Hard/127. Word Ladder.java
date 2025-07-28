//Question : https://leetcode.com/problems/word-ladder/
class Solution {
    Set <String> set;
    Queue <String []>q;
    private int bfs(String word,int idx,String end){
        idx+=1;
        for(int i=0;i<word.length();i++){
            String changedWord=word;
            char Wordarr[]=changedWord.toCharArray();
            for(int j=0;j<26;j++){

                Wordarr[i]=(char)('a'+j);
                changedWord=new String(Wordarr);
                if(changedWord.equals(end )){
                    set.remove(end);
                    return idx;
                }
                if((set.contains(changedWord))){
                    q.add(new String []{changedWord,Integer.toString(idx)});
                    set.remove(changedWord);
                }
            }
        }
        return 0;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        set=new HashSet<>(wordList);
        q=new LinkedList<>();
        if(set.contains(beginWord)){
            set.remove(beginWord);
        }
        if (!set.contains(endWord)) return 0;

        q.add(new String[]{beginWord,"1"});
        int result=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                String arr[]=q.poll();
                String word=arr[0];
                int idx=Integer.parseInt(arr[1]);
                 result= bfs(word,idx,endWord);
                if(result!=0){
                    return result;
                }
                
            }
            
        }
        return 0;
    }
}
