class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        long prefixSum=0;

        for(int i=0;i<nums.length;i++)
        {
            prefixSum+=nums[i];
            int remainder;

            if(k==0)
            remainder = (int)prefixSum;
            else
            remainder = (int)(prefixSum % Math.abs((long)k));

            if(map.containsKey(remainder))
            {
                if(i-map.get(remainder)>=2)
                return true;
            }
            else
            map.put(remainder, i);

        }
        return false;
    }
}