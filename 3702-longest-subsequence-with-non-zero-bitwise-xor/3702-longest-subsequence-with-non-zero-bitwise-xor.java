class Solution {
    public int longestSubsequence(int[] nums) {

        int n = nums.length;
        boolean allZero = true;
        int xor = 0;
        for(int x: nums)
        {
            xor = xor^x;
            if(x!=0)
            allZero = false;
        }

        if(allZero) return 0;
        if(xor==0) return n-1; else return n;
    }
}