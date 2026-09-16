class Solution {
    int stoneSum;
    int target;
    int stones[];

    Map<String , Integer> mp = new HashMap<>();

    public int lastStoneWeightII(int[] stones) {
        this.stones = stones;
        for(int stone: stones)
        stoneSum+=stone;

        target = (stoneSum + 1) / 2;

        return dfs(0,0);
    }

    public int dfs(int index, int totalSum)
    {
        if(totalSum>=target || index == stones.length)
        {
            return Math.abs(totalSum - (stoneSum - totalSum));
        }

        String key = index + "," + totalSum;

        if(mp.containsKey(key))
        return mp.get(key);

        int skip = dfs(index+1, totalSum);
        int take = dfs(index+1, totalSum + stones[index]);

        mp.put(key, Math.min(skip, take));

        return mp.get(key);
    }
}