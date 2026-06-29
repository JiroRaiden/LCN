class Solution {
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        int max=0;
        for(int x: nums)
        max = Math.max(x,max);
        
        int[] prod = new int[max+1];
        for(int i =2;i<max+1;i++)
        {
            prod[i]=i;
        }
        for(int i=2; i*i< max+1;i++)
        {
           if(prod[i]==i)
           {
                for(int j=i*i;j<max+1;j=j+i)
                {
                    if(prod[j]==j)
                    prod[j]=i;
                }
           }
        }
       
       int[] last = new int[max+1];

       for(int i=0;i<n;i++)
       {
        int x=nums[i];
        while(x>1)
        {
            int q = prod[x];
            last[q]=i;
            while(x % q == 0) x=x/q;
        }
       }
        int maxReach = 0;
       for(int i=0;i<n-1;i++)
       {
        int x = nums[i];

        while(x>1)
        {   
            int q = prod[x];
            if(last[q]>maxReach)
            maxReach = last[q];

            while(x%q==0) x=x/q;
       }
       if(i==maxReach)
       return i;
        }
    return -1;
}
}