class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] inEdge= new int[n+1];
        int[] outEdge= new int[n+1];

        for(int[] edge: trust)
        {
            int from = edge[0];
            int to = edge[1];

            outEdge[from]++;
            inEdge[to]++;
        }

        for(int i=1;i<=n;i++)
        {
            if(inEdge[i]==(n-1) && outEdge[i]==0)
            {
                return i;
            }
        }
        return -1;
    }
}