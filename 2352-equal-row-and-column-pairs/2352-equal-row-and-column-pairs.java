class Solution {
    public int equalPairs(int[][] grid) {
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        int n = grid.length;
        for(int i=0;i<n;i++)
        {
            sb = new StringBuilder();
            for(int j=0;j<n;j++)
            {
                sb.append(grid[i][j]).append("#");
            }
            String row = sb.toString();

            map.put(row, map.getOrDefault(row,0)+1);
        }
        int count = 0;
        for(int j=0;j<n;j++)
        {
            sb = new StringBuilder();
            for(int i=0;i<n;i++)
            {
                sb.append(grid[i][j]).append("#");
            }
            String col = sb.toString();

            count+= map.getOrDefault(col,0);
        }
        return count;
    }
}