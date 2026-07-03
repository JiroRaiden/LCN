class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n= arr.length;
        long sum=0;
        Deque<Integer> s = new ArrayDeque<>();
        int[] pse = new int[n];
        int[] nse = new int[n];
        int MOD = 1000000007;
        
        for(int i =0;i<n;i++)
        {
            int x = arr[i];

            while(!(s.isEmpty()) && x < arr[s.peek()])
            s.pop();
            
            if(s.isEmpty())
            pse[i]=-1;
            else
            pse[i]= s.peek();

            s.push(i);

        }

        s = new ArrayDeque<>();

        for(int i =n-1;i>=0;i--)
        {
            int x = arr[i];

            while(!(s.isEmpty()) && x <= arr[s.peek()])
            s.pop();
            
            if(s.isEmpty())
            nse[i]=n;
            else
            nse[i]= s.peek();

            s.push(i);

        }


        for(int i =0;i< n;i++)
        {
            sum+= (1L* (i-pse[i]) * (nse[i] - i) )%MOD*1L *arr[i];                
        }

        return (int)(sum%MOD);
    }
}