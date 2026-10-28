class Solution {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> bridges = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        
        boolean vis[] = new boolean[n];
        int tin[] = new int[n];
        int low[] = new int[n];

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(List<Integer> node: connections)
        {
            int u = node.get(0);
            int v = node.get(1);

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] timer = {0};
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                dfs(i,-1,adj,vis,timer,bridges,tin,low);
            }
        }
        return bridges;
    }

    private void dfs(int node, int parent, List<List<Integer>> adj,boolean [] vis, int[] timer, List<List<Integer>> bridges,int[] tin, int[] low)
    {
        vis[node] = true;
        tin[node]=low[node]=timer[0]++;

        for(int neighbour: adj.get(node))
        {
            if(neighbour==parent) continue;

            if(vis[neighbour])
            low[node] = Math.min(low[node],low[neighbour]);
            else
            {
                dfs(neighbour,node,adj,vis,timer,bridges,tin,low);

                low[node] = Math.min(low[node],low[neighbour]);

                if(low[neighbour]>tin[node])
                {
                    bridges.add(Arrays.asList(node,neighbour));
                }
            }
        }
    }
}