class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> merged = new ArrayList <>();
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));

        for(int interval[] : intervals)
        {
            if(merged.isEmpty() || merged.get(merged.size()-1).get(1) < interval[0])
            merged.add(Arrays.asList(interval[0],interval[1]));

            else
            {
                int last = merged.size() -1;
                int maxEnd = Math.max(interval[1], merged.get(last).get(1));
                merged.get(last).set(1,maxEnd);
            }
        }

        //converting list to 2D array
        int [][]result = new int[merged.size()][2];
        for(int i =0; i< merged.size(); i++)
        {
            result[i][0] = merged.get(i).get(0);
            result[i][1] = merged.get(i).get(1);
        }
        return result;
    }
}