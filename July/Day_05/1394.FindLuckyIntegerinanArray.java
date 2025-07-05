//Question : https://leetcode.com/problems/find-lucky-integer-in-an-array/
class Solution {
    public int findLucky(int[] arr) {
        int[] freq = new int[501]; // Since 1 <= arr[i] <= 500
        for (int num : arr) {
            freq[num]++;
        }

        for (int i = 500; i >= 1; i--) {
            if (freq[i] == i) {
                return i;
            }
        }

        return -1; 
    }
}
