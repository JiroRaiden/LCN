class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        
        int n = nums.length;
        int totalSub = 1<<n;
        List<List<Integer>> result = new ArrayList<>();
        for(int mask =0 ; mask< totalSub;mask++)
        {
            List<Integer> curr = new ArrayList<>();

            for(int i =0;i<n;i++)
            {
                if((mask&(1<<i))!=0)
                curr.add(nums[i]);
            }
            result.add(new ArrayList<>(curr));
        }
        return result;
    }
}