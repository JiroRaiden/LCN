class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        int[] nse = new int[n];
        int[] nge = new int[n];
        int[] pse = new int[n];
        int[] pge = new int[n];
        for(int i=0; i<n;i++)
        {
            int x = nums[i];

            while(!(s1.isEmpty()) && x<nums[s1.peek()])
            s1.pop();

            if(s1.isEmpty())
            pse[i] = -1;
            else
            pse[i] = s1.peek();

            s1.push(i);

            while(!(s2.isEmpty()) && x>nums[s2.peek()])
            s2.pop();

            if(s2.isEmpty())
            pge[i] = -1;
            else
            pge[i] = s2.peek();

            s2.push(i);
        }

        s1= new Stack<>();
        s2= new Stack<>();

        for(int i=n-1;i>=0;i--)
        {
            int x=nums[i];

            while(!(s1.isEmpty()) && x<=nums[s1.peek()])
            s1.pop();

            if(s1.isEmpty())
            nse[i]=n;
            else
            nse[i]=s1.peek();

            s1.push(i);

            while(!(s2.isEmpty()) && x>=nums[s2.peek()])
            s2.pop();

            if(s2.isEmpty())
            nge[i]=n;
            else
            nge[i]=s2.peek();

            s2.push(i);
        }

        long minContribution=0;
        long maxContribution=0;
        for(int i=0;i<n;i++)
        {
            minContribution+=1L*(i-pse[i])*(nse[i]-i)*nums[i];
            maxContribution+=1L*(i-pge[i])*(nge[i]-i)*nums[i];
        }
        return maxContribution-minContribution;
    }
}