class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
        
        int sum = 0;
        int n = points.length;

        boolean[] visited = new boolean[n];
        pq.offer(new int[]{0,0});
        
        while(!pq.isEmpty())
        {
            int[] node = pq.poll();
            int dist = node[0];
            int point = node[1];

            if(visited[point] == true)
            continue;

            visited[point] = true;
            sum+=dist;

            for(int i=0;i<n;i++)
            {
                if(visited[i]==true) continue;

                int distance = Math.abs(points[point][0] - points[i][0]) + Math.abs(points[point][1] - points[i][1]);

                pq.offer(new int[]{distance,i});
            }

        }
        return sum;
    }
}