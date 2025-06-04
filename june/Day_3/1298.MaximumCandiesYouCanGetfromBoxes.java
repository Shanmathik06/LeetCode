//Question: https://leetcode.com/problems/maximum-candies-you-can-get-from-boxes/
class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int totalCandies = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        boolean[] hasBox = new boolean[status.length];

        for (int box : initialBoxes) {
            hasBox[box] = true;
            if (status[box] == 1) {
                queue.offer(box);
                seen.add(box);
            }
        }

        while (!queue.isEmpty()) {
            int box = queue.poll();
            totalCandies += candies[box];

            // Add keys and unlock boxes
            for (int k : keys[box]) {
                if (status[k] == 0 && hasBox[k] && !seen.contains(k)) {
                    queue.offer(k);
                    seen.add(k);
                }
                status[k] = 1;  // Now we have the key
            }

            // Add contained boxes
            for (int contained : containedBoxes[box]) {
                hasBox[contained] = true;
                if (status[contained] == 1 && !seen.contains(contained)) {
                    queue.offer(contained);
                    seen.add(contained);
                }
            }
        }

        return totalCandies;
    }
}
