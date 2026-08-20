class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = prerequisites.length;
        int[] res = new int[numCourses];
        int index=0;

        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i<numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int i =0;i<n;i++)
        {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses;i++)
        {
            for(int j: adj.get(i))
            {
                indegree[j]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            {
                q.offer(i);
            }
        }

        while(!q.isEmpty())
        {
            int node = q.peek();
            res[index++]=node;
            q.poll();

            for(int i:adj.get(node))
            {
                indegree[i]--;
                if(indegree[i]==0)
                q.offer(i);
            }
        }

        if(index == numCourses)
        return res;

        return new int[0];
    }
}