class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return atMost(nums, goal) - atMost(nums, goal-1);
    }
    public int atMost(int[] nums, int goal)
    {
        if(goal<0)
        return 0;
        
        int left = 0;
        int right = 0;
        int currSum = 0;
        int totalSubarrays = 0;

        for(right = 0;right<nums.length;right++)
        {
            currSum+=nums[right];

            while(currSum>goal)
            {
                currSum-=nums[left];
                left++;
            }
            totalSubarrays += right-left+1;
        }
        return totalSubarrays;
    }
}