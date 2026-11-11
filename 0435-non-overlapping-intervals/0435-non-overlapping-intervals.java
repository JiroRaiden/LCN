class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[1],b[1]));
        
        int count =0 ;
        int lastEnd = Integer.MIN_VALUE;
        for(int[] interval: intervals)
        {
            if(interval[0]>=lastEnd)
            {
                count++;
                lastEnd = interval[1];
            }
        }
        return intervals.length-count;
    }
}