class Solution {
    public boolean checkValidString(String s) {
        
        int minOpen = 0;
        int maxOpen = 0;

        int n = s.length();
        int r=0;
        int adapt =0;
        while(r<n)
        {
            if(s.charAt(r)=='(')
            {
                minOpen ++;
                maxOpen++;
            }
            else if(s.charAt(r)=='*')
            {
                minOpen--;
                maxOpen++;
            }
            else if(s.charAt(r)==')')
            {
                minOpen--;
                maxOpen--;
            }
            if(maxOpen<0)
            return false;
            if(minOpen<0)
            minOpen=0;

            r++;
        }


        return minOpen==0;

    }
}