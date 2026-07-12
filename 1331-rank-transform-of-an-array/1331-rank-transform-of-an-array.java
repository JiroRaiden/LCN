class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        if(n==0) return new int[]{};
        int[] copy = arr.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> rank = new HashMap<>();

        int r = 1;
        rank.put(copy[0],r);
        for(int i = 1;i< copy.length;i++)
        {
            if(copy[i]!=copy[i-1])
            r++;
            rank.put(copy[i],r);
        }
        int[] result = new int[n]; 
        for(int i=0;i<n;i++)
        {
            result[i]=rank.get(arr[i]);
        }
        return result;
    }
}