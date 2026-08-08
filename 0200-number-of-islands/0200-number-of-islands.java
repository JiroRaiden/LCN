class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int c = 0;

        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++)
        {
            for(int j =0;j<m ;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    c++;
                    dfs(visited,grid,i,j);
                }
            }
        }
        return c;
    }
    public void dfs(boolean[][] visited, char[][] grid,int row, int col)
    {
        int n = grid.length;
        int m = grid[0].length;
        visited[row][col] = true;

        for(int delRow = -1; delRow <=1; delRow++)
        {
            for(int delCol = -1;delCol<=1;delCol++)
            {
                if(delRow!=0 && delCol!=0) continue;
                int nRow = row+delRow;
                int nCol = col+delCol;
                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && grid[nRow][nCol]=='1' && !visited[nRow][nCol])
                {
                    dfs(visited, grid, nRow, nCol);
                }
            }
        }
    }
}