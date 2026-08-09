class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int orgColor = image[sr][sc];
        if(color == orgColor) return image;
        dfs(image, sr,sc,color,orgColor);
        return image;
    }

    public void dfs(int[][] image, int row, int col, int color, int orgColor)
    {
        int n = image.length;
        int m = image[0].length;
        image[row][col]=color;

        for(int delRow=-1;delRow<=1;delRow++)
        {
            for(int delCol=-1;delCol<=1;delCol++)
            {
                if(delRow!=0 && delCol!=0) continue;

                int nRow = row+delRow;
                int nCol = col+delCol;

                if(nRow>=0 && nRow <n && nCol>=0 && nCol<m && image[nRow][nCol]==orgColor)
                dfs(image, nRow, nCol, color,orgColor);
            }
        }
    }
}