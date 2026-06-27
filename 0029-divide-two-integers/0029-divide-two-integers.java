class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor ==-1) return Integer.MAX_VALUE;
        
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);
        int shift =0;
        int ans = 0;
        while(n>=d)
        {
            shift = 0;
            while(n>=(d<<(shift+1)))
            shift++;

            ans += (1<<shift);

            n-=d << shift;

        }
        return (isNegative)?-ans:ans;
    }
}