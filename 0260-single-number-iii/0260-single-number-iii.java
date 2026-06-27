class Solution {
    public int[] singleNumber(int[] nums) {
        
        int xor=0;
        for(int num:nums)
        xor^=num;

        int bitDiff = xor & -xor;
        int xor1=0;
        int xor0=0;
        for(int num:nums)
        {
            if((bitDiff&num) == 0)
            xor0^=num;
            else
            xor1^=num;
        }

        if(xor0>xor1)
        return new int[]{xor0,xor1};

        return new int[]{xor1,xor0};
    }
}