class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length; // works as visited node also
        int color = 0;
        int[] colored = new int[n];
        Arrays.fill(colored, -1);

        for (int i = 0; i < n; i++) {
            if (colored[i] == -1) {
                if (dfs(graph, i, colored, color) == false)
                    return false;
            }
        }
        return true;

    }

    public boolean dfs(int[][] graph, int curr, int[] colored, int color) {
        colored[curr] = color;

        for (int node : graph[curr]) {
            if (colored[node] == colored[curr])
                return false;
            if(colored[node]==-1)
            {
                if(!dfs(graph, node, colored, 1- color))
                return false;
            }
        }
        return true;
    }
}