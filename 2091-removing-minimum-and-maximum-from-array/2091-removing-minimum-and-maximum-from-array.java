class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int maxIndex=0, minIndex=0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            if(max<nums[i])
            {
                max = nums[i];
                maxIndex = i;
            }
            if(min>nums[i])
            {
                min = nums[i];
                minIndex = i;
            }
        }
        int left = Math.min(minIndex, maxIndex);
        int right = Math.max(minIndex, maxIndex);

        return Math.min(right+1, Math.min(n-left, left+1+n-right));
    }
}