class Solution {

    public long countNonDecreasingSubarrays(int[] nums, int k) {

        int n = nums.length;
        int LOG = 1;

        while ((1 << LOG) <= n) LOG++;

        int[] next = new int[n];
        int[] stack = new int[n];
        int top = -1;

        // 1. Next strictly greater element
        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 && nums[stack[top]] <= nums[i]) {
                top--;
            }

            next[i] = (top == -1) ? n : stack[top];

            stack[++top] = i;
        }

        // 2. Binary lifting tables
        int[][] jump = new int[LOG][n + 1];
        long[][] sum = new long[LOG][n + 1];

        // IMPORTANT: Initialize sentinel correctly
        for (int j = 0; j < LOG; j++) {
            jump[j][n] = n;
            sum[j][n] = 0;
        }

        for (int i = 0; i < n; i++) {

            jump[0][i] = next[i];

            sum[0][i] = (long) (next[i] - i) * nums[i];
        }

        for (int j = 1; j < LOG; j++) {

            for (int i = 0; i < n; i++) {

                int mid = jump[j - 1][i];

                jump[j][i] = jump[j - 1][mid];

                sum[j][i] = sum[j - 1][i]
                          + sum[j - 1][mid];
            }
        }

        // 3. Prefix sums
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // 4. Sliding window
        long ans = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {

            while (left <= right &&
                   getCost(left, right, nums, prefix,
                           jump, sum, LOG) > k) {

                left++;
            }

            ans += right - left + 1;
        }

        return ans;
    }

    private long getCost(
        int left,
        int right,
        int[] nums,
        long[] prefix,
        int[][] jump,
        long[][] sum,
        int LOG
    ) {

        int curr = left;
        long maxSum = 0;

        // Skip complete maximum-value segments
        for (int j = LOG - 1; j >= 0; j--) {

            int dest = jump[j][curr];

            if (dest <= right) {

                maxSum += sum[j][curr];

                curr = dest;
            }
        }

        // Remaining segment
        maxSum += (long) (right - curr + 1) * nums[curr];

        long originalSum =
            prefix[right + 1] - prefix[left];

        return maxSum - originalSum;
    }
}