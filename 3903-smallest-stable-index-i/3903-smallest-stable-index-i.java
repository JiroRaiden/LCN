class Solution {
    public int firstStableIndex(int[] nums, int k) {
           int n = nums.length;

        for (int i = 0; i < n; i++) {

            int maxLeft = Integer.MIN_VALUE;
            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, nums[j]);
            }
            int minRight = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                minRight = Math.min(minRight, nums[j]);
            }
            if (maxLeft - minRight <= k) {
                return i;
            }
        }
        return -1;
    }
}