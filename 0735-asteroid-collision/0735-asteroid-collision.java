class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque <Integer> s = new ArrayDeque<>();
        int flag=0;
        for(int i=0;i<n;i++)
        {
            flag=0;
            int x = asteroids[i];
            while(!(s.isEmpty()) && s.peek()>0 && x<0)
            {
                if(Math.abs(s.peek())<Math.abs(x))
                {
                    s.pop();   
                }
                else if(Math.abs(s.peek())>=Math.abs(x))
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            s.push(x);
            else if(flag==1 && Math.abs(s.peek())==Math.abs(x))
            s.pop();
        }

        int[] result = new int[s.size()];
        for(int i=s.size()-1;i>=0;i--)
        {
            result[i]=s.pop();
        }
        return result;
    }
}