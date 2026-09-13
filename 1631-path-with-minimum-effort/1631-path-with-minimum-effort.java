class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int []> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        pq.add(new int[]{0,0,0});
        
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];
        for(int[] p : dist)
        Arrays.fill(p, Integer.MAX_VALUE);
        
        dist[0][0] = 0;

        int[] dRow = {-1,0,1,0};
        int[] dCol = {0,1,0,-1};
        while(!pq.isEmpty())
        {
            int[] arr = pq.poll();
            int d = arr[0];
            int r = arr[1];
            int c = arr[2];
            
            if(r==n-1 && c==m-1)
            return d;

            for(int i = 0; i<4; i++)
            {
                int nRow = r + dRow[i];
                int nCol = c + dCol[i];

                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m)
                {
                    int newD = Math.max(d, Math.abs(heights[nRow][nCol] - heights[r][c]));
                    if(newD<dist[nRow][nCol])
                    {
                        dist[nRow][nCol]=newD;
                        pq.add(new int[]{newD,nRow,nCol});
                    }
                }
            }
        }
        return 0;
    }
}