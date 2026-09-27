class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;

        int[][] dist = new int[n][n];

        for(int[] i: dist)
        {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        dist[0][0] = grid[0][0];

        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        pq.offer(new int[]{dist[0][0],0,0});

        int[] dRow = {1,0,-1,0};
        int[] dCol = {0,-1,0,1};

        while(!pq.isEmpty())
        {
            int[] cell = pq.poll();
            int time = cell[0];
            int row = cell[1];
            int col = cell[2];

            if(time>dist[row][col]){
            continue;
            }

            if(row == n-1 && col == n-1)
            return time;

            for(int i =0;i<4;i++)
            {
                int nRow = row + dRow[i];
                int nCol = col + dCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<n)
                {
                    int newTime = Math.max(time,grid[nRow][nCol]);

                    if(newTime<dist[nRow][nCol])
                    {
                        dist[nRow][nCol] = newTime;
                        pq.offer(new int[]{newTime, nRow, nCol});
                    }
                } 
            }
        }
        return -1;
    }
}