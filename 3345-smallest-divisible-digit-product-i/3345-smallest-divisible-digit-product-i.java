class Solution {
    public int smallestNumber(int n, int t) {
        while(true)
        {
            int k = calculateSum(n);
            if(k%t==0)
            {
                return n;
            }
            n++;
        }
    }
    public int calculateSum(int n)
    {
        int prod=1;
        while(n!=0)
        {
            int r = n%10;
            prod*=r;
            n=n/10;
        }
        return prod;
    }
}