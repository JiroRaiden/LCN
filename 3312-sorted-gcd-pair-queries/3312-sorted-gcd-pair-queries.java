class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {

        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }

        long[] exactPairs = new long[max + 1];

        for (int g = max; g >= 1; g--) {

            long count = 0;

            for (int multiple = g; multiple <= max; multiple += g) {
                count += freq[multiple];
            }

            exactPairs[g] = count * (count - 1) / 2;

            for (int multiple = g * 2; multiple <= max; multiple += g) {
                exactPairs[g] -= exactPairs[multiple];
            }
        }

        long[] prefix = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exactPairs[g];
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            long target = queries[i] + 1;

            int left = 1;
            int right = max;

            while (left < right) {

                int mid = left + (right - left) / 2;

                if (prefix[mid] >= target)
                    right = mid;
                else
                    left = mid + 1;
            }

            answer[i] = left;
        }

        return answer;
    }
}