class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        if(n==1 || n==0) return 0;
        Arrays.sort(intervals, (a,b)->
            Integer.compare(a[1],b[1])
        );
        int removed = 0;
        int r = 1;
        int prev=0;
        for(int i=1 ;i< n;i++)
        {
            if(intervals[i][0]<intervals[prev][1])
            removed++;
            else
            prev = i;
        }
        return removed;
    }
}