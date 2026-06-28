class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        Arrays.sort(nums);
        long result=0;
        long currMul = mul;
        for(int i = nums.length-1; i>=0 && k>0;i--)
        {
            long val = nums[i];
            currMul = Math.max(1,mul);

            result=result + currMul*val;
            mul--;
            k--;
        }
        return result;
    }
}