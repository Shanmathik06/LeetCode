Question : https://leetcode.com/problems/determine-if-two-strings-are-close/
// ARRAY METHOD FAST
class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        for (int i = 0; i < word1.length(); ++i) {
            freq1[word1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < word2.length(); ++i) {
            freq2[word2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; ++i) {
            if ((freq1[i] > 0 && freq2[i] == 0) || (freq2[i] > 0 && freq1[i] == 0)) {
                return false; 
            }
        }
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        for (int i = 0; i < 26; ++i) {
            if (freq1[i] != freq2[i]) {
                return false; 
            }
        }
        return true;
    }
}
// HASH MAP MATHOD
class Solution {
    public boolean closeStrings(String word1, String word2) {
        Map <Character,Integer> map1=new HashMap<>();
        Map <Character,Integer> map2=new HashMap<>();
        if(word1.length()==word2.length()){
            for(char c:word1.toCharArray()){
                map1.put(c,map1.getOrDefault(c,0)+1);
            }
            for(char c:word2.toCharArray()){
                map2.put(c,map2.getOrDefault(c,0)+1);
            }
            if(!map1.keySet().equals(map2.keySet())){
                return false;
            }
            List <Integer> list1=new ArrayList<>(map1.values());
            List <Integer> list2=new ArrayList<>(map2.values());
            Collections.sort(list1);
            Collections.sort(list2);
            if(list1.equals(list2)){
                return true;
            }
        }
        return false;
    }
}
        
