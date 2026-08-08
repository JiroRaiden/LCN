class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        boolean[] visited = new boolean[n*n+1];

        List<List<Integer>> adjList = new ArrayList<>();

        for(int i = 0;i<=n;i++)
        {
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(isConnected[i][j]==1 && i!=j)
                adjList.get(i+1).add(j+1);
            }
        }

        for(int i = 1;i<=n;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i , visited, adjList);
            }
        }
        return count;
    }

    public void dfs(int node , boolean[] visited, List<List<Integer>> adjList)
    {
        visited[node]=true;
        
        for(int neighbour: adjList.get(node))
        {
            if(!visited[neighbour])
            dfs(neighbour, visited, adjList);
        }
    }
}