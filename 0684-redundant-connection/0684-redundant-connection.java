class Solution {
    class Node
    {
        int first;
        int second;

        Node(int first, int second)
        {
            this.first = first;
            this.second = second;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = edges.length;

        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());


        for(int[] edge: edges)
        {
            boolean[]vis = new boolean[n+1];
            int u = edge[0];
            int v = edge[1];
            if(isCycle(adj,u,v,vis))
            {
                return new int[]{u,v};
            }

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return new int[0];
    }
    public boolean isCycle(List<List<Integer>> adj, int u , int v, boolean[]vis)
    {
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(u, -1));
        vis[u]= true;

        while(!q.isEmpty())
        {
            int child = q.peek().first;
            int parent = q.peek().second;
            q.poll();

            if(child==v) return true;


            for(int i: adj.get(child))
            {
                if(!vis[i])
                {
                    vis[i] = true;
                    q.add(new Node(i,child));
                }
            }
        
        }
        return false;
    }
}