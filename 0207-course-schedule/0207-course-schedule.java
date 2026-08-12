class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0;i< numCourses;i++)
        {
            adj.add(new ArrayList<>());
        }

        for(int[] pre: prerequisites)
        {
            int course = pre[0];
            int prerequisite = pre[1];
            adj.get(prerequisite).add(course);
        }

        //0->no visited ; 1->currently visiiting 2->safely visited
        int[] status = new int[numCourses];

        for(int i = 0;i< numCourses;i++)
        {
            if(status[i]==0 && isCycle(adj, status,i))
            return false; //cycle detected we cannot complete the course
        }
        return true;
    }

    public boolean isCycle(List<List<Integer>> adj,int[] status, int curr)
    {
        if(status[curr]==1)
        return true; //we were already visiting this earlier this means this is the 2nd time we are seeing this course which indicates this is a cycle

        if(status[curr]==2)
        return false;//we safely visited this without encountering any cycle

        status[curr]=1;
        for(int neighbour: adj.get(curr))
        {
            if(isCycle(adj, status, neighbour))
            return true;
        }
        status[curr]=2;
        return false;
    }
}