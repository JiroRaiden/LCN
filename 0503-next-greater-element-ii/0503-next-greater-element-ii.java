class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> s = new Stack<>();
        int[] nge = new int[2*n];

        for(int i =2*n-1;i>=0;i--)
        {
            int index = i%n;
            int x = nums[index];

            while(!(s.isEmpty()) && s.peek()<=x)
            {
                s.pop();
            }
            if(s.isEmpty())
            nge[i]=-1;
            else
            nge[i]=s.peek();

            s.push(x);
        }

        for(int i = 0;i<n;i++)
        {
            result[i]=nge[i];
        }
        
        return result;
    }
}