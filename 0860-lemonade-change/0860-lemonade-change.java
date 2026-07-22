class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int n = bills.length;
        int r = 0;
        while(r<n)
        {
            if(bills[r]==5)
            five ++;
            else if(bills[r]==10 && five>0)
            {
                five--;
                ten++;
            }
            else if(bills[r]==10 && five == 0)
            return false;
            else if(bills[r]==20 && five>0 && ten >0)
            {
                five--;
                ten--;
            }
            else if(bills[r]==20 && five>=3 && ten ==0)
            five-=3;
            else
            return false;

            r++;
        }
        return true;
    }
}