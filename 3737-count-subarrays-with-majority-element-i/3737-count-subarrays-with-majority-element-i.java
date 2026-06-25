class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int result=0;
        int n = nums.length;
        for(int i=0; i < n;i++)
        {
            int count = 0;
            for(int j=i;j<n;j++)
            {
                count+=(nums[j]==target)?1:-1;
                if(count>0)
                result++;
            }
        }
        return result;
    }
}