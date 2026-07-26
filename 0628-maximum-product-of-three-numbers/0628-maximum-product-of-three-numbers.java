class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int prod1 = 1;
        for(int i = n-1;i>=n-3;i--)
        prod1*= nums[i];

        int prod2 = nums[0]*nums[1]*nums[n-1];

        return Math.max(prod1,prod2);
    }
}