class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[n];

        for(int i =2*n-1;i>=0;i--)
        {
            int index = i%n;
            int x = nums[index];

            while(!(s.isEmpty()) && s.peek()<=x)
            {
                s.pop();
            }
            if(i<n)
            {
            if(s.isEmpty())
            nge[index]=-1;
            else
            nge[index]=s.peek();
            }
            s.push(x);
        }

        return nge;
    }
}