class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> Integer.compare(a[0],b[0]));

        int c = 0;
        int n = intervals.length;
        for(int i=0;i<n;i++)
        {
            int tEnd = intervals[i][1];
            int left = i+1;
            int right = n-1;
            int maxVIndex = i;

            while(left<=right ){
                int mid = left+(right-left)/2;
                if(intervals[mid][0] <= tEnd)
                {
                    maxVIndex = mid;
                    left = mid +1;
                }
                else{
                    right = mid-1;
                }
            }
            c += maxVIndex - i;
        }
        return c;
    }
}