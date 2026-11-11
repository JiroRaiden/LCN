class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for(int x: nums)
        {
            int low =0 , high = size;
            while(low<high)
            {
                int mid = low + (high-low)/2;
                if(tails[mid]>=x)
                {
                    high = mid;
                }
                else
                {
                    low = mid+1;
                }
            }
            tails[low]=x;
            if(low==size)
            size++;
        }
        return size;
    }
}