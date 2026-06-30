class Solution {
    public int numberOfSubstrings(String s) {
       int count=0;
       int a=0,b=0,c=0;
        int n = s.length();
        int i=0,j=0;
        while(i<n && j<n)
        {
            char ch=s.charAt(j);
            if(ch=='a')
            a++;
            if(ch=='b')
            b++;
            if(ch=='c')
            c++;
            while(a>0 && b>0 && c>0)
            {
                char curr =s.charAt(i);
                count+=n-j;
                if(curr=='a')
                a--;
                if(curr=='b')
                b--;
                if(curr=='c')
                c--;
                i++;
            }
            
            j++;
        }
        return count; 
    }
}