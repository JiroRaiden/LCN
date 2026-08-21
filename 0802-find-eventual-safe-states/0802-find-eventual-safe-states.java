class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];

        List<Integer> res = new ArrayList<>(); 
        List<List<Integer>> adjRev = new ArrayList<>();

        for(int i=0;i< n;i++)
        {
            adjRev.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            for(int j: graph[i])
            {
                adjRev.get(j).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
                res.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int node = q.peek();
            q.poll();

            for(int j: adjRev.get(node))
            {
                indegree[j]--;
                if(indegree[j]==0)
                {
                    q.offer(j);
                    res.add(j);
                }
            }
        }

        Collections.sort(res);
        
        return res;
    }
}