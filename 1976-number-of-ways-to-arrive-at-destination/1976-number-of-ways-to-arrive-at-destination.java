class Solution {
    public int countPaths(int n, int[][] roads) {

        final int MOD = 1_000_000_007;

        PriorityQueue<long []> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a[1]));
        
        List<List<long[]>> adj = new ArrayList<>();
        long[] time = new long[n];
        Arrays.fill(time,Long.MAX_VALUE);
        int[] ways = new int[n];
        ways[0]=1;
        
        time[0] = 0;
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        //Buildi bidirectional graph
        for(int i=0;i<roads.length;i++)
        {
            adj.get(roads[i][0]).add(new long[]{roads[i][1], roads[i][2]});
            adj.get(roads[i][1]).add(new long[]{roads[i][0], roads[i][2]});
        }

        pq.offer(new long[]{0,0});

        int minTime = Integer.MAX_VALUE;

        while(!pq.isEmpty())
        {
            long[] arr = pq.poll();
            int curr = (int)arr[0];
            long currTime = arr[1];

            for(long[] node: adj.get(curr))
            {
                int next = (int)node[0];
                long nextTime = node[1];
                
                if(currTime + nextTime < time[next])
                {
                    time[next] = currTime+nextTime;
                    ways[next] = ways[curr];
                    pq.offer(new long[]{next, time[next]});
                } 
                else if(currTime + nextTime == time[next])
                {
                    ways[next] = (ways[next] + ways[curr]) % MOD;
                } 
            }
        }
        return (int)ways[n-1];
    }
}