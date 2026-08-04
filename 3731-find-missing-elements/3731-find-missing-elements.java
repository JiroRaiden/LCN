class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        HashSet<Integer> num = new HashSet<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(nums[i]<min)
            min = nums[i];

            if(nums[i]>max)
            max = nums[i];

            num.add(nums[i]);
        }

        for(int i = min;i<=max;i++)
        {
            if(!num.contains(i))
            result.add(i);
        }

        return result;
    }
}