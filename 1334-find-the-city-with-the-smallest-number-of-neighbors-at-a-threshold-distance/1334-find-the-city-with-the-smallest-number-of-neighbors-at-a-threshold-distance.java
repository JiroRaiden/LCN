class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        
        List<List<int[]>> adj = new ArrayList<>();
        int[] total_cities = new int[n];


        for(int i =0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i = 0;i<edges.length;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];
            int weight = edges[i][2];
            
            adj.get(u).add(new int[]{v,weight});
            adj.get(v).add(new int[]{u,weight});
        }


        for(int i = 0;i<n;i++)
        {
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)->Integer.compare(a[0],b[0]));
            pq.offer(new int[]{0,i});

            while(!pq.isEmpty())
            {
                int[] node = pq.poll();
                int curr_dist = node[0];
                int curr = node[1];
                
                if(curr_dist> dist[curr])
                continue;

                for(int[] edge: adj.get(curr))
                {
                    int neighbour = edge[0];
                    int weight = edge[1];

                    if(curr_dist + weight < dist[neighbour])
                    {
                        dist[neighbour] = curr_dist + weight;
                        pq.offer(new int[]{dist[neighbour],neighbour});
                    }
                }
            }
                for(int j=0;j<n;j++)
                {
                    if(j!=i && dist[j]<=distanceThreshold)
                    {
                        total_cities[i]++;
                    }
                }

        }   
        int min_city = Integer.MAX_VALUE;
        int result_city = 0;
        for(int i =0;i< n;i++)
        {
            if(total_cities[i]<= min_city)
            {
                min_city = total_cities[i];
                result_city = i;
            }
        }   
        return result_city;
    }
}