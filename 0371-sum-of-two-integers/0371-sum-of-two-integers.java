class Solution {
    public int getSum(int a, int b) {
        int carry = (a&b)<<1;
        int sum=a^b;
        while(carry!=0)
        {
            int oldSum=sum;
            sum = sum^carry;
            
            carry = (oldSum&carry)<<1;
        }
        return sum;
    }
}