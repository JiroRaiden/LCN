class Solution {
    public int uniquePathsIII(int[][] grid) {
        
        int result = 0;
        int row =0;
        int col =0;
        int remaining=0;
        for(int i=0;i<grid.length;i++)
        {
            for(int j =0;j< grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    row=i;
                    col=j;
                }
                if(grid[i][j]!=-1)
                remaining++;
            }
        }
        result+=backtrack(grid,row,col,remaining);
        return result;
    }

    public int backtrack(int[][] grid, int row, int col,int remaining)
    {
        if(grid[row][col]==2)
        {   
            if( remaining ==1)
            {
                return 1;
            }
            return 0;
        }
        int result =0;
        //poison current cell
        int temp = grid[row][col];
        grid[row][col]=-1;
        //up
        if(row>0 && (grid[row-1][col]==0 || grid[row-1][col]==2))
        {
            result += backtrack(grid,row-1,col,remaining-1);
        }
        //down
        if(row<grid.length-1 && (grid[row+1][col]==0 || grid[row+1][col]==2))
        {
            result+= backtrack(grid,row+1,col,remaining-1);
        }
        //left
        if(col>0 && (grid[row][col-1]==0 || grid[row][col-1]==2))
        {
            result+=backtrack(grid,row,col-1,remaining-1);
        }
        //right
        if(col<grid[0].length-1 && (grid[row][col+1]==0 || grid[row][col+1]==2))
        {
            result+=backtrack(grid,row,col+1,remaining-1);
        }
        //unpoison current cell
        grid[row][col]=temp;
        return result;
    }
}