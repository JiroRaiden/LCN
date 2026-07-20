class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int [m][n];

        for(int i=0; i<m;i++)
        {
            for(int j=0;j< n;j++)
            {
                int oldIndex = i*n + j;
                int newIndex = (oldIndex+k)%(m*n);

                int newRow = newIndex /n;
                int newCol = newIndex %n;

                ans[newRow][newCol] = grid[i][j];
            }
        } 

        List<List<Integer>> result = new ArrayList<>();

        for(int[] i: ans)
        {
            List<Integer> curr = new ArrayList<>();
            for(int j:i)
            {
                curr.add(j);
            }
            result.add(curr);
        }
        return result;
    }
}