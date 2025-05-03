//Question:https://leetcode.com/problems/push-dominoes/
class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        int[] indexes = new int[N + 2];
        char[] symbols = new char[N + 2];
        int len = 1;

        // Add virtual left wall
        indexes[0] = -1;
        symbols[0] = 'L';

        // Record actual pushed dominoes (R or L)
        for (int i = 0; i < N; ++i) {
            if (dominoes.charAt(i) != '.') {
                indexes[len] = i;
                symbols[len] = dominoes.charAt(i);
                len++;
            }
        }

        // Add virtual right wall
        indexes[len] = N;
        symbols[len] = 'R';
        len++;

        // Convert input to char array
        char[] ans = dominoes.toCharArray();

        // Process each segment between pushed dominoes
        for (int index = 0; index < len - 1; index++) {
            int i = indexes[index];
            int j = indexes[index + 1];
            char left = symbols[index];
            char right = symbols[index + 1];

            // Case 1: Same direction pushes (RR or LL)
            if (left == right) {
                for (int k = i + 1; k < j; k++) {
                    ans[k] = left;
                }
            }
            // Case 2: Opposite direction pushes (R...L)
            else if (left == 'R' && right == 'L') {
                int leftPtr = i + 1;
                int rightPtr = j - 1;
                while (leftPtr < rightPtr) {
                    ans[leftPtr++] = 'R';
                    ans[rightPtr--] = 'L';
                }
                // If leftPtr == rightPtr → middle domino remains '.'
            }
            // Case 3: L...R → do nothing, they cancel
        }

        return String.valueOf(ans);
    }
}
