class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        int[] indegree = new int[numCourses];

        for(int i=0;i<numCourses; i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] i: prerequisites)
        {
            int a = i[0];
            int b= i[1];

            indegree[a]++;
            adj.get(b).add(a);
        }

        Queue<Integer> q = new LinkedList<>(); 

        for(int i =0;i<numCourses;i++)
        {
            if(indegree[i]==0)
            q.offer(i);
        }

        int[] result = new int[numCourses];
        int index = 0;
        while(!q.isEmpty())
        {
            int course = q.poll();
            result[index++] = course;

            for(int next: adj.get(course))
            {
                indegree[next] --;
                if(indegree[next]==0)
                {
                    q.offer(next);
                }
            }

            if(index == numCourses)
            return result;
        }
        return new int[0];
    }
}