class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target)
            return 0;

        Map<Integer, List<Integer>> adj = new HashMap<>();
        int n = routes.length;
        for (int route = 0; route < routes.length; route++) {
            for (int stop : routes[route])
                adj.computeIfAbsent(stop, k -> new ArrayList<>()).add(route);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        for (int route : adj.getOrDefault(source, new ArrayList<>())) {
            q.offer(route);
            visited[route] = true;
        }

        int busCount = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            while (size-->0) {
                int route = q.poll();

                for (int stop : routes[route]) {
                    if (stop == target)
                        return busCount;

                    for (int nextRoute : adj.get(stop)) {
                        if (!visited[nextRoute]) {
                            q.offer(nextRoute);
                            visited[nextRoute] = true;
                        }
                    }
                }

            }
            busCount++;
        }
        return -1;
    }
}