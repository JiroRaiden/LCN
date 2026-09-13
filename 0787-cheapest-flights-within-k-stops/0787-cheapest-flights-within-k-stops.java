class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue<int []> pq = new LinkedList<>();

        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i =0;i<flights.length;i++)
        {
            adj.get(flights[i][0]).add(new int[]{flights[i][1], flights[i][2]});
        }

        int[] stopsPrice = new int[n];

        Arrays.fill(stopsPrice, Integer.MAX_VALUE);

        pq.offer(new int[]{src,0,0});

        while(!pq.isEmpty())
        {
            int[] arr = pq.poll();
            int curr = arr[0];
            int totalStops = arr[1];
            int currPrice = arr[2];
            
            if(totalStops>k) continue;

            for(int[] adjNode : adj.get(curr))
            {
                int nextStop = adjNode[0];
                int nextPrice = adjNode[1];

                if( nextPrice + currPrice< stopsPrice[nextStop] && totalStops<=k )
                {
                    stopsPrice[nextStop] = nextPrice + currPrice;
                    pq.offer(new int[]{nextStop, totalStops+1,currPrice+nextPrice});
                }
            }
        }
        if(stopsPrice[dst] == Integer.MAX_VALUE)
        {
            return -1;
        }
        return stopsPrice[dst];
    }
}