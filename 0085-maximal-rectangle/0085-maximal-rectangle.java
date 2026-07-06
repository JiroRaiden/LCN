class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea=0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] height = new int[n+1];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]=='1') height[j]++;
                else
                height[j]=0;
            }
            maxArea= Math.max(maxArea, computeMaxRectangle(height,n));
        }
        return maxArea;
    }

    public int computeMaxRectangle(int[] height, int n)
    {
        Stack<Integer> s = new Stack<>();
        int maxArea =0;
        for(int i=0;i<=n;i++)
        {
            int x = height[i];
            while(!(s.isEmpty()) &&(i==n || x<height[s.peek()]))
            {
                int top = s.pop();

                if(s.isEmpty())
                maxArea = Math.max(maxArea,i*height[top]);
                else
                maxArea = Math.max(maxArea,(i-s.peek()-1)*height[top]);
            }
            s.push(i);
        }
        return maxArea;
    }
}