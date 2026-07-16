class Solution {
    public long gcdSum(int[] nums) {
        int prefixMax = Integer.MIN_VALUE;
        int[] prefixGcd = new int[nums.length];

        for(int i =0;i< nums.length;i++)
        {
            prefixMax=Math.max(prefixMax,nums[i]);
            prefixGcd[i]= gcd(nums[i],prefixMax);
        }

        Arrays.sort(prefixGcd);
        int left = 0, right = nums.length-1; long result = 0;
        while(left<right)
        {
            result += gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return result;
    }

    public int gcd(int a, int b)
    {
        while(b!=0)
        {
            int temp = b;
            b=a%b;
            a=temp;
        }
        return a;
    }
}