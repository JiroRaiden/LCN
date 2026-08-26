class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        List<Integer> ones = new ArrayList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }

        if (ones.size() < k) {
            return "";
        }

        String ans = null;

        for (int i = 0; i <= ones.size() - k; i++) {
            int start = ones.get(i);
            int end = ones.get(i + k - 1);

            String candidate = s.substring(start, end + 1);

            if (ans == null ||
                candidate.length() < ans.length() ||
                (candidate.length() == ans.length() &&
                 candidate.compareTo(ans) < 0)) {

                ans = candidate;
            }
        }

        return ans;
    }
}