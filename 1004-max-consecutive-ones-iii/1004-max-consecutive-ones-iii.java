class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int zeroes = 0;

        for(right = 0; right < nums.length; right++)
        {
            if(nums[right]==0)
            zeroes++;

            if(zeroes>k)
            {
                if(nums[left]==0)
                zeroes--;

                left++;
            }
        }
        return right - left;
    }
}