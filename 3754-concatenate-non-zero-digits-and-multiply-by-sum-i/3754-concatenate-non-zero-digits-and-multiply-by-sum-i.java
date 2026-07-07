class Solution {
    public long sumAndMultiply(int n) {
        long sum=0;
        long sumDig=0;
        long p=1;
        while(n!=0)
        {
            int r = n%10;
            sumDig+=r;
            if(r!=0)
            {
                sum=sum + r*p;
                p*=10;
            }
            n=n/10;
        }
        return sum*sumDig;
    }
}