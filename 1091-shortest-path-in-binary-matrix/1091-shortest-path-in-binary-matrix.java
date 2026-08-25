class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        Queue<int[]> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;

        if(grid[0][0]==1 || grid[n-1][m-1]==1)
        return -1;

        if(n==1 && m==1)
        return 1;

        q.offer(new int[]{1,0,0});
        int[][] dist = new int[n][m]; 
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        dist[0][0] = 1;
        while(!q.isEmpty())
        {
            int[] node = q.peek();
            q.poll();

            int dis = node[0];
            int row = node[1];
            int col = node[2];

            for(int i=-1;i<=1;i++)
            {
                for(int j=-1;j<=1;j++)
                {
                    int dRow = row + i;
                    int dCol = col + j;


                    if(dRow>=0 && dRow<n && dCol>=0 && dCol<m && grid[dRow][dCol]==0 && dis+1<dist[dRow][dCol])
                    {
                        if(dRow == n-1 && dCol== m-1)
                        {
                            return dis + 1;
                        }
                        dist[dRow][dCol] = dis + 1;
                        q.offer(new int[]{dist[dRow][dCol], dRow, dCol});
                    }
                }
            }
        }
        return -1;
    }
}