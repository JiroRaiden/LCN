class Solution {
    public int trap(int[] height) {
        int n = height.length;
        Deque<Integer> s= new ArrayDeque<>();
        int totalWater =0;
        for(int i=0;i< n;i++)
        {
            while(!(s.isEmpty()) && height[i]>height[s.peek()])
            {
                int idx = s.peek();
                s.pop();
                if(!(s.isEmpty()))
                totalWater+= (Math.min(height[s.peek()],height[i]) - height[idx]) * (i-s.peek()-1);
            }
            s.push(i);
        }
        return totalWater;
    }
}