class Solution {

    public class node{
        int row;
        int col;
        int dist;
        node(int row, int col, int dist)
        {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }
    }
    public int[][] updateMatrix(int[][] mat) {
        
        int m = mat.length;
        int n = mat[0].length;

        Queue<node> q = new LinkedList<>(); 
        boolean[][] vis = new boolean[m][n];
        int[][] dist = new int[m][n];

        for(int i=0;i< m;i++)
        {
            for(int j=0;j< n;j++)
            {
                if(mat[i][j]==0)
                {
                    vis[i][j] = true;
                    q.offer(new node(i,j,0));
                }
                else
                vis[i][j] = false;
            }
        }
        while(!q.isEmpty())
        {
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().dist;

            q.poll();

            dist[row][col]=step;

            int[] delRow = {-1,0,1,0}; 
            int[] delCol = {0,1,0,-1};

            for(int i =0 ;i<4;i++)
            {
                int nRow = row + delRow[i];
                int nCol = col + delCol[i];

                if(nRow>=0 && nRow < m && nCol>=0 && nCol<n && vis[nRow][nCol]==false)
                {
                    vis[nRow][nCol] = true;
                    q.offer(new node(nRow,nCol, step+1));
                }
            } 
        }
        return dist;
    }
}