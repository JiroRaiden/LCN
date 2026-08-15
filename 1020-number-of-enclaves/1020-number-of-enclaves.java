class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m = grid[0].length;
        int count =0;
        boolean[][] vis = new boolean[n][m];

        for(int i =0;i<m; i++)
        {
            if(grid[0][i]==1 && !vis[0][i])
            {
                dfs(0,i,grid,vis);
            }

            if(grid[n-1][i]==1 && !vis[n-1][i])
            {
                dfs(n-1,i,grid, vis);
            }
        }

        for(int j=0;j<n;j++)
        {
            if(grid[j][0]==1 && !vis[j][0])
            {
                dfs(j,0,grid,vis);
            }

            if(grid[j][m-1]==1 && !vis[j][m-1])
            {
                dfs(j,m-1,grid,vis);
            }
        }
        for(int i = 1;i<n-1;i++)
        {
            for(int j=1;j<m-1;j++)
            {
                if(grid[i][j]==1 && !vis[i][j])
                {
                    count++;
                }
            }
        }
        return count;
    }

    public void dfs(int row, int col , int[][]grid, boolean[][] vis)
    {
        vis[row][col] = true;
        int n=grid.length;
        int m = grid[0].length;

        int[] delRow = {-1,0,1,0};
        int[] delCol = {0,1,0,-1};

        for(int i=0;i<4;i++)
        {
            int nRow = row+ delRow[i];
            int nCol = col + delCol[i];

            if(nRow<n && nRow>=0 && nCol<m && nCol>=0 &&grid[nRow][nCol]==1 && !vis[nRow][nCol])
            dfs(nRow, nCol, grid, vis);
        }
        
    }
}