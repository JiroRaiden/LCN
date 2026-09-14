class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int []> q = new PriorityQueue<>(Comparator.comparingInt(a-> a[1]));

        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<times.length;i++)
        {
            adj.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        int[] time = new int [n+1];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[k]=0;

        q.offer(new int[]{k,0});

        while(!q.isEmpty())
        {
            int[] arr = q.poll();
            int curr = arr[0];
            int currTime = arr[1];

            for(int[] node: adj.get(curr))
            {
                int next = node[0];
                int nextTime = node[1];

                if(nextTime + currTime < time[next])
                {
                    time[next] = nextTime + currTime;
                    q.offer(new int[]{next, time[next]});
                }
            }
        }

        int maxTime = Integer.MIN_VALUE; 
        for(int i=1;i<time.length;i++)
        {
            if(time[i]==Integer.MAX_VALUE)
            return -1;

            maxTime = Math.max(maxTime, time[i]);
        }
        return maxTime;
    }
}