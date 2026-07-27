class Solution {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int i=0;
        int n=nums.length;
        while(i<n)
        {
            if(nums[i]>=max1 )
            {
                max2=max1;
                max1=nums[i];
            }
            else if(nums[i]>max2)
            {
                max2= nums[i];
            }
            i++;
        }
        return (max1-1)*(max2-1);
    }
}