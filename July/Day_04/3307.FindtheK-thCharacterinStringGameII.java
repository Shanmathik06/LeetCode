//Question : https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/
class Solution {
    public char kthCharacter(long k, int[] operations) {
        
        return solve(k,operations,operations.length);
    }

   private char solve(long k, int[] operations, int n) {
    char result = 'a';

    while (n > 0) {
        long left = 1;
        long right = (long) Math.pow(2, n);
        long mid = left + (right - left) / 2;
        int flip = operations[n - 1];

        if (k <= mid) {
            // go to left half, just reduce n
            n--;
        } else {
            // right half
            k = k - mid;
            if (flip == 1) {
                // simulate character increment
                result = result == 'z' ? 'a' : (char)(result + 1);
            }
            n--;
        }
    }

    return result;
   }

}
