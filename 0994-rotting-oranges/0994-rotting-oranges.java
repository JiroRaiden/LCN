class Solution {
    public int orangesRotting(int[][] grid) {
        int n  = grid.length;    
        int m  = grid[0].length;
        
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i< n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.offer(new int[]{i,j});
                }
            }
        }
        int time = bfs(grid,q);

        for(int i=0;i< n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    return -1;
                }
            }
        }
        return time;
    }
    public int bfs(int[][] grid, Queue<int[]> q)
    {
        if(q.isEmpty())
        return 0;
        
        int n = grid.length;
        int m = grid[0].length;
        
        int time = 0;

        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i =0;i< size;i++)
            {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                for(int delRow = -1; delRow<=1;delRow++)
                {
                    for(int delCol=-1;delCol<=1;delCol++)
                    {
                        int nRow = row+delRow;
                        int nCol = col+delCol;
                        if(delRow!=0 && delCol!=0) continue;

                        if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && grid[nRow][nCol]==1)
                        {
                            grid[nRow][nCol]=2;
                            q.offer(new int[]{nRow,nCol});
                        }

                    }
                }
            }
            time++;
        }
        return time-1;
    }
}