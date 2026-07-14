class Solution {
    static final int MOD = 1_000_000_007;
    int[][][] memo;
    int[][] gcdTable = new int[201][201];
    
    public int subsequencePairCount(int[] nums) {

        memo = new int[nums.length+1][201][201];
        
        for(int[][] layer: memo)
        {
            for(int[] row: layer)
            Arrays.fill(row,-1);
        }
        for (int i = 0; i <= 200; i++) {
        for (int j = 0; j <= 200; j++) {
            gcdTable[i][j] = gcd(i, j);
        }
    }
        return solve(nums,0,0,0);
    }
    public int solve(int[] nums, int index, int first, int second)
    {
        if(index == nums.length)
        {
            if(first!=0 && second!=0 && first == second)
            return 1;
            return 0;
        }
        if(memo[index][first][second]!=-1)
        return memo[index][first][second];

        int skip = solve(nums,index+1, first, second);
        int seq1 = solve(nums,index+1, gcdTable[first][nums[index]], second);
        int seq2 = solve(nums,index+1, first, gcdTable[second][nums[index]]);

        return memo[index][first][second] = (int)((0L+skip+seq1+seq2) % MOD);
    }
    public int gcd(int a, int b)
    {
        while(b!=0)
        {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}