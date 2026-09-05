class Solution {
    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        
        int sum = 0;
        for(int i =0; i<nums.length;i++)
        {
            freq[nums[i]]++;
        }
        for(int i=0;i< nums.length;i++)
        {
            if(freq[nums[i]]==1)
            sum=sum+nums[i];
        }
        return sum;
    }
}