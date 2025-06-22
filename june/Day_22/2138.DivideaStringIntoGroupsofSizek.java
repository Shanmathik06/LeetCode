//Question : https://leetcode.com/problems/divide-a-string-into-groups-of-size-k/
class Solution {
    public String[] divideString(String s, int k, char fill) {
        int size = (s.length() + k - 1) / k; // Correct size using ceiling division
        String[] arr = new String[size];
        int idx = 0;

        for (int i = 0; i < s.length(); i += k) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < k; j++) {
                if (i + j < s.length()) {
                    str.append(s.charAt(i + j));
                } else {
                    str.append(fill);
                }
            }
            arr[idx++] = str.toString(); // This won't exceed `size`
        }

        return arr;
    }
}
