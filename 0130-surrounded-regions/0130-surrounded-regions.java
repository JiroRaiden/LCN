class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];

        for(int i = 0;i< n;i++)
        {
            if(board[i][0]=='O' && !vis[i][0])
            {
                dfs(i,0,board,vis);
            }

            if(board[i][m-1]=='O' && !vis[i][m-1])
            {
                dfs(i,m-1,board, vis);
            }
        }
        for(int j = 0;j< m;j++)
        {
            if(board[0][j]=='O' && !vis[0][j])
            {
                dfs(0,j,board,vis);
            }
            if(board[n-1][j]=='O' && !vis[n-1][j])
            {
                dfs(n-1,j,board,vis);
            }
        }

        for(int i = 1;i< n-1;i++)
        {
            for(int j =1;j<m-1;j++)

            {
                if(!vis[i][j] && board[i][j]=='O')
                board[i][j]='X';
            }
        }
    }
    public void dfs(int row, int col, char[][] board, boolean[][] vis)
    {
        int n = board.length;
        int m = board[0].length;
        vis[row][col] = true;

        int[] delRow= {-1,0,1,0};
        int[] delCol= {0,1,0,-1};

        for(int i = 0;i< 4;i++)
        {
            int nRow = row + delRow[i];
            int nCol = col + delCol[i];

            if(nRow<n && nRow>=0 && nCol <m && nCol >=0 && board[nRow][nCol]=='O' && (!vis[nRow][nCol]) )
            dfs(nRow, nCol, board, vis);
        }
    }
}