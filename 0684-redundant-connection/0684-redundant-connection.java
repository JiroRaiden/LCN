class Solution {

    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];

        // Initially, every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // If both nodes already have the same root,
            // adding this edge creates a cycle
            if (find(u) == find(v)) {
                return edge;
            }

            // if hte parents are not same connect their components
            union(u, v);
        }

        return new int[0];
    }

    private int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }

    private void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        parent[rootA] = rootB;
    }
}