class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(List<Integer> node: connections)
        {
            int a = node.get(0);
            int b = node.get(1);

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        
        int[] timer = {0};

        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                dfs(i,-1,timer, visited,bridges, adj, tin, low);
            }
        } 
        return bridges;
    }

    public void dfs(int node, int parent,int[] timer, boolean[] visited, List<List<Integer>> bridges,List<List<Integer>> adj,int[] tin, int[] low)
    {
        visited[node] = true;
        tin[node] = low[node] = timer[0]++;

        for(int neighbour: adj.get(node))
        {
            if(neighbour==parent) continue;

            if(visited[neighbour])
            low[node] = Math.min(low[node], tin[neighbour]);
            else
            {
                dfs(neighbour, node,timer, visited,bridges, adj, tin, low );

                low[node] = Math.min(low[node], low[neighbour]);
                if(low[neighbour]>tin[node])
                {
                    bridges.add(Arrays.asList(node, neighbour));
                }
            }
        }
    }
}