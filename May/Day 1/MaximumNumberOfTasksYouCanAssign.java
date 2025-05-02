// https://leetcode.com/problems/maximum-number-of-tasks-you-can-assign/
class Solution {
    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int n = tasks.length;
        int w = workers.length;
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 1, right = Math.min(n, w), ans = 0;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (check(tasks, workers, pills, strength, mid)) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;

            }

        }
        return ans;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int mid) {
        int p = pills;
        int w = workers.length;
        Deque<Integer> q = new ArrayDeque<>();
        int end = w - 1;
        for (int i = mid - 1; i >= 0; i--) {
            while (end >= w - mid && workers[end] + strength >= tasks[i]) {
                q.addFirst(workers[end]);
                end--;

            }
            if (q.isEmpty()) {
                return false;
            } else if (q.getLast() >= tasks[i]) {
                q.pollLast();
            } else {
                if (p == 0) {
                    return false;
                }
                p--;
                q.pollFirst();
            }
        }
        return true;
    }
}
