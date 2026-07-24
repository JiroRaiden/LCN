class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int max = 2048;

        boolean[] unique = new boolean[max];

        for(int num: nums)
        {
            unique[num]=true;
        }        
        int totalUnique=0;
        int[] uniqueNos = new int[max];

        for(int num: nums)
        {
            if(unique[num]==true)
            {
                uniqueNos[totalUnique]= num;
                totalUnique ++;
            }
        }

        boolean[] xor2 = new boolean[max];
        for(int i = 0;i< totalUnique;i++)
        {
            for(int j = i; j< totalUnique;j++)
            {
                xor2[uniqueNos[i] ^ uniqueNos[j]]=true;
            }
        }

        boolean[] xor3 = new boolean[max];
        int uniqueTriplets = 0;

        for(int i =0;i< totalUnique;i++)
        {
            for(int j=0;j<max;j++)
            {
                if(xor2[j]==true)
                {
                    int xor = uniqueNos[i] ^ j;
                    if(xor3[xor]==false)
                    {
                        xor3[xor]=true;
                        uniqueTriplets++;
                    }
                }
            }
        }
        return uniqueTriplets;

    }
}