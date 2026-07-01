class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        // Step 1: Compute distance of every cell to nearest thief
        int[][] dist = new int[n][n];
        for (int[] row : dist)
            Arrays.fill(row, -1);

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            for (int[] d : dirs) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        // Step 2: Max Heap (Maximum Bottleneck Path)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        boolean[][] vis = new boolean[n][n];

        pq.offer(new int[]{0, 0, dist[0][0]});
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            int r = cur[0];
            int c = cur[1];
            int safe = cur[2];

            if (r == n - 1 && c == n - 1)
                return safe;

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    pq.offer(new int[]{
                        nr,
                        nc,
                        Math.min(safe, dist[nr][nc])
                    });
                }
            }
        }

        return 0;
    }
}