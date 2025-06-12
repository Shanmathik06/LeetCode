Question:https://leetcode.com/problems/lexicographically-smallest-equivalent-string/
class Solution {
    private int groupParent(int arr[],int x){
        if(arr[x]!=x){
            arr[x]=groupParent(arr,arr[x]);
        }
        return arr[x];
    }
    private void findParent(char char1,char char2,int arr[]){
        int parentChar1=groupParent(arr,char1-'a');
        int parentChar2=groupParent(arr,char2-'a');
        if(parentChar1<parentChar2){
               arr[parentChar2]=parentChar1;
               
            }
        else{
            arr[parentChar1]=parentChar2;
        }
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int arr[]=new int [26];
        for(int i=0;i<26;i++){
            arr[i]=i;
        }
        for(int i=0;i<s1.length();i++){
            findParent(s1.charAt(i),s2.charAt(i),arr);
        }
        char baseArr[]=baseStr.toCharArray();
        for(int i=0;i<baseStr.length();i++){
            int ans=groupParent(arr,baseArr[i]-'a');
            baseArr[i]=(char)('a'+ans);
        }
        return new String(baseArr);
    }
}
