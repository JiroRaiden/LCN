class Solution {
    public int minMoves(int[] nums) {
        int moves = 0;
        int max_num = Integer.MIN_VALUE;
        for(int num:nums)
        {
            max_num = Math.max(num, max_num);
        }

        for(int num:nums)
        moves+=max_num-num;

        return moves;
    }
}