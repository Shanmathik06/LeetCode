// Question : https://leetcode.com/problems/divide-array-into-arrays-with-max-difference/
class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int [][]twoD=new int[nums.length/3][3];
        Arrays.sort(nums);
        int n=nums.length;
        int idx=0;
        for(int i=0;i<n/3;i++){
            for(int j=0;j<3;j++){
                twoD[i][j]=nums[idx];
                idx++;
            }
            int j=0;
            int arr[]=twoD[i];
            int diff1=Math.abs(arr[j]-arr[j+1]);
            int diff2=Math.abs(arr[j]-arr[j+2]);
            int diff3=Math.abs(arr[j+1]-arr[j+2]);
            if(diff1>k || diff2>k || diff3>k){
                return new int[0][0];
            }
        }
        return twoD;

    }
}
