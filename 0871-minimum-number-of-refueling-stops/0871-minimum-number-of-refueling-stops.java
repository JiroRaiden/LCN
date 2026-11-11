class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        int fuel = startFuel;
        int prev = 0;
        int stops=0;

        for(int i=0;i<=stations.length;i++)
        {
            int curr = (i==stations.length)?target:stations[i][0];
            fuel-= curr-prev;

            while(fuel<0)
            {
                if(pq.isEmpty())
                return -1;

                fuel+= pq.poll();
                stops++;
            }
            prev=curr;
            
            if(i<stations.length)
            pq.offer(stations[i][1]);
        }
        return stops;
    }
}