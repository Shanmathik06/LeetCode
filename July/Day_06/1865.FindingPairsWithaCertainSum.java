//Question : https://leetcode.com/problems/finding-pairs-with-a-certain-sum/
class FindSumPairs {
    int[] n1, n2;
    Map<Integer, Integer> map2;

    public FindSumPairs(int[] nums1, int[] nums2) {
        n1 = nums1;
        n2 = nums2;
        map2 = new HashMap<>();
        for (int num : nums2) {
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
    }

    public void add(int index, int val) {
        int oldVal = n2[index];
        int newVal = oldVal + val;
        n2[index] = newVal;

        // Update map2
        map2.put(oldVal, map2.get(oldVal) - 1);
        if (map2.get(oldVal) == 0) map2.remove(oldVal);

        map2.put(newVal, map2.getOrDefault(newVal, 0) + 1);
    }

    public int count(int tot) {
        int result = 0;
        for (int a : n1) {
            int b = tot - a;
            result += map2.getOrDefault(b, 0);
        }
        return result;
    }
}
