class Solution {
    public int maxProduct(int n) {
        int max1= n%10;
        n=n/10;
        int max2= 0;

        int x = n;
        while(x>0)
        {
            int r = x%10;
            if(r>=max1)
            {
                max2 = max1;
                max1=r;
                x=x/10;
                continue;
            }
            if(r<=max1 && r>max2)
            max2=r;
            x=x/10;
        }
        return max1*max2;
        
    }
}