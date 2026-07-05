class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nse = new int[n];
        int[] pse = new int[n];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<n;i++)
        {
            int x = heights[i];
            
            while(!(stack.isEmpty()) && x<heights[stack.peek()])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            pse[i]=-1;
            else
            pse[i]=stack.peek();

            stack.push(i);
        }
        stack = new Stack<>();
        for(int i=n-1;i>=0;i--)
        {
            int x = heights[i];
            
            while(!(stack.isEmpty()) && x<=heights[stack.peek()])
            {
                stack.pop();
            }
            if(stack.isEmpty())
            nse[i]=n;
            else
            nse[i]=stack.peek();

            stack.push(i);
        }

        int maxRectangle = Integer.MIN_VALUE;
        for(int i =0;i<n;i++)
        {  
            maxRectangle = Math.max(maxRectangle, (nse[i]-pse[i]-1)*heights[i]);
        }
        return maxRectangle;
    }
}